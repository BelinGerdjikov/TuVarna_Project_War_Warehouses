package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.OwnerStatisticsAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerRepository {

    static Connection conn;
    static PreparedStatement create;




    public static void CreateOwner(String owner_name1,int login_id1){
//Creating Owner Account
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
//Checking if the given owner ID is created in the database
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
//finding the account corresponding to the login table
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


    public static OwnerStatisticsAdmin GetOwnerStatistics(int owner_id,String owner_name){
        //Getting the owner statistics
        OwnerStatisticsAdmin temp;
        try{
            conn= DataBaseConnection.getConnection();
            String sql = "SELECT * FROM contract where owner_id="+owner_id;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            double x=0;
            double y;
            int deals=0;
            double profit=0;
            while(rs.next()){

                y=rs.getDouble("cost");
                deals++;
                x=y*100/(100+AgentRepository.get_commission(rs.getInt("agent_id")));
                //math formula that show how much the owner gote from the deals
                profit=profit+x;

            }

            //returning a model OwnerStatisticsAdmin
            temp=new OwnerStatisticsAdmin(owner_id,owner_name,deals,profit);

            return temp;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
