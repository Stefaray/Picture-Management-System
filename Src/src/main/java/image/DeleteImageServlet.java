package image;

import Dao.Image;
import Dao.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteImageServlet")
public class DeleteImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ObjectMapper mapper=new ObjectMapper();
        System.out.println("here");
        String img_name=req.getParameter("img_name");
        String username=((User)req.getSession().getAttribute("User")).getUsername();
        String dir=req.getParameter("dir");
        Image image=new Image();
        image.setDir(dir);
        image.setUser(username);
        image.setName(img_name);
        PostImagesToMysql.process("delete",image,null);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

