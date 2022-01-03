package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class AdminMenuController implements EventHandler<MouseEvent> {
    @FXML
    private Button Create_warehouse;

    @FXML
    private Button Reference;

    @FXML
    private Button Update_warehouse;

    @FXML
    private Button backButton;

    @FXML
    private Button create_agent_button;

    @FXML
    private Button create_owner_button;

    @FXML
    private Button Agents_ratings;


    @FXML
    private void initialize(){
        backButton.setOnMouseClicked(this::handle);
        create_agent_button.setOnMouseClicked(this::create_agent);
        create_owner_button.setOnMouseClicked(this::create_owner);
        Reference.setOnMouseClicked(this::Reference);
        Update_warehouse.setOnMouseClicked(this::Update_warehouse);
        Create_warehouse.setOnMouseClicked(this::Create_warehouse);
        Agents_ratings.setOnMouseClicked(this::Agents_ratings);
    }

    //Дepending on the pressed button, the corresponding window opens

    public void Agents_ratings(MouseEvent mouseEvent){
        Stage stage = (Stage)backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuCreate.Statistic_Agent);
        newWindows.create(path,"Statistic Agent");
        stage.hide();
    }

    public void Update_warehouse(MouseEvent mouseEvent){
        Stage stage = (Stage)backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.Update.Reference);
        newWindows.create(path,"Update warehouse");
        stage.hide();
    }

    public void Reference(MouseEvent mouseEvent){
        Stage stage = (Stage)backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.Reference.ReferenceOwner);
        newWindows.create(path,"Reference");
        stage.hide();
    }

    public void Create_warehouse(MouseEvent mouseEvent){
        Stage stage = (Stage)backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuCreate.MenuCreateWarehouseAdmin);
        newWindows.create(path,"Create warehouse");
        stage.hide();
    }

    public void create_agent(MouseEvent mouseEvent) {
        Stage stage = (Stage)backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuCreate.MenuCreateAgent);
        newWindows.create(path,"Create Agent Menu");
        stage.hide();

    }

    public void create_owner(MouseEvent mouseEvent) {
        Stage stage = (Stage)backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuCreate.MenuCreateOwner);
        newWindows.create(path,"Create Menu");
        stage.hide();

    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        Stage stage = (Stage)backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.View.HELLO_VIEW);
        newWindows.create(path,"Login Menu");
        stage.hide();
    }



}
