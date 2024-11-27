/*
github链接：https://github.com/toolman00861/vivo-manager
时间：2024/11/25
*/

package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JavaBean.User;
import Util.DbUtil;

// UserDao 用来访问数据库等操作
public class UserDao {
    private Connection getConnection() throws SQLException {
        return DbUtil.getConnection();
    }

    // 添加用户
    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO user (username, password, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement command = conn.prepareStatement(sql)) {
            command.setString(1, user.getUsername());
            command.setString(2, user.getPassword());
            command.setString(3, user.getEmail());
            command.setString(4, user.getPhone());
            command.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // 查询用户
    public User getUserByName(String name) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement command = conn.prepareStatement(sql)
        ) {
            command.setString(1, name);
            try (ResultSet res = command.executeQuery()) {
                if (res.next()) {
                    return getUserInfo(res);
                }
            }
        }
        return null;
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement command = conn.prepareStatement(sql)) {
            command.setInt(1, id);
            try (ResultSet res = command.executeQuery()) {
                if (res.next()) {
                    return getUserInfo(res);
                }
            }
        }
        return null;
    }

    // 更新用户
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET username = ?, password = ?, email = ?, phone = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement command = conn.prepareStatement(sql)) {
            command.setString(1, user.getUsername());
            command.setString(2, user.getPassword());
            command.setString(3, user.getEmail());
            command.setString(4, user.getPhone());
            command.setInt(5, user.getId());
            command.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // 删除用户
    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<User> getAllUser() throws SQLException {
        String sql = "SELECT * FROM user";
        try (Connection conn = getConnection();
             PreparedStatement command = conn.prepareStatement(sql)) {
            ResultSet res = command.executeQuery();
            return resultSetToList(res);
        }
    }

    public List<User> resultSetToList(ResultSet res) throws SQLException {
        List<User> list = new ArrayList<>();
        while (res.next()) {
            User user = getUserInfo(res);
            list.add(user);
        }
        return list;
    }

    private User getUserInfo(ResultSet res) throws SQLException {
        User user = new User();
        user.setId(res.getInt("id"));
        user.setUsername(res.getString("username"));
        user.setPassword(res.getString("password"));
        user.setEmail(res.getString("email"));
        user.setPhone(res.getString("phone"));
        user.setAge(res.getString("age"));
        user.setDepartment_id(res.getInt("department_id"));
        user.setSalary(res.getInt("salary"));
        return user;
    }

    public User getUserByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM user WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement command = conn.prepareStatement(sql)) {
            command.setString(1, email);
            try (ResultSet res = command.executeQuery()) {
                if (res.next()) {
                    User user = new User();
                    user.setId(res.getInt("id"));
                    user.setUsername(res.getString("username"));
                    user.setPassword(res.getString("password"));
                    user.setEmail(res.getString("email"));
                    return user;
                } else {
                    return null;
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }
}
