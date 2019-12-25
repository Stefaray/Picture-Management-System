package Service;

import Dao.OpRecord;
import Dao.User;
import Sql.AccessRecord;
import Sql.AccessUserdirs;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.AddressMapping;
import domain.Dir;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet(value = "/postDirServlet")
public class PostDirServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名
        String username=((User)req.getSession().getAttribute("User")).getUsername();
//        System.out.println("here2");

        String[] dirlist=req.getParameterValues("dirs[]");
        System.out.println(dirlist);
        //判断目录是否存在，不存在就创建
        String address="."+ AddressMapping.userDirMapping(username);
        String realPath=this.getServletContext().getRealPath(address);
//        System.out.println(realPath);
        File file=new File(realPath);



        if(!file.exists()&&!file.isDirectory()){
            System.out.println(address+"目录不存在，创建");
            boolean success=file.mkdir();
//            System.out.println(success);
        }
        for(String dir:dirlist){
            String kindDir=this.getServletContext().getRealPath(address+"/"+dir);
            File fileDir=new File(kindDir);
            if(!fileDir.exists()&&!fileDir.isDirectory()){
                System.out.println(kindDir+"目录不存在，创建");
                boolean success=fileDir.mkdir();
//                System.out.println(success);
            }
        }
////
//        //传送目录信息
        Dir dir=new Dir();
        dir.setDirs(dirlist);

        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(dir);
        OpRecord record=new OpRecord();
        record.setModify_time(ReturnDate.returnDate());
        record.setUsername(username);
        record.setItem_type("类别");
        StringBuilder item_name=new StringBuilder();
        for(int i=0;i<dirlist.length;i++){
            item_name.append(dirlist[i]);
            if(i<dirlist.length-1){
                item_name.append("和");
            }
        }
        record.setItem_name(item_name.toString());
        if(!AccessUserdirs.exists(username)) {
            AccessUserdirs.add(username, json);
            record.setOperation("新增了");
        }
        else {
            AccessUserdirs.update(username, json);
            record.setOperation("更新了");
        }
        AccessRecord.add(record);
        if(AccessRecord.totalCount()>50){
            AccessRecord.delHalf();
        }
        resp.getWriter().write("hello");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
