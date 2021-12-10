package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;

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


}
