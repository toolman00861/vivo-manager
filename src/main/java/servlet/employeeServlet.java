package servlet;

import JavaBean.User;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.userService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "employeeServlet", value = "/employee")
public class employeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action.equals("getAllEmployees")){
            userService uService = new userService();
            try {
                List<User> userList = uService.getUserList();
                System.out.println("getAllUser");
                for (User user : userList) {
                    System.out.println(user);
                }

                // 设置响应内容类型
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // 将员工数据转换为 JSON 格式
                PrintWriter out = response.getWriter();
                out.print(new Gson().toJson(userList));
                out.flush();
            } catch (Exception e) {
                System.out.println("employeeServlet出现错误");
            }
        }
    }
}
