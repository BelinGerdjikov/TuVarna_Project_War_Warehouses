package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class HelloController implements EventHandler<MouseEvent>{

    @FXML
    private Button loginAdmin;

    @FXML
    private Button loginAgent;

    @FXML
    private Button loginOwner;

    @FXML
    private Label test;

    @FXML
    private void initialize(){
        loginAdmin.setOnMouseClicked(this::handle);
        loginAgent.setOnMouseClicked(this::loginAgent);
        loginOwner.setOnMouseClicked(this::loginOwner);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stage = (Stage)loginAdmin.getScene().getWindow();


        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.LoginWindow.LoginWindowAdmin);
        newWindows.create(mouseEvent,path,"Admin");
        stage.hide();

    }

    public void loginAgent(MouseEvent mouseEvent) {
        Stage stage = (Stage)loginAdmin.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.LoginWindow.LoginWindowAgent);
        newWindows.create(mouseEvent,path,"Agent");
        stage.hide();
    }

    public void loginOwner(MouseEvent mouseEvent) {
        Stage stage = (Stage)loginAdmin.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.LoginWindow.LoginWindowOwner);
        newWindows.create(mouseEvent,path,"Owner");
        stage.hide();
    }







}



