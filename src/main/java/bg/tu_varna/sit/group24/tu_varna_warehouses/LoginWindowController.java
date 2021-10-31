package bg.tu_varna.sit.group24.tu_varna_warehouses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginWindowController {

    @FXML
    private PasswordField PasswordF;

    @FXML
    private TextField UsernameF;

    @FXML
    private Label error;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void OnLoginButton(ActionEvent event) throws IOException {
        String temp="";


        temp=UsernameF.getText();






            root = FXMLLoader.load(getClass().getResource(temp+"Menu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        
    }

}