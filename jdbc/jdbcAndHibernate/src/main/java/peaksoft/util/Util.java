package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String name = "postgres";
    private final static String password = "1234";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Connected date base!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;

    }


}
