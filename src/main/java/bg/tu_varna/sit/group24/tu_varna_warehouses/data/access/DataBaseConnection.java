package bg.tu_varna.sit.group24.tu_varna_warehouses.data.access;

import java.sql.Connection;
import java.sql.*;

public class DataBaseConnection {
    static String URL="jdbc:mysql://localhost:3305/ware_house_project";//the path of my mysql database
    static String name="root";//username
    static String password="belin123";//password

    static Connection conn;//store the connection
    static PreparedStatement create;
    static String sql;




    public static void main(String[] args) {
        try {
            conn = getConnection();



        } catch(Exception e) {
            e.printStackTrace();
        }

    }







    public static Connection getConnection() throws SQLException {
        //connecting to the database
        try {
            Connection conn =
                    DriverManager.getConnection(URL, name, password);
            return conn;
        } catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }







}
