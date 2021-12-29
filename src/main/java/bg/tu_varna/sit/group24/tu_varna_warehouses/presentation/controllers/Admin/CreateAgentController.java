package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.business.services.CreatingAcounts;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.AgentRepository;
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

public class CreateAgentController implements EventHandler<MouseEvent> {

    @FXML
    private Button back;

    @FXML
    private Button create;

    @FXML
    private Label error;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password1;

    @FXML
    private PasswordField password2;

    @FXML
    private TextField username;


    @FXML
    private void initialize(){
        create.setOnMouseClicked(this::create);
        back.setOnMouseClicked(this::handle);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if(password1!=password2){
            error.setText("You need to the same password on fields");
        }

        Stage stage = (Stage)back.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuWindow.MenuWindowAdmin);
        newWindows.create(path,"Admin Menu");
        stage.hide();

    }

    public void create(MouseEvent mouseEvent) {

        String login_name=username.getText();
        String name1=name.getText();
        String pass1=password1.getText();
        String pass2=password2.getText();


        String valid= CreatingAcounts.input_validation(name1,login_name,pass1,pass2);


        if( valid=="good") {
            error.setText("");


            if (!LoginRepository.isUsedName(login_name)) {


                int temp = LoginRepository.CreateLogin(login_name, pass1);

                System.out.println(temp);

                AgentRepository.CreateAgent(name1, temp);

                error.setText("You created a agent account successfully");

            } else {
                error.setText("The username " + login_name + " is already taken");
            }

        }




    }
}
