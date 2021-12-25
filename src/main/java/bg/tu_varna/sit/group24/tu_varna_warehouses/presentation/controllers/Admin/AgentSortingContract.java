package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.AgentRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.AgentModel;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.ProfitAgent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentSortingContract implements EventHandler<MouseEvent> {
    @FXML
    private TableColumn<AgentModel, Integer> Agent_id;

    @FXML
    private TableColumn<AgentModel, String> Agnet_name;

    @FXML
    private TableColumn<AgentModel, Double> Commission;

    @FXML
    private TableColumn<AgentModel, Integer> Deals;

    @FXML
    private TableColumn<AgentModel, Double> Earned_money;

    @FXML
    private Button back;

    @FXML
    private TableColumn<AgentModel, Double> rating;

    @FXML
    private TableView<AgentModel> Display;

    @FXML
    private TextField rating_update;//need to use

    @FXML
    private Button Update_rating;

    @FXML
    private TextField agent_id_update;


    ObservableList<AgentModel> oblist= FXCollections.observableArrayList();

    static Connection conn;

    @FXML
    private void initialize() throws SQLException {

        back.setOnMouseClicked(this::handle);


        //setTableView();



        Agent_id.setCellValueFactory(new PropertyValueFactory<>("Id_agent"));
        Agnet_name.setCellValueFactory(new PropertyValueFactory<>("Agent_name"));
        Commission.setCellValueFactory(new PropertyValueFactory<>("Commission"));
        rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        Deals.setCellValueFactory(new PropertyValueFactory<>("Deals"));
        Earned_money.setCellValueFactory(new PropertyValueFactory<>("Earned_money"));

        setTableView();

    }

    public void setTableView() throws SQLException {
        try {
            conn = DataBaseConnection.getConnection();

            String sql = "SELECT agent_id,agent_name,rating,commission_proc FROM agent ORDER BY rating";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);


            //Integer deals, Double profit, Integer agent_id, Integer commission



            // AgentRepository.get_deal_profit(agent_id,deals,profit);

            Display.getItems().clear();
            while (rs.next()) {
                ProfitAgent agg= AgentRepository.get_deal_profit(rs.getInt("agent_id"),rs.getInt("commission_proc"));



                oblist.add(new AgentModel(agg.getAgent_id(), rs.getString("agent_name"), agg.getCommission(), rs.getDouble("rating"),agg.getDeals(),agg.getProfit()));
                //oblist.add(new AgentModel(3,"Ime",40,6.9,5,66.66));
            }

            Display.setItems(oblist);

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        //ContractRepository.CreateContract("Belin",9,3,3,"2021-12-22","2021-12-24",300.5);

    }

}
