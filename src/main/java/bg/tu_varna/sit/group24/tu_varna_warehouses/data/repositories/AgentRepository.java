package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.ProfitAgent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentRepository {

    static Connection conn;
    static PreparedStatement create;





    public static void CreateAgent(String agent_name1,int login_id1){
        try{
            conn= DataBaseConnection.getConnection();

            String sql = "INSERT INTO agent (login_id,agent_name) VALUES ("+login_id1+",'"+agent_name1+"')";


            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static int loginINAgent(int loginId){

        try{

            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM agent where login_id="+loginId;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){

                return rs.getInt("agent_id");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    public static int get_commission(int agent_ID){

        try{

            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM agent where agent_id="+agent_ID;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){

                return rs.getInt("commission_proc");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    public static ProfitAgent get_deal_profit(int agent_ID,int commission){
        ProfitAgent prof=new ProfitAgent(0,0.0,-1,-1);
        try{



            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM contract where agent_id="+agent_ID;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);


            double x=0;
            double y;
            int deals=0;
            double profit=0;
            while(rs.next()){

                y=rs.getDouble("cost");
                deals++;
                x=y*100/(100+commission);
                profit=profit+(y-x);

                System.out.println("y= "+y+"\ndeals= "+deals+"\nx= "+x+"\nprofit= "+profit+"\n\n");

            }

            if(deals>0) {
                System.out.println("IN");

                prof.setProfit(profit);
                prof.setAgent_id(agent_ID);
                prof.setDeals(deals);
                prof.setCommission(commission);
                return prof;
            }



        } catch(SQLException e) {
            e.printStackTrace();
        }

       return null;
    }

}
