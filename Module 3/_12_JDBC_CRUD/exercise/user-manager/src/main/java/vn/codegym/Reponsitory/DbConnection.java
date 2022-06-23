package vn.codegym.Reponsitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/user_manager";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private static Connection connection;

    public static Connection getConnection() {
        System.out.println("Connecting database...");
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (SQLException e) {
            System.out.println("Connect failure SQLException!" + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Connect failure ClassNotFoundException!" + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
