package jm.task.core.jdbc.util;



import java.sql.*;

public class Util {
    public static void main(String[] args) {

    }
    private final static String URL = "jdbc:mysql://localhost:3306/pp1";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Irbislol124+";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
