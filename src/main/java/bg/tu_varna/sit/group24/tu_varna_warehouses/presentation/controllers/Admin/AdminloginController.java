package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin;


import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.AdminRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.LoginRepository;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class AdminloginController implements EventHandler<MouseEvent> {
    @FXML
    private PasswordField Adminpassword;

    @FXML
    private TextField Adminusername;

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


        if(AdminRepository.loginINAdmin(LoginRepository.login_cheak(Adminusername.getText(),Adminpassword.getText()))>0){
            Stage stage = (Stage)loginButton.getScene().getWindow();
            CreatingNewWindows newWindows = new CreatingNewWindows();
            URL path= getClass().getResource(Constants.MenuWindow.MenuWindowAdmin);
            newWindows.create(path,"Menu");
            stage.hide();

        }else{
            errorMessage.setText("Wrong");
        }


    }


    public void Back(MouseEvent mouseEvent) {

        Stage stage = (Stage)backbutton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.View.HELLO_VIEW);
        newWindows.create(path,"StartWindow");
        stage.hide();
    }
}

