package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Agent;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.AgentRepository;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class AgentMenuController implements EventHandler<MouseEvent> {


    @FXML
    private Button backButton;

    @FXML
    private Button client_info;

    @FXML
    private Label comm_now;

    @FXML
    private TextField commission_field;

    @FXML
    private Button market;

    @FXML
    private Button update_commission;

    @FXML
    private Label errorMessage;

    @FXML
    private Button wish_list;


    @FXML
    private void initialize(){
        backButton.setOnMouseClicked(this::handle);
        market.setOnMouseClicked(this::market);
        client_info.setOnMouseClicked(this::client_info);
        update_commission.setOnMouseClicked(this::update);
        errorMessage.setText("");
        int temp=(AgentRepository.get_commission(Constants.ID_save.agent));
        comm_now.setText(String.valueOf(temp)+"%");
        wish_list.setOnMouseClicked(this::WishList);

       // if(WishListRepository.availableInWishList(Constants.ID_save.agent)){
       //     Stage stage = (Stage) backButton.getScene().getWindow();
       //     CreatingNewWindows newWindows = new CreatingNewWindows();
       //     URL path = getClass().getResource(Constants.MenuWindow.MenuWindowNotification);
       //     newWindows.create(path, "Notification");
//
       // }
    }


    public void WishList(MouseEvent mouseEvent) {

        Stage stage = (Stage) backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path = getClass().getResource(Constants.Update.WishList);
        newWindows.create(path, "WishList");
        stage.hide();
    }


    public void update(MouseEvent mouseEvent) {
        try {


        int comm=Integer.parseInt(commission_field.getText());
        if(comm>-1&&comm<21){

//Updating the repository
        AgentRepository.update_commission(comm);

        int temp=(AgentRepository.get_commission(Constants.ID_save.agent));
        comm_now.setText(String.valueOf(temp)+"%");
            errorMessage.setText("");
        }else{
            errorMessage.setText("The commission can be between 0 and 20%");
        }
        }catch(Exception ex){
            errorMessage.setText("Invalid input");
        }
    }

    public void market(MouseEvent mouseEvent) {

            Stage stage = (Stage) backButton.getScene().getWindow();
            CreatingNewWindows newWindows = new CreatingNewWindows();
            URL path = getClass().getResource(Constants.MenuCreate.MenuCreateContract);
            newWindows.create(path, "Market");
            stage.hide();

    }



    public void client_info(MouseEvent mouseEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path = getClass().getResource(Constants.Info.info);
        newWindows.create(path, "Info");
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
