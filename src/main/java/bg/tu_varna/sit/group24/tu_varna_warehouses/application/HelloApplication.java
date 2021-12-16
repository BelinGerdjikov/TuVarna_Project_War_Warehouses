package bg.tu_varna.sit.group24.tu_varna_warehouses.application;

import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    private static final Logger log = Logger.getLogger(HelloApplication.class);

    @Override
    public void start(Stage stage) throws IOException {

        PropertyConfigurator.configure(HelloApplication.class.getResource(Constants.Configurations.LOG4j_PROPERTIES));
        URL path= getClass().getResource("/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/hello-view.fxml");

        if(path != null){
            Parent root = FXMLLoader.load(path);

            Scene scene = new Scene(root);

            scene.setFill(Color.TRANSPARENT);

            stage.setTitle(Constants.Values.Title);
            String css = this.getClass().getResource("/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/ApplicationStyle.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);

            stage.setResizable(false);

            /*stage.setMaxWidth(600);
            stage.setMaxHeight(500);

            stage.setWidth(600);
            stage.setHeight(435);*/

            stage.show();
        }else{
            log.error("Sorry, the main fxml could not be loaded.");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
