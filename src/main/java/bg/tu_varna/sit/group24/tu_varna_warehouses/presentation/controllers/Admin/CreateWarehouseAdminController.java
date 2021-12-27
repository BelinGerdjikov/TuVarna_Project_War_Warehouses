package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.OwnerRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.WareHouseRepository;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class CreateWarehouseAdminController implements EventHandler<MouseEvent> {
    @FXML
    private TextField address;

    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<String> climate;

    @FXML
    private TextField cost_per_day;

    @FXML
    private Button create_warehouse;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField size;

    @FXML
    private TextField owner_id;

    @FXML
    private void initialize(){

        climate.getItems().add("Cold");
        climate.getItems().add("Cool");
        climate.getItems().add("Hot");

        climate.setValue("Cool");

        backButton.setOnMouseClicked(this::handle);
        create_warehouse.setOnMouseClicked(this::create);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        Stage stage = (Stage) backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path = getClass().getResource(Constants.MenuWindow.MenuWindowAdmin);
        newWindows.create(path, "Admin Menu");
        stage.hide();



    }


    public void create(MouseEvent mouseEvent) {

        boolean valid = true;

        try {
            Integer owner=Integer.parseInt(owner_id.getText());
            String address1=address.getText();
            Double cost=Double.parseDouble(cost_per_day.getText());
            Integer size1=Integer.parseInt(size.getText());



            if(OwnerRepository.Owner_id_check(owner)==-1){
                errorMessage.setText("Wrong ID");
                valid=false;
            }
            else if (address1.isEmpty()) {
                errorMessage.setText("Your address field is empty");
                valid=false;

            } else if (cost < 2) {
                errorMessage.setText("The cost of the rent of the warehouse must be more then 2 dollar per day");
                valid=false;
            } else if (size1 < 3) {
                errorMessage.setText("The size of the warehouse must be more then 3 square meters");
                valid=false;
            }


            if (valid) {
                WareHouseRepository.CreateWareHouse(address1, cost,size1, climate.getValue(), owner);
                errorMessage.setText("The new warehouse is added");
            }
        } catch (Exception exception) {
            errorMessage.setText("Invalid input");

        }
    }
}
