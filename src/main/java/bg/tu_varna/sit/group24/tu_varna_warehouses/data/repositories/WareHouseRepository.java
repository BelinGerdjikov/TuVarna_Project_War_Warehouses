package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WareHouseRepository {
    static Connection conn;
    static PreparedStatement create;

    public static void main(String[] args) {
        try {


            //CreateWareHouse("Carevec",3,12,"cold",owner_id1);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public static void CreateWareHouse(String address1,double cost_per_day,int size1,String climate1,int owner_id1){

            try{
                conn= DataBaseConnection.getConnection();
                System.out.println(address1);
                System.out.println(cost_per_day);
                System.out.println(size1);
                System.out.println(climate1);
                System.out.println(owner_id1);

                String sql = "INSERT INTO warehouse (address,climate,cost,size,owner_id) VALUES" +
                        " ('"+address1+"','"+climate1+"',"+cost_per_day+","
                        +size1+","+owner_id1+")";


                create = conn.prepareStatement(sql);
                create.executeUpdate(sql);

            } catch(SQLException e) {
                e.printStackTrace();
            }

    }
}
