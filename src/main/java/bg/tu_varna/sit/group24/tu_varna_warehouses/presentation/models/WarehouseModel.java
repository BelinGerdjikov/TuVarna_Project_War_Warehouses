package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class WarehouseModel {

    private SimpleIntegerProperty Id;
    private SimpleStringProperty address;
    private SimpleStringProperty size;
    private SimpleStringProperty cost;
    private SimpleStringProperty climate;

    public String getClimate() {
        return climate.get();
    }

    public void setClimate(String client) {
        this.climate = new SimpleStringProperty(client);
    }

    public String getCost() {
        return cost.get();
    }

    public void setCost(String cost) {
        this.cost = new SimpleStringProperty(cost);
    }

    public String getSize() {
        return size.get();
    }

    public void setSize(String size) {
        this.size = new SimpleStringProperty(size);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }

    public WarehouseModel(Integer warehouse_Id, String address, String size, String cost, String climate) {


        this.Id = new SimpleIntegerProperty(warehouse_Id);
        this.address = new SimpleStringProperty(address);
        this.size = new SimpleStringProperty(size);
        this.cost = new SimpleStringProperty(cost);
        this.climate = new SimpleStringProperty(climate);
    }

    public int getID() {
        return Id.get();
    }

    public void setID(int Id) {
        this.Id = new SimpleIntegerProperty(Id);
    }


}
