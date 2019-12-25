package Service;

import Sql.AccessUserdirs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//前端get目录的信息

@WebServlet(value = "/getDirServlet")
public class GetDirServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名
        String username=req.getParameter("username");
        //传送目录信息

        resp.setCharacterEncoding("UTF-8");

        //        ObjectMapper mapper=new ObjectMapper();
        String dirs=AccessUserdirs.askDir(username);
//        System.out.println(dirs+"到这了");
        resp.getWriter().write(dirs);//
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
