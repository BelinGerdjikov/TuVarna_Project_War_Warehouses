package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Owner;

import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.warehouseReferenceModel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

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


    @FXML
    private void initialize(){

    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
