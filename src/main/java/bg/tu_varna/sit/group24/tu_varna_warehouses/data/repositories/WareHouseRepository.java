package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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

    public static void UpdateWareHouseSize(int ID,int size){
        try{
            conn= DataBaseConnection.getConnection();



            String sql = "Update warehouse set size="+size+" where warehouse_id="+ID;



            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateWareHouseAddress(int ID,String address){
        try{
            conn= DataBaseConnection.getConnection();


            String sql = "Update warehouse set address='"+address+"' where warehouse_id="+ID;



            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateWareHouseCost(int ID,Double cost){
        try{
            conn= DataBaseConnection.getConnection();


            String sql = "Update warehouse set cost="+cost+" where warehouse_id="+ID;


            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateWareHouseClimate(int ID,String climate){
        try{
            conn= DataBaseConnection.getConnection();


            String sql = "Update warehouse set climate='"+climate+"' where warehouse_id="+ID;


            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public static void CreateWareHouse(String address1,double cost_per_day,int size1,String climate1,int owner_id1){

            try{
                conn= DataBaseConnection.getConnection();


                String sql = "INSERT INTO warehouse (address,climate,cost,size,owner_id) VALUES" +
                        " ('"+address1+"','"+climate1+"',"+cost_per_day+","
                        +size1+","+owner_id1+")";


                create = conn.prepareStatement(sql);
                create.executeUpdate(sql);

            } catch(SQLException e) {
                e.printStackTrace();
            }

    }



    public static int finding_owner(int warehouse_ID){

        try{

            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM warehouse where warehouse_id="+warehouse_ID;
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


    public static double finding_price(int warehouse_ID){

        try{

            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM warehouse where warehouse_id="+warehouse_ID;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){

                return rs.getInt("cost");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }


        return -1;


    }


    private static void setupForRefresh(){

        try {
            conn = DataBaseConnection.getConnection();



            String sql = "update warehouse set is_available=1";
            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);

        }catch(Exception ex){
            ex.getMessage();
        }
    }

    public static void refresh(){

        setupForRefresh();
        try {
            conn= DataBaseConnection.getConnection();

            LocalDate now = LocalDate.now();

            String testing=now.toString();

        String sql = "SELECT * FROM contract where start_date<='"+testing+"' and end_date>='"+testing+"'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);


        while(rs.next()){

            String sql2 ="UPDATE warehouse SET is_available=0 WHERE warehouse_id="+rs.getInt("warehouse_id");
            create = conn.prepareStatement(sql2);
            create.executeUpdate(sql2);
        }

       } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
