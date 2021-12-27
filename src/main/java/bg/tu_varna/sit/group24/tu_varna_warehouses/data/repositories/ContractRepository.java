package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractRepository {
    static Connection conn;
    static PreparedStatement create;
    static String sql;






    public static void CreateContract(String Client_Name,int agent_ID,int owner_id,int warehouse_id,String start_date,String end_date,Double Cost){


        try{


                conn = DataBaseConnection.getConnection();
                String sql = "INSERT INTO contract (client_name,agent_id,owner_id,warehouse_id,start_date,end_date,cost) VALUES ('"
                        + Client_Name + "'," + agent_ID + "," + owner_id + "," + warehouse_id + ",'" + start_date + "','" + end_date + "'," + Cost + ")";


                create = conn.prepareStatement(sql);
                create.executeUpdate(sql);
                create.close();


        } catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
