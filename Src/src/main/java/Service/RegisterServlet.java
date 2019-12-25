package Service;

import Dao.User;
import Sql.AccessUserdirs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("golden_username");
        String password=req.getParameter("golden_password");
        String email=req.getParameter("golden_email");
        String password_again=req.getParameter("golden_password_again");
        String gender=req.getParameter("golden_gender");
        String time_register= ReturnDate.returnDate();
        HttpSession session=req.getSession();

        if(!password.equals(password_again))
        {
            session.setAttribute("error","两次密码不一致");
            resp.sendRedirect("register.jsp");
        }
        else if(password.length()<3){
            session.setAttribute("error","密码太短，至少3位");
            resp.sendRedirect("register.jsp");
        }
        else if(Sql.SqlTemplate.existUser(username)){
            session.setAttribute("error","用户已存在");
            resp.sendRedirect("register.jsp");
        }
        else{
            //添加用户
            User loginUser=new User(username,password,email,gender,time_register);
            Sql.SqlTemplate.addUser(loginUser);
            AccessUserdirs.add(username,"{\"dirs\":[\"卫星\",\"人物\",\"风景\",\"abc\",\"测试\"]}");
            AccessUserdirs.update(username,"{\"dirs\":[\"卫星\",\"人物\",\"风景\",\"abc\",\"测试\"]}");

            //添加完成
            if(session.getAttribute("error")!=null)
                session.removeAttribute("error");
            session.setAttribute("loginUser",loginUser);
            resp.sendRedirect("successRegister.jsp");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
