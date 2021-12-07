package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class AdminMenuController implements EventHandler<MouseEvent> {
    @FXML
    private Button backButton;

    @FXML
    private void initialize(){
        backButton.setOnMouseClicked(this::handle);
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
