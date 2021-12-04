package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class AgentloginController implements EventHandler<MouseEvent> {

    @FXML
    private PasswordField Agentpassword;

    @FXML
    private TextField Agentusername;

    @FXML
    private Button backbutton;

    @FXML
    private Label errorMessage;

    @FXML
    private Button loginButton;

    @FXML
    private void initialize(){
        loginButton.setOnMouseClicked(this::handle);
        backbutton.setOnMouseClicked(this::Back);

    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        Stage stage = (Stage)loginButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuWindow.MenuWindowAgent);
        newWindows.create(mouseEvent,path,"Menu");
        stage.hide();
    }


    public void Back(MouseEvent mouseEvent) {

        Stage stage = (Stage)backbutton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.View.HELLO_VIEW);
        newWindows.create(mouseEvent,path,"StartWindow");
        stage.hide();
    }
}

