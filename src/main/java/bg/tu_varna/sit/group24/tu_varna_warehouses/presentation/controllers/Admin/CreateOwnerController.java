package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin;

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

public class CreateOwnerController implements EventHandler<MouseEvent> {

    @FXML
    private TextField Owner_Name;

    @FXML
    private TextField Login_name;

    @FXML
    private Button back;

    @FXML
    private Button create;

    @FXML
    private PasswordField password1;

    @FXML
    private PasswordField password2;

    @FXML
    private Label errorMessage;

    @FXML
    private void initialize(){
        back.setOnMouseClicked(this::handle);
        create.setOnMouseClicked(this::create);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stage = (Stage)back.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuWindow.MenuWindowAdmin);
        newWindows.create(path,"Admin Menu");
        stage.hide();

    }

    public void create(MouseEvent mouseEvent) {


        String name1=Owner_Name.getText();
        String login_name=Login_name.getText();
        String pass1=password1.getText();
        String pass2=password2.getText();



        boolean valid=true;

        if(name1.length()==0){
            errorMessage.setText("The name field is empty");

            valid=false;
        }
        else if(login_name.length()==0){
            errorMessage.setText("The username field is empty");
            valid=false;
        }
        else if(pass1.length()<5){
            errorMessage.setText("Your password is not strong enough");
            valid=false;
        }
        else if(pass1.equals(pass2)==false){
            errorMessage.setText("You need to the same password on fields!");
            valid=false;
        }

        System.out.println("pass1"+pass1);
        System.out.println("pass2"+pass2);

        if( valid) {
            errorMessage.setText("");


            if (!LoginRepository.isUsedName(login_name)) {


                int temp = LoginRepository.CreateLogin(login_name, pass1);

                System.out.println(temp);

                OwnerRepository.CreateOwner(name1, temp);

                errorMessage.setText("You created a owner account successfully");

            } else {
                errorMessage.setText("The username " + login_name + " is already taken");
            }
        }



    }
}
