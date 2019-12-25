package Service;

import Dao.User;
import Sql.SqlTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("golden_username");
        String password=req.getParameter("golden_password");
        if(!SqlTemplate.existUser(username)){
            req.getSession().setAttribute("error","用户名不存在");
            resp.sendRedirect("login.jsp");
        }
        else {
            User user = SqlTemplate.findUser(username);
            String true_pw = user.getPassword();
            HttpSession session = req.getSession();
            //删除cookie
            Cookie[] cookies = req.getCookies();
            for (Cookie c : cookies) {
                if (c.getName().equals("User")) {
                    c.setMaxAge(0);
                    resp.addCookie(c);
                    System.out.println("删除了cookie信息");
                }
            }
            if (true_pw.equals(password)) {
                if (session.getAttribute("error") != null)
                    session.removeAttribute("error");


                session.setAttribute("User", user);
                Cookie cookie = new Cookie("User", username);
                String autoLogin = req.getParameter("autoLogin");
                if (autoLogin != null) {
                    cookie.setMaxAge(60 * 60*24);
                } else {
                    cookie.setMaxAge(0);
                }
                resp.addCookie(cookie);

                if (user.getBoss()) {
                    resp.sendRedirect("admin/datatables.jsp");
                } else {
                    resp.sendRedirect("index.jsp");
                }
            } else {
                session.setAttribute("error", "用户名或密码错误");
                resp.sendRedirect("login.jsp");
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
