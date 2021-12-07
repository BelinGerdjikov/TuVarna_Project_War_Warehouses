package bg.tu_varna.sit.group24.tu_varna_warehouses.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CreatingNewWindows {
    public void create( URL path, String Title){
        Parent root;
        try{

            root= FXMLLoader.load(path);
            Stage stage = new Stage();
            stage.setTitle(Title);
            stage.setScene(new Scene(root));
            stage.show();

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
