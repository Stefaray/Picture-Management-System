package image;

import Dao.Image;
import Dao.User;
import Service.ReturnDate;
import Sql.AccessImges;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(value = "/uploadTestServlet")
public class UploadImageServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;


    /** 总上传文件最大为10M*/
    private static final Long TOTAL_FILE_MAXSIZE = 10000000L;
    /** 单个上传文件最大为10M*/
    private static final int SINGLE_FILE_MAXSIZE = 2*1024*1024;

    @Override public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        /** 上传目录名*/
        System.out.println("到上传着了");
        //获取用户名以及类别
        HttpSession session=request.getSession();
        String username=((User)session.getAttribute("User")).getUsername();


        String dir=request.getParameter("dir");
        String imgString=request.getParameter("imgs");

        if(dir!=null&&dir.length()!=0)
        session.setAttribute("current_dir",dir);
        if(imgString!=null&&imgString.length()!=0)
        session.setAttribute("upload_img",imgString);

       if(dir==null||dir.length()==0)
            dir=(String) session.getAttribute("current_dir");
        if(imgString==null||imgString.length()==0)
            imgString=(String) session.getAttribute("upload_img");

        System.out.println("dir:"+dir);
        System.out.println("imgString:"+imgString);
        ObjectMapper mapper=new ObjectMapper();
        Image[] images=mapper.readValue(imgString,Image[].class);



        for(Image image:images) {
            image.setUser(username);
            System.out.println(image);
            image.setCreat_time(ReturnDate.returnDate());
            //待会要取消这部分注释
            addPic(image,username,dir);
        }


         String UPLOAD_DIR = "imageStore/"+username+"/"+dir;

//        /** 上传临时文件存储目录*/
//         String TEMP_UPLOAD_DIR ="uploadDir/temp/";

        System.out.println("UploadTestServlet in");
        //设置编码格式，前端后台统一是utf-8
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        //
        PrintWriter out = response.getWriter();
        // Servlet上下文对象
        ServletContext servletContext = this.getServletConfig().getServletContext();
        // tomcat的项目路径
        String realPath = servletContext.getRealPath(UPLOAD_DIR)+"/";
        System.out.println(realPath);

        File realPathFile = new File(realPath);

        if (!realPathFile.exists()) {
            realPathFile.mkdirs();
        }

        // 文件对象的工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置最大上传大小
        factory.setSizeThreshold(SINGLE_FILE_MAXSIZE);
        // 将临时文件夹交给文件对象的工厂类
//        factory.setRepository(tempPathFile);
        // 创建一个上传文件的处理者
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置所有请求的总大小
        upload.setSizeMax(TOTAL_FILE_MAXSIZE);
        // 解析request

        List<FileItem> items;
        try {
            items = upload.parseRequest(request);
            // 处理解析处理的请求对象
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                //判断是文件还是文本
                if (!item.isFormField()) {
                    //文件名加上UUid，可以防止重复
                    //String fileName = UUID.randomUUID().toString().replace("-", "")+"_"+item.getName();
                    String fileName = item.getName();
                    System.out.println(item.getContentType());
                    System.out.println("UploadTestServlet file path:"+UPLOAD_DIR+"/"+fileName);

                    //判断空
                    if (fileName!=null && !"".equals(fileName)) {
                        //将文件写到硬盘
                        item.write(new File(realPath+fileName));
                        //将图片地址保存到request中，再转发回给jsp
                        //UPLOAD_DIR+fileName这个是相对路径，给前端页面
                        //realPath+fileName是绝对路径
                        //request.setAttribute("path", UPLOAD_DIR+fileName);
                        //request.getRequestDispatcher("/test/UploadTest.jsp").forward(request, response);
                        System.out.println("成功写入磁盘");
                    }
                }
            }
        } catch (Exception e) {
        }
        response.sendRedirect(request.getContextPath()+"/user/new.html");
    }


    private static synchronized void addPic(Image image,String username,String dir) throws ServletException, IOException {
        if (!AccessImges.exists(image.getName(), username, dir)) {
            System.out.println(image.getName() + username + dir);

            PostImagesToMysql.process("add", image, null);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
