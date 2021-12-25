package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models;

public class ProfitAgent {
    private Integer deals;
    private Double Profit;
    private Integer agent_id;
    private Integer Commission;


    public ProfitAgent(Integer deals, Double profit, Integer agent_id, Integer commission) {
        this.deals = deals;
        Profit = profit;
        this.agent_id = agent_id;
        Commission = commission;
    }

    public Integer getDeals() {
        return deals;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public Double getProfit() {
        return Profit;
    }

    public void setProfit(Double profit) {
        Profit = profit;
    }

    public Integer getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(Integer agent_id) {
        this.agent_id = agent_id;
    }

    public Integer getCommission() {
        return Commission;
    }

    public void setCommission(Integer commission) {
        Commission = commission;
    }
}
