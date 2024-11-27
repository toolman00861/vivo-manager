<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2024/11/8
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<script src="script/register.js"></script>
<link rel="stylesheet" href="css/register.css">
<head>
    <title>注册界面</title>
</head>
<body>
    <div class="register-container">
        <form action="registerServlet" onsubmit="return submitForm()" method="post" class="register-form">
            <h2>注册</h2>
            <h3>当前操作者：<%= session.getAttribute("username") %></h3>
            <div class="input-group">
                <label for="username">用户名:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">密码:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="input-group">
                <label for="email">邮箱:</label>
                <input type="email" id="email" name="email" >
            </div>
            <div class="input-group">
                <label for="phone">手机号:</label>
                <input type="tel" id="phone" name="phone" >
            </div>
            <div class="input-group">
                <button type="submit">注册</button>
                <a href="login.jsp">已有账号？去登录</a>
            </div>
            <div class="input-group">
                <%
                    // 确保会话存在
                    String msg = (String) session.getAttribute("msg");
                    if (msg != null) {
            %>
            <p style='color:lightgreen;'> <%= msg %> </p>
            <%
                        session.removeAttribute("msg"); // 显示后清除信息
                    }
                %>
                <%
                    // 确保会话存在
                    String err = (String) session.getAttribute("err");
                    if (err != null) {
            %>
            <p style='color:orangered;'> <%= err %> </p>
            <%
                        session.removeAttribute("err"); // 显示后清除信息
                    }
                %>
            </div>
        </form>
    </div>
</body>
</html>
