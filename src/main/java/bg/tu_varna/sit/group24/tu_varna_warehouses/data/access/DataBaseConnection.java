package bg.tu_varna.sit.group24.tu_varna_warehouses.data.access;

import java.sql.Connection;
import java.sql.*;

public class DataBaseConnection {
    static String URL="jdbc:mysql://localhost:3306/ware_house_project";
    //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=rootpassword");
    static String name="root";
    static String password="Ru087238849";

    static Connection conn;
    static PreparedStatement create;
    static String sql;




    public static void main(String[] args) {
        try {
            conn = getConnection();

            login_duplicate_cheak();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void login_duplicate_cheak() throws SQLException{

        try {
            String sql = "SELECT * FROM login";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            String name="Belin";
            String take="";
            while(rs.next()){
                take=rs.getString("username");
                System.out.println(take);
                System.out.println(take.length());
                System.out.println(name);
                System.out.println(name.length());
                System.out.println(name.compareTo(take));

                if(name.compareTo(take)==0){

                }

                // if(name==take){
                //     //System.out.println("take");
                //     System.out.println("Belin is already in the system");
                // }
            }



        } catch(SQLException e) {
            e.printStackTrace();

        }

    }




    // try {
    //    String SQL = "Select * FROM '100';";
    //    ResultSet rs = connection.createStatement().executeQuery(SQL);

    //    while (rs.next()) {
    //        String yellow = rs.getString("BasePt");
    //        TextField textField = new TextField(yellow);
    //        vBox.getChildren().add(textField);
    //    }
    //} catch (Exception e) {
    //    e.printStackTrace();
    //}

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



    public static void addLogin() throws SQLException{

        try {
            Connection conn =
                    DriverManager.getConnection(URL, name, password);

            sql = "insert into login(login_id,username,password1) values(1,'Belin','111111')";

            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);

        } catch(SQLException e) {
            System.out.println(e);
        }

    }



}
