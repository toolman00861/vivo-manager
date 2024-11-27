package Util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

    private static HikariDataSource dataSource;

    static {
        try {
            // 配置数据源
            HikariConfig config = getHikariConfig();
            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();
        }
    }

    // 测试一下
    public static void main(String[] args) {
        try {
            // 配置数据源
            HikariConfig config = getHikariConfig();

            dataSource = new HikariDataSource(config);

            // 尝试获取连接并执行一个简单的查询
            try (Connection connection = dataSource.getConnection()) {
                if (connection != null) {
                    System.out.println("数据库连接成功！");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT 1");
                    if (resultSet.next()) {
                        System.out.println("查询结果: " + resultSet.getInt(1));
                    }
                } else {
                    System.out.println("无法获取数据库连接。");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("连接数据库时发生错误: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("初始化数据源时发生错误: " + e.getMessage());
        }
    }

    private static HikariConfig getHikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/JavaEE_DB"); // 数据库 URL
        config.setUsername("root"); // 数据库用户名
        config.setPassword("123456"); // 数据库密码
        config.setMaximumPoolSize(10); // 最大连接数
        config.setConnectionTimeout(30000); // 连接超时
        config.setIdleTimeout(600000); // 空闲超时
        config.setMaxLifetime(1800000); // 连接最大生命周期
        return config;
    }
}