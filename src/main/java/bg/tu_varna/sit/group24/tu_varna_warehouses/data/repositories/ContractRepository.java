package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.warehouseReferenceModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractRepository {
    static Connection conn;
    static PreparedStatement create;
    static String sql;






    public static void CreateContract(String Client_Name,int agent_ID,int owner_id,int warehouse_id,String start_date,String end_date,Double Cost){
//Creating the contract

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


    public static warehouseReferenceModel DealsAndProfit(int warehouse_id,double cost){
        //finding what a warehouse make in profit
        warehouseReferenceModel temp;
        try{

            conn=DataBaseConnection.getConnection();

            String sql = "SELECT * FROM contract where warehouse_id="+warehouse_id+"";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            double x=0;
            double y;
            int deals=0;
            double profit=0;

            if(rs.next()){
                y=rs.getDouble("cost");
                deals++;
                x=y*100/(100+AgentRepository.get_commission(rs.getInt("agent_id")));
                profit=profit+x;
            }


            //returning a model warehouseReferenceModel
            temp=new warehouseReferenceModel(warehouse_id,deals,profit,cost);

            return temp;

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
