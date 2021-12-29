package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.OwnerRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.OwnerStatisticsAdmin;
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

public class ReferenceOwnerController implements EventHandler<MouseEvent> {
    @FXML
    private Button Back;

    @FXML
    private TableView<OwnerStatisticsAdmin> Display;

    @FXML
    private TableColumn<OwnerStatisticsAdmin, Integer> Deals;

    @FXML
    private TableColumn<OwnerStatisticsAdmin, Integer> Owner_id;

    @FXML
    private TableColumn<OwnerStatisticsAdmin, String> Owner_name;

    @FXML
    private TableColumn<OwnerStatisticsAdmin, Double> Profit;

    static Connection conn;

    ObservableList<OwnerStatisticsAdmin> oblist= FXCollections.observableArrayList();

    @FXML
    private void initialize() throws SQLException {


        Back.setOnMouseClicked(this::handle);

        Owner_id.setCellValueFactory(new PropertyValueFactory<>("Owner_id"));
        Owner_name.setCellValueFactory(new PropertyValueFactory<>("Owner_name"));
        Deals.setCellValueFactory(new PropertyValueFactory<>("Deals"));
        Profit.setCellValueFactory(new PropertyValueFactory<>("Profit"));



        setTableView();




    }

    public void setTableView() throws SQLException {
        conn= DataBaseConnection.getConnection();

        String sql = "SELECT owner_id,owner_name FROM owner1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);

        Display.getItems().clear();

        while(rs.next()){
            oblist.add(OwnerRepository.GetOwnerStatistics(rs.getInt("owner_id"),rs.getString("owner_name")));

        }

        Display.setItems(oblist);


    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stage = (Stage) Back.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path = getClass().getResource(Constants.MenuWindow.MenuWindowAdmin);
        newWindows.create(path, "Admin Menu");
        stage.hide();
    }

}
