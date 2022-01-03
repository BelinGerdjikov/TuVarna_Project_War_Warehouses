package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Owner;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.LoginRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.OwnerRepository;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;


public class OwnerloginController implements EventHandler<MouseEvent>
{

    @FXML
    private PasswordField Ownerpassword;

    @FXML
    private TextField Ownerusername;

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

        //getting the login id
        //getting the login id
        Constants.ID_save.owner=OwnerRepository.loginINOwner(LoginRepository.login_cheak(Ownerusername.getText(),Ownerpassword.getText()));
        //getting the login id
        if(Constants.ID_save.owner>0){
            Stage stage = (Stage)loginButton.getScene().getWindow();
            CreatingNewWindows newWindows = new CreatingNewWindows();
            URL path= getClass().getResource(Constants.MenuWindow.MenuWindowOwner);
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
