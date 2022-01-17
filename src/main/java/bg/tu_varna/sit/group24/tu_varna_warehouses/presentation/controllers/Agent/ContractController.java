package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Agent;

import bg.tu_varna.sit.group24.tu_varna_warehouses.application.CreatingNewWindows;
import bg.tu_varna.sit.group24.tu_varna_warehouses.common.Constants;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.DataBaseConnection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.AgentRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.ContractRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.WareHouseRepository;
import bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models.WarehouseModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ContractController implements EventHandler<MouseEvent> {

    @FXML
    private Button BackButton;

    @FXML
    private TableColumn<WarehouseModel, Integer> Id_warehouse;

    @FXML
    private TableColumn<WarehouseModel, String> address;

    @FXML
    private TableColumn<WarehouseModel, String> climate;

    @FXML
    private TableColumn<WarehouseModel, Double> price;

    @FXML
    private TableColumn<WarehouseModel,String> size;

    @FXML
    private TableView<WarehouseModel> Display;

    @FXML
    private Label Expence;

    @FXML
    private DatePicker enddate;

    @FXML
    private DatePicker startdate;

    @FXML
    private TextField tenant;

    @FXML
    private TextField warehouse_id;

    @FXML
    private Button calculate;

    @FXML
    private Button create;

    @FXML
    private Label errrorMessage;



    static Connection conn;

    ObservableList<WarehouseModel> oblist= FXCollections.observableArrayList();

    LocalDate endDate;

    LocalDate startDate;




    @FXML
    private void initialize() throws SQLException {

        create.setOnMouseClicked(this::create);
        calculate.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::BackButton);




        Id_warehouse.setCellValueFactory(new PropertyValueFactory<>("ID"));
        address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        price.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        climate.setCellValueFactory(new PropertyValueFactory<>("Climate"));
        setTableView();




    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        boolean valid=true;
        try {

            startDate=startdate.getValue();
            endDate=enddate.getValue();

            if (!(Integer.parseInt(warehouse_id.getText()) > 0)) {
                valid=false;
                errrorMessage.setText("Wrong ID");
            }

            if(!(tenant.getText().length()>4)){
                valid=false;
                errrorMessage.setText("The name need to be at least 5 symbols");
            }



            if(startDate.compareTo(endDate)*-1+1<2){
                errrorMessage.setText("Unvalid time frame");
            }




            if(valid){
                int days=(startDate.compareTo(endDate)*-1+1);

                int owner= WareHouseRepository.finding_owner(Integer.parseInt(warehouse_id.getText()));
                //System.out.println(days);.

                double full_price=0;
                full_price=WareHouseRepository.finding_price(Integer.parseInt(warehouse_id.getText()))*days;

                full_price=full_price+(full_price*((AgentRepository.get_commission(Constants.ID_save.agent)))/100);
                Expence.setText("The cost will be "+full_price+"$");
            }


            valid=true;


        }catch(Exception ex){
            errrorMessage.setText("Unvalid input");
        }

    }


    private void BackButton(MouseEvent mouseEvent) {
        Stage stage = (Stage)BackButton.getScene().getWindow();
        CreatingNewWindows newWindows = new CreatingNewWindows();
        URL path= getClass().getResource(Constants.MenuWindow.MenuWindowAgent);
        newWindows.create(path,"Agent Menu");
        stage.hide();
    }


    private void create(MouseEvent mouseEvent) {
        //Creating Contract
        boolean valid=true;
        try {

            startDate=startdate.getValue();
            endDate=enddate.getValue();

            //validating
            if (!(Integer.parseInt(warehouse_id.getText()) > 0)) {
                valid=false;
                errrorMessage.setText("Wrong ID");
            }

            if(!(tenant.getText().length()>4)){
                valid=false;
                errrorMessage.setText("The name need to be at least 5 symbols");
            }



            if(startDate.compareTo(endDate)*-1+1<2){
                errrorMessage.setText("Unvalid time frame");
            }

            int days=(startDate.compareTo(endDate)*-1+1);

            //Finding the owner of the warehouse
            int owner= WareHouseRepository.finding_owner(Integer.parseInt(warehouse_id.getText()));



            double full_price=0;
            full_price=WareHouseRepository.finding_price(Integer.parseInt(warehouse_id.getText()))*days;

            full_price=full_price+(full_price*((AgentRepository.get_commission(Constants.ID_save.agent)))/100);

            if(valid){
                errrorMessage.setText("The contract is created");
                ContractRepository.CreateContract(tenant.getText(),Constants.ID_save.agent,owner,Integer.parseInt(warehouse_id.getText()),startDate.toString(),endDate.toString(),full_price);
                //ContractRepository.CreateContract("Belin",9,3,3,"2021-12-22","2021-12-24",300.5);
                WareHouseRepository.refresh();
            }


            valid=true;
            setTableView();

        }catch(Exception ex){
            errrorMessage.setText("Unvalid input");
        }
    }


    public void setTableView() throws SQLException {
        //Setting / resetting the information in the TableView
        conn= DataBaseConnection.getConnection();

        String sql = "SELECT warehouse_id,address,cost,size,climate FROM warehouse where is_available=true";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);

        Display.getItems().clear();

        while(rs.next()){
            oblist.add(new WarehouseModel(rs.getInt("warehouse_id"),rs.getString("address"),rs.getString("size"),rs.getString("cost"),rs.getString("climate")));

        }

        Display.setItems(oblist);


    }



}
