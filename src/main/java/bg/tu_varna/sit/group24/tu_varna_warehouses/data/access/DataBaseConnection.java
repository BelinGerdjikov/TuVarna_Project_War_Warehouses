package bg.tu_varna.sit.group24.tu_varna_warehouses.data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseConnection {
    static String databaseName="ware_houseProject";
    static String URL="jdbc:mysql://localhost:3305/ware_house_project";
    static String name="root";
    static String password="belin123";

    static Connection conn;
    static PreparedStatement create;
    static String sql;

    public static void main(String[] args) {
        try {
            conn = getConnection();
            DB();


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void DB() throws SQLException {

        sql = "create database if not exists " + databaseName;
        create = conn.prepareStatement(sql);
        create.executeUpdate(sql);
        System.out.println("Database created successfully...");
    }

    public static Connection getConnection() throws SQLException {
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
