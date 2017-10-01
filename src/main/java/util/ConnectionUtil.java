package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by User on 30.09.2017.
 */
public class ConnectionUtil {
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/company_it";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "root";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        System.out.println("Connection: " + connection.toString());

        return connection;
    }
}
