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
            Scene scene = new Scene(root);//creating scene
            Stage stage = new Stage();//creating stage
            stage.setTitle(Title);//renaming the stage
            String css = this.getClass().getResource("/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/ApplicationStyle.css").toExternalForm();//getting the full address of the file
            scene.getStylesheets().add(css);//addling the css file
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();//showing the window



        }
        catch(IOException ex){//if the program crash
            ex.printStackTrace();//displaying the problem
        }
    }
}
