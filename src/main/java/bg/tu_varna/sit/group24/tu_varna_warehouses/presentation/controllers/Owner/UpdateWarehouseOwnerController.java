package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Owner;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.WareHouseRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.WarehouseModel;
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

public class UpdateWarehouseOwnerController implements EventHandler<MouseEvent> {

    @FXML
    private TableColumn<WarehouseModel,String> Address;

    @FXML
    private TableColumn<WarehouseModel,String> Climate;

    @FXML
    private TableColumn<WarehouseModel,String> Cost;

    @FXML
    private TableView<WarehouseModel> Display;

    @FXML
    private TableColumn<WarehouseModel,Integer> ID;

    @FXML
    private TableColumn<WarehouseModel,String> Size;

    @FXML
    private Button Back;

    @FXML
    private TextField ID_fx;

    @FXML
    private Button Update;

    @FXML
    private TextField address_fx;

    @FXML
    private TextField cost_fx;

    @FXML
    private TextField size_fx;

    @FXML
    private ChoiceBox<String> choice_box_fx;

    @FXML
    private CheckBox Climate_check;

    @FXML
    private CheckBox Cost_check;

    @FXML
    private CheckBox Size_check;

    @FXML
    private CheckBox address_check;

    @FXML
    private Label errorMessage;


    static Connection conn;

    ObservableList<WarehouseModel> oblist= FXCollections.observableArrayList();


    @Override
    public void handle(MouseEvent mouseEvent) {
        int id_temp;
        try{
            id_temp=Integer.parseInt(ID_fx.getText());
        }catch (Exception exception){
            id_temp=0;
        }

        if(id_temp>0) {
            if (address_check.isSelected()) {
                if (address_fx.getText().length() > 4) {
                    WareHouseRepository.UpdateWareHouseAddress(id_temp,address_fx.getText());

                } else {
                    errorMessage.setText("The address need to have at least 4 symbols");
                }
            }
            if (Size_check.isSelected()) {
                try {
                    if (Integer.parseInt(size_fx.getText()) > 3) {
                        WareHouseRepository.UpdateWareHouseSize(id_temp,Integer.parseInt(size_fx.getText()));

                    } else {
                        errorMessage.setText("The size need to be at least 4 square meters");
                    }
                } catch (Exception exception) {
                    errorMessage.setText("You need write only whole numbers");
                }

            }

            if (Cost_check.isSelected()) {
                try {
                    Double Cost_temp = Double.parseDouble(cost_fx.getText());
                    if (Cost_temp > 4) {
                        WareHouseRepository.UpdateWareHouseCost(id_temp,Cost_temp);

                    } else {
                        errorMessage.setText("The cost of the warehouse need to be at least 4$");
                    }
                } catch (Exception exception) {
                    errorMessage.setText("You need write only numbers");
                }

            }

            if (Climate_check.isSelected()) {
                WareHouseRepository.UpdateWareHouseClimate(id_temp,choice_box_fx.getValue());
            }

        }else{
            errorMessage.setText("You write wrong ID");
        }

        try {
            setTableView();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Back(MouseEvent mouseEvent) {
        Stage stage = (Stage)Back.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuWindow.MenuWindowOwner);
        newWindows.create(path,"Create Warehouse");
        stage.hide();
    }

    @FXML
    private void initialize() throws SQLException {

        Update.setOnMouseClicked(this::handle);
        Back.setOnMouseClicked(this::Back);

        setTableView();

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        Climate.setCellValueFactory(new PropertyValueFactory<>("Climate"));

        choice_box_fx.getItems().add("Cold");
        choice_box_fx.getItems().add("Cool");
        choice_box_fx.getItems().add("Hot");

        choice_box_fx.setValue("Cool");

    }



    public void setTableView() throws SQLException {
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
