package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Agent;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.WishListRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.WarehouseModel;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.WishListModel;
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

public class AgentWishListController implements EventHandler<MouseEvent> {
    @FXML
    private Button Add;

    @FXML
    private Button Back;

    @FXML
    private TableView<WarehouseModel> Display;

    @FXML
    private TableView<WishListModel> Favorite;

    @FXML
    private TableColumn<WishListModel, Integer> Favorite_ID;

    @FXML
    private TableColumn<WarehouseModel, Integer> Id_warehouse;

    @FXML
    private Button Remove;

    @FXML
    private TableColumn<WarehouseModel, String> address;

    @FXML
    private TableColumn<WarehouseModel, String> climate;

    @FXML
    private TableColumn<WarehouseModel,Double> price;

    @FXML
    private TableColumn<WarehouseModel, String> size;

    @FXML
    private TextField warehouse_id;

    @FXML
    private Label errorMassage;

    static PreparedStatement create;

    static Connection conn;

    ObservableList<WarehouseModel> oblist= FXCollections.observableArrayList();

    ObservableList<WishListModel> oblist2= FXCollections.observableArrayList();

    @FXML
    private void initialize(){

        Back.setOnMouseClicked(this::handle);
        Add.setOnMouseClicked(this::Add);
        Remove.setOnMouseClicked(this::Remove);

        Favorite_ID.setCellValueFactory(new PropertyValueFactory<>("Warehouse_id"));
//setting up the columns to the tableview

        Id_warehouse.setCellValueFactory(new PropertyValueFactory<>("ID"));
        address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        price.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        climate.setCellValueFactory(new PropertyValueFactory<>("Climate"));
        try {
//Setting the information in the TableView
            setTableView2();
            setTableView();
        }catch (Exception ex){
            System.out.println("setTableView2()");
            System.out.println(ex.getMessage());
        }



    }

    public void Add(MouseEvent mouseEvent) {
        //Add to the wishlist table
        try{

            int id=Integer.parseInt(warehouse_id.getText());


            errorMassage.setText(WishListRepository.Add_WishList(id,Constants.ID_save.agent));

            setTableView2();

        } catch (Exception ex) {
            ex.getMessage();
        }

    }

    public void Remove(MouseEvent mouseEvent) {
        //Remove of the wishlist table
        try {

            int id=Integer.parseInt(warehouse_id.getText());

            WishListRepository.Remove(id,Constants.ID_save.agent);


            setTableView2();
            errorMassage.setText("");

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stage = (Stage)Back.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuWindow.MenuWindowAgent);
        newWindows.create(path,"Agent Menu");
        stage.hide();
    }

    public void setTableView2() throws SQLException{
        //Setting / resetting the information in the TableView2
        try {
            conn= DataBaseConnection.getConnection();

            String sql = "SELECT * FROM wishlist where agent_id=" + Constants.ID_save.agent;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            Favorite.getItems().clear();

            while (rs.next()) {

                oblist2.add(new WishListModel(rs.getInt("warehouse_id")));

            }
            Favorite.setItems(oblist2);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void setTableView() throws SQLException {
        //Setting / resetting the information in the TableView
        conn= DataBaseConnection.getConnection();

        String sql = "SELECT warehouse_id,address,cost,size,climate FROM warehouse";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);

        Display.getItems().clear();

        while(rs.next()){
            oblist.add(new WarehouseModel(rs.getInt("warehouse_id"),rs.getString("address"),rs.getString("size"),rs.getString("cost"),rs.getString("climate")));

        }

        Display.setItems(oblist);


    }


}
