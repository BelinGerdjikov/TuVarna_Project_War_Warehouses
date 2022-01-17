package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class Client_infoController implements EventHandler<MouseEvent> {


    @FXML
    private Button Back;

    @FXML
    private void initialize(){
        Back.setOnMouseClicked(this::handle);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stage = (Stage)Back.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuWindow.MenuWindowAgent);
        newWindows.create(path,"Owner Menu");
        stage.hide();
    }



}
