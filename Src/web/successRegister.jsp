<%@ page import="Dao.User" %><%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2019/12/7
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>

<%
    session.setAttribute("RegisterSuccess", ((User)session.getAttribute("loginUser")).getUsername()+"注册成功");

    response.sendRedirect("login.jsp");
%>


</body>
</html>
