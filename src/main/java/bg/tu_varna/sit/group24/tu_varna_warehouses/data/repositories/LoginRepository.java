package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {

    static Connection conn;
    static PreparedStatement create;
    static String sql;


    public static boolean isUsedName(String username){
//Checking if the username is already created
        try{

            conn=DataBaseConnection.getConnection();

            String sql = "SELECT * FROM login where username='"+username+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            if(rs.next()){

                return true;
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }


        return false;
    }


    public static int CreateLogin(String login_name,String pass){
        //Creating a login with which you can log to the account
        try{

            conn=DataBaseConnection.getConnection();
            String sql = "INSERT INTO login (username,password1) VALUES ('"+login_name+"','"+pass+"')";



            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);
            create.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }


        return login_cheak(login_name,pass);
    }


    public static int login_cheak(String user,String pass){
        //Checking if the username and password is correct

        try{

       conn=DataBaseConnection.getConnection();

                String sql = "SELECT * FROM login where username='"+user+"' and password1='"+pass+"'";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);

              if(rs.next()){

                       return rs.getInt("login_id");
              }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

}
