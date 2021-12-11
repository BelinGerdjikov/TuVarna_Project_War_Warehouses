package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class OwnerMenuController implements EventHandler<MouseEvent> {
    @FXML
    private Button backButton;

    @FXML
    private Button create_warehouse;

    @FXML
    private void initialize(){
        backButton.setOnMouseClicked(this::handle);
        create_warehouse.setOnMouseClicked(this::Create_owner);
    }

    public void Create_owner(MouseEvent mouseEvent){
        System.out.println("Good");
        Stage stage = (Stage)backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuCreate.MenuCreateWarehouse);
        newWindows.create(path,"Create Warehouse");
        stage.hide();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        Stage stage = (Stage)backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.View.HELLO_VIEW);
        newWindows.create(path,"Login Menu");
        stage.hide();
    }
}
