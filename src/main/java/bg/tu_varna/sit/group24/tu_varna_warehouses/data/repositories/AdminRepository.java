package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminRepository {

    static Connection conn;
    static PreparedStatement create;
    static String sql;




    public static int loginINAdmin(int loginId){
//finding the account corresponding to the login table
       try{

           conn= DataBaseConnection.getConnection();

           String sql = "SELECT * FROM admin1 where login_id="+loginId;
           PreparedStatement ps = conn.prepareStatement(sql);
           ResultSet rs = ps.executeQuery(sql);

           while(rs.next()){

               return rs.getInt("admin_id");
           }

       } catch(SQLException e) {
           e.printStackTrace();
       }

        return -1;
    }



}
