package Service;

import Dao.User;
import Sql.SqlTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Stack;

@WebServlet(value = "/modifyUsers")
public class ModifyUsers extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Stack<User> stack=new Stack();
        HttpSession session=req.getSession();
        User root=(User) session.getAttribute("User");
        stack.push(root);
        session.setAttribute("UserStack",stack);
        String current_username=req.getParameter("username");
        User current_user= SqlTemplate.findUser(current_username);
        session.setAttribute("User",current_user);

        resp.sendRedirect(req.getContextPath()+"/user/new.html");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
