package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Agent;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
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
import org.apache.log4j.Logger;

import java.net.URL;

public class AgentloginController implements EventHandler<MouseEvent> {

    private static final Logger log = Logger.getLogger(AgentloginController.class);

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

//getting the login id
        int temp=LoginRepository.login_cheak(Agentusername.getText(),Agentpassword.getText());
        System.out.println(temp);
        //getting the login id
        int temp2=AgentRepository.loginINAgent(temp);
        System.out.println(temp);
        Constants.ID_save.agent=temp2;
        //getting the login id
        if(temp2>0){
            Stage stage = (Stage)backbutton.getScene().getWindow();
            CreatingNewWindows newWindows = new CreatingNewWindows();
            URL path= getClass().getResource(Constants.MenuWindow.MenuWindowAgent);
            newWindows.create(path,"StartWindow");
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

