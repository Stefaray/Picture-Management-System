package image;

import Dao.Image;
import Dao.User;
import Sql.AccessImges;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

//前端get目录下的所有图片的src

@WebServlet(value = "/getImagesServlet")
public class GetImagesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和目录名
//        System.out.println("here");
        String username=((User)req.getSession().getAttribute("User")).getUsername();
        String dir=req.getParameter("dir");
        HttpSession session=req.getSession();
        session.setAttribute("current_dir",dir);
        //
        ObjectMapper mapper=new ObjectMapper();
        List<Image> allImages = AccessImges.findAllImages(username,dir);

        resp.setCharacterEncoding("UTF-8");
        String jsonAllImages=mapper.writeValueAsString(allImages);
        System.out.println(jsonAllImages);
        resp.getWriter().write(jsonAllImages);

    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
