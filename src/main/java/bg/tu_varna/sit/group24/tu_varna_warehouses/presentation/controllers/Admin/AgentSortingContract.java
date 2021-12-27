package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.AgentRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.AgentModel;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.ProfitAgent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
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

    @FXML
    private Label ErrorMessage;


    ObservableList<AgentModel> oblist= FXCollections.observableArrayList();

    static Connection conn;

    @FXML
    private void initialize() throws SQLException {

        back.setOnMouseClicked(this::handle);
        Update_rating.setOnMouseClicked(this::Update_rating);

        //setTableView();



        Agent_id.setCellValueFactory(new PropertyValueFactory<>("Id_agent"));
        Agnet_name.setCellValueFactory(new PropertyValueFactory<>("Agent_name"));
        Commission.setCellValueFactory(new PropertyValueFactory<>("Commission"));
        rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        Deals.setCellValueFactory(new PropertyValueFactory<>("Deals"));
        Earned_money.setCellValueFactory(new PropertyValueFactory<>("Earned_money"));

        setTableView();

    }



    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stage = (Stage)back.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuWindow.MenuWindowAdmin);
        newWindows.create(path,"Create Warehouse");
        stage.hide();

    }


    public void Update_rating(MouseEvent mouseEvent) {


        try{
        int id = Integer.parseInt(agent_id_update.getText());

        double rating = Double.parseDouble(rating_update.getText());


        if (rating > -1.0 && rating < 10.1) {

            AgentRepository.update_rating(id, rating);
        }else{
            ErrorMessage.setText("The rating need to be between 0 and 10");
        }


        Display.getItems().clear();
        try {
            setTableView();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        } catch (Exception ex) {
          ErrorMessage.setText("Invalid input");
        }
    }

    public void setTableView() throws SQLException {
        try {
            Display.getItems().clear();
            conn = DataBaseConnection.getConnection();

            String sql = "SELECT agent_id,agent_name,rating,commission_proc FROM agent";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);



            while (rs.next()) {

                ProfitAgent agg= AgentRepository.get_deal_profit(rs.getInt("agent_id"),rs.getInt("commission_proc"));


                if(agg!=null)
                oblist.add(new AgentModel(agg.getAgent_id(), rs.getString("agent_name"), agg.getCommission(), rs.getDouble("rating"),agg.getDeals(),agg.getProfit()));

            }



        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        Display.setItems(oblist);
    }




}
