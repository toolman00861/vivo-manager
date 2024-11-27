package service;

import JavaBean.User;

import java.sql.SQLException;
import java.util.List;
import Dao.UserDao;

public class userService {
    private final UserDao userDao = new UserDao();
    public boolean validateUser(String name) throws SQLException {
        return userDao.getUserByName(name) != null;
    }
    public boolean login(String name, String pwd) throws SQLException {
        return userDao.getUserByName(name).getPassword().equals(pwd);
    }
    public void addUser(String username, String password, String email, String phone) throws SQLException {
        User user = new User(username, password, email, phone);
        userDao.addUser(user);
    }
    public List<User> getUserList() throws SQLException {
        return userDao.getAllUser();
    }
    public User findUser(String username) throws SQLException {
        return userDao.getUserByName(username);
    }
    public boolean validEmail(String email) throws SQLException {
        return userDao.getUserByEmail(email) != null;
    }
}
