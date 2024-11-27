<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>登录界面</title>
</head>
<%--连接样式表--%>
<link rel="stylesheet" href="css/login.css">
<body>
  <div class="login-container">
    <form action="loginServlet" method="post" class="login-form">
      <h2>登录</h2>
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
        <button type="submit">登录</button>
        <a href="register.jsp">没有账号？去注册</a>
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

<br/>

</body>
</html>