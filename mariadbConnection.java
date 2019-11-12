package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mariadbConnection {

    private Connection connect;
    private String driverName = "org.mariadb.jdbc.Driver";
    private String jdbc = "jdbc:mariadb://";
    private String host = "localhost:";
    private String port = "3306/";
    private String database = "Database";
    private String url = jdbc + host + port + database;
    private String username = "?user=root";
    private String password = "&password=";
    private String connection = url + username + password;

    public Connection getConnection() throws SQLException {
        if (connect == null) {
            try {
                Class.forName(driverName);
                System.out.println("Driver Class Found");
                try {
                    connect = DriverManager.getConnection(connection);
                    System.out.println("Connection Successful");
                } catch (SQLException se) {
                    System.out.println("Connection Failed, Error : " + se);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Driver Class Not Found, Error at : " + cnfe);
                System.exit(0);
            }
        }
        return connect;
    }

    public static void main(String[] args) throws SQLException {
        mariadbConnection ob = new mariadbConnection();
        ob.getConnection();
    }
}
