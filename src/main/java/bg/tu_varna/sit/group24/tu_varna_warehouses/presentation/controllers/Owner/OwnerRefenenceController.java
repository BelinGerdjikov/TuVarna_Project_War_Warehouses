package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Owner;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.ContractRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.warehouseReferenceModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerRefenenceController implements EventHandler<MouseEvent> {
    @FXML
    private Button BackButton;

    @FXML
    private TableView<warehouseReferenceModel> Display;

    @FXML
    private TableColumn<warehouseReferenceModel, Double> cost_per_day;

    @FXML
    private TableColumn<warehouseReferenceModel, Integer> deals;

    @FXML
    private TableColumn<warehouseReferenceModel, Double> profit;

    @FXML
    private TableColumn<warehouseReferenceModel, Integer> warehouse;

    static Connection conn;

    ObservableList<warehouseReferenceModel> oblist= FXCollections.observableArrayList();


    @FXML
    private void initialize(){
        try {

            BackButton.setOnMouseClicked(this::handle);

            //setting up the columns to the tableview

            warehouse.setCellValueFactory(new PropertyValueFactory<>("Warehouse_id"));
            deals.setCellValueFactory(new PropertyValueFactory<>("Deals"));
            profit.setCellValueFactory(new PropertyValueFactory<>("Profit"));
            cost_per_day.setCellValueFactory(new PropertyValueFactory<>("Cost_per_day"));

            setTableView();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stage = (Stage)BackButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuWindow.MenuWindowOwner);
        newWindows.create(path,"Owner Menu");
        stage.hide();
    }

    public void setTableView() throws SQLException {
        conn= DataBaseConnection.getConnection();

        //Setting / resetting the information in the TableView

        String sql = "SELECT warehouse_id,cost FROM warehouse";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);

        Display.getItems().clear();

        while(rs.next()){


            oblist.add(ContractRepository.DealsAndProfit(rs.getInt("warehouse_id"),rs.getDouble("cost")));

        }

        Display.setItems(oblist);


    }
}
