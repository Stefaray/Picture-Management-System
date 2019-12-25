package Service;

import Dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Stack;

@WebServlet(value = "/logoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.removeAttribute("User");
        Stack<User> stack= (Stack<User>) session.getAttribute("UserStack");
        Cookie[] cookies=req.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("User")){
                c.setMaxAge(0);
                resp.addCookie(c);
                System.out.println("删除了cookie信息");
            }
        }
        //删除session中的所有包含currentUser的属性
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String  attr=attributeNames.nextElement();
            if(attr.contains("currentUser")){
                session.removeAttribute(attr);
            }
        }


        if(stack==null||stack.empty())
        resp.sendRedirect("login.jsp");
        else{
            User root=stack.pop();
            session.setAttribute("UserStack",stack);
            session.setAttribute("User",root);
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
