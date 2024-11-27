package servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.userService;

import java.io.IOException;

public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        userService uService = new userService();
        HttpSession session = request.getSession();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            log("Invalid input");
            session.setAttribute("err", "请填写完所有信息！");
            response.sendRedirect("register.jsp");
            return;
        }
        log(username + "is registering");
        try {
            if (uService.findUser(username) != null) {
                log("Username already exists");
                session.setAttribute("err", "用户名已经存在！");
                response.sendRedirect("register.jsp");
            } else if (uService.validEmail(email)) {
                log("Email already exists");
                session.setAttribute("err", "邮箱已经存在！");
                response.sendRedirect("register.jsp");
            }else {
                uService.addUser(username, password, email, phone);
                log(username + "registered successfully");
                session.setAttribute("msg", "注册成功，请登录。");
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            log("Error during registration: " + e.getMessage());
            session.setAttribute("err", "在注册过程中发生了错误：" + e.getMessage());
            response.sendRedirect("register.jsp");
        }
    }
}
