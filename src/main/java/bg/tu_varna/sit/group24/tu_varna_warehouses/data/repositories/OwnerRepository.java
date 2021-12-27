package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerRepository {

    static Connection conn;
    static PreparedStatement create;




    public static void CreateOwner(String owner_name1,int login_id1){

            try{
                conn= DataBaseConnection.getConnection();

                String sql = "INSERT INTO owner1 (login_id,owner_name) VALUES ("+login_id1+",'"+owner_name1+"')";


                create = conn.prepareStatement(sql);
                create.executeUpdate(sql);

            } catch(SQLException e) {
                e.printStackTrace();
            }

    }

    public static int Owner_id_check(int owner_id){

        try{

            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM owner1 where owner_id="+owner_id;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){

                return rs.getInt("owner_id");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static int loginINOwner(int loginId){

        try{

            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM owner1 where login_id="+loginId;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){

                return rs.getInt("owner_id");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
