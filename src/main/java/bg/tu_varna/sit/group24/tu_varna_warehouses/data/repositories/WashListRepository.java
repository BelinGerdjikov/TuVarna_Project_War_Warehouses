package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WashListRepository {
    static Connection conn;
    static PreparedStatement create;

    public static boolean WishList_already_exist(int agent,int warehouse_ID){

        try{

            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM wishlist WHERE agent_id="+agent+" AND warehouse_id="+warehouse_ID;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){


                return true;
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }


        return false;
    }


    public static String Add_WishList(int id) {
        try{

            if(WareHouseRepository.warehouse_exist(id)) {
                System.out.println("agent: "+ Constants.ID_save.agent+" ID"+id);
                if(!WishList_already_exist(Constants.ID_save.agent,id)) {

                    conn = DataBaseConnection.getConnection();

                    String sql = "INSERT INTO wishlist (agent_id,warehouse_id) VALUES (" + Constants.ID_save.agent + ","+id+")";


                    create = conn.prepareStatement(sql);
                    create.executeUpdate(sql);

                    return "Added to the WishList";
                }else {
                    return "The ID is already in the list";
                }

            }else{
                return "Wrong ID";
            }


        } catch (Exception ex) {
            ex.getMessage();
        }
        return "invalid input";
    }


    public static void Remove(int id) {
        try {
            conn= DataBaseConnection.getConnection();


            String sql = "DELETE FROM wishlist WHERE agent_id="+Constants.ID_save.agent+" and warehouse_id="+id;


            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);



        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
