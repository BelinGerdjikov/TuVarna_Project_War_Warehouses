package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models;

public class OwnerStatisticsAdmin {
    private int owner_id;
    private String owner_name;
    private int deals;
    private double profit;

    public OwnerStatisticsAdmin(int owner_id, String owner_name, int deals, double profit) {
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.deals = deals;
        this.profit = profit;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public int getDeals() {
        return deals;
    }

    public void setDeals(int deals) {
        this.deals = deals;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
