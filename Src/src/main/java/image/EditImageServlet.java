package image;

import Dao.Image;
import Service.ReturnDate;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(value = "/editImageServlet")
public class EditImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("到这");
        String old_image_name=req.getParameter("old_image_name");
        System.out.println("old_name:"+old_image_name);
        ObjectMapper mapper=new ObjectMapper();
        String imgString=req.getParameter("image");
//        System.out.println(imgString);
        Image image=mapper.readValue(imgString,Image.class);
        image.setDir((String) req.getSession().getAttribute("current_dir"));
        image.setEdit_time(ReturnDate.returnDate());
        System.out.println("in EditImageServlet:"+image);
        PostImagesToMysql.process("edit",image,old_image_name);
        ServletContext servletContext=this.getServletContext();
        if(!image.getName().equals(old_image_name)){
            String oldRealPath=servletContext.getRealPath(
                    "/imageStore/"+image.getUser()+"/"+image.getDir()+"/"+old_image_name);
            String newRealPath=servletContext.getRealPath(
                    "/imageStore/"+image.getUser()+"/"+image.getDir()+"/"+image.getName());
//            System.out.println("oldPath:"+oldRealPath);
//            System.out.println(newRealPath);
            rename(oldRealPath,newRealPath);
        }
    }
    public static void rename(String oriPath,String renamePath){
//        System.out.println("开始重命名");
        File file=new File(oriPath);

        if(file==null){
            System.out.println("空路径");
        }
        else{
            System.out.println(file.getName()+"开始重命名");
        }
        if(file.renameTo(new File(renamePath)))
            System.out.println("重命名success");
        else
            System.out.println("重命名fail");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

