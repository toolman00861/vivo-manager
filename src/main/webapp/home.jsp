<%@ page import="JavaBean.User" %>
<%@ page import="service.userService" %>
<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2024/11/8
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%
    User user = new User();
    if(session != null) {
        String name = (String) session.getAttribute("username");
        userService service = new userService();
        user = service.findUser(name);
    }
%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<link rel="stylesheet" href="css/home.css">
<head>
    <title>主页</title>
</head>
<body>
    <div class="main-container">
        <div class="welcome-container">
            <h1> 欢迎进入！ <%= user.getUsername() %></h1>
            <h3>当前操作者：<%= session.getAttribute("username") %></h3>
            <p>邮箱： <%= user.getEmail() %></p>
            <p>手机号： <%= user.getPhone() %></p>
        </div>
    </div>
</body>
</html>
