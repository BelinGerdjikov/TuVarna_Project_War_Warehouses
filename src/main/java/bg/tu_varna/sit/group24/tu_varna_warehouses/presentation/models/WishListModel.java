package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models;

public class WishListModel {
    private Integer warehouse_id;


    public WishListModel(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Integer getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }


}
