package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models;

public class warehouseReferenceModel {
    private Integer warehouse_id;
    private Integer deals;
    private Double profit;
    private Double cost_per_day;

    public warehouseReferenceModel(Integer warehouse_id, Integer deals, Double profit, Double cost_per_day) {
        this.warehouse_id = warehouse_id;
        this.deals = deals;
        this.profit = profit;
        this.cost_per_day = cost_per_day;
    }

    public Integer getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Integer getDeals() {
        return deals;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getCost_per_day() {
        return cost_per_day;
    }

    public void setCost_per_day(Double cost_per_day) {
        this.cost_per_day = cost_per_day;
    }
}
