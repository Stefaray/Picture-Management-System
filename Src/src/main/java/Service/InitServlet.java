package Service;

import Dao.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/user/initServlet")
public class InitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String username=((User)session.getAttribute("User")).getUsername();
        ServletContext servletContext=this.getServletContext();
        String base_path=servletContext.getRealPath("imageStore");
//        System.out.println(username);
//        System.out.println(base_path);
        Map<String,String > parameters=new HashMap<String, String>();
        parameters.put("username",username);
        parameters.put("basePath",base_path);
        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(parameters);
//        System.out.println(s);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(s);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
