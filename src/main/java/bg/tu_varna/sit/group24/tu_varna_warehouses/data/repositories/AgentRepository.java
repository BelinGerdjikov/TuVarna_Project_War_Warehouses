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

    public static void main(String[] args) {
        try {




        } catch(Exception e) {
            e.printStackTrace();
        }

    }



    public static void CreateAgent(String agent_name1,int login_id1){
        //Create an agent in the database
        try{
            conn= DataBaseConnection.getConnection();

            String sql = "INSERT INTO agent (login_id,agent_name,rating,commission_proc) VALUES ("+login_id1+",'"+agent_name1+"',0,3)";


            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static int loginINAgent(int loginId){
        //finding the account corresponding to the login table
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
        //returning the commission of the agent

        try{

            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM agent where agent_id="+agent_ID;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){
                System.out.println("Commission: "+rs.getInt("commission_proc"));

                return rs.getInt("commission_proc");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    public static ProfitAgent get_deal_profit(int agent_ID,int commission){
        //getting the profit from the contract table
        ProfitAgent prof=new ProfitAgent(0,0.0,-1,-1);
        try{

            conn= DataBaseConnection.getConnection();
            //finding all the contract that agent created
            String sql = "SELECT * FROM contract where agent_id="+agent_ID;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);//array of all the findings


            double x=0;
            double y;
            int deals=0;
            double profit=0;
            while(rs.next()){

                y=rs.getDouble("cost");
                deals++;
                x=y*100/(100+commission);
                //a math formula that all the commission money the agent made
                profit=profit+(y-x);


            }

                prof.setProfit(profit);
                prof.setAgent_id(agent_ID);
                prof.setDeals(deals);
                prof.setCommission(commission);
                //adding all the information in a model ProfitAgent and returning the model
                return prof;




        } catch(SQLException e) {
            e.printStackTrace();
        }

       return null;
    }


    public static void update_rating(int agent_id,double rating){
        //from a given agent id the admin can change the rating
        try {
            conn= DataBaseConnection.getConnection();

        String sql ="UPDATE agent SET rating="+rating+" where agent_id="+agent_id;
        create = conn.prepareStatement(sql);
        create.executeUpdate(sql);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void update_commission(int commission,int agent_id){
        //updating the commission from a given agent ID

        try {
            conn= DataBaseConnection.getConnection();

            String sql ="UPDATE agent SET commission_proc="+commission+" where agent_id="+ agent_id;
            create = conn.prepareStatement(sql);
            create.executeUpdate(sql);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
