package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
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

public class CreateWarehouseController implements EventHandler<MouseEvent> {
    @FXML
    private TextField address;

    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<String> climate=new ChoiceBox<>();

    @FXML
    private TextField cost_per_day;

    @FXML
    private Button create_warehouse;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField size;

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
            URL path = getClass().getResource(Constants.MenuWindow.MenuWindowOwner);
            newWindows.create(path, "Owner Menu");
            stage.hide();



    }


    public void create(MouseEvent mouseEvent) {

        boolean valid = true;





        try {
            if (address.getText().length() == 0) {
                errorMessage.setText("Your address field is empty");

            } else if (Double.parseDouble(cost_per_day.getText()) > 2) {
                errorMessage.setText("The cost of the rent of the warehouse must be more then 2 dollar per day");

            } else if (Integer.parseInt(size.getText()) > 3) {
                errorMessage.setText("The size of the warehouse must be more then 3 square meters");
            }




            WareHouseRepository.CreateWareHouse(address.getText(), Double.parseDouble(cost_per_day.getText()), Integer.parseInt(size.getText()), climate.getValue(), Constants.ID_save.owner);


            if (valid) {
                Stage stage = (Stage) backButton.getScene().getWindow();
                CreatingNewWindows newWindows = new CreatingNewWindows();
                URL path = getClass().getResource(Constants.MenuWindow.MenuWindowOwner);
                newWindows.create(path, "Owner Menu");
                stage.hide();
            }
        } catch (Exception exception) {
            System.out.println("Neshto se bygna "+exception.getMessage());

        }
    }
}
