package bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models;

public class AgentModel {
    private Integer id_agent;
    private String agent_name;
    private Integer commission;
    private Double rating;
    private Integer Deals;
    private Double Earned_money;

    public AgentModel(Integer id_agent, String agent_name, Integer commission, Double rating, Integer deals, Double earned_money) {
        this.id_agent = id_agent;
        this.agent_name = agent_name;
        this.commission = commission;
        this.rating = rating;
        Deals = deals;
        Earned_money = earned_money;
    }

    @Override
    public String toString() {
        return "AgentModel{" +
                "id_agent=" + id_agent +
                ", agent_name='" + agent_name + '\'' +
                ", commission=" + commission +
                ", rating=" + rating +
                ", Deals=" + Deals +
                ", Earned_money=" + Earned_money +
                '}';
    }

    public Integer getId_agent() {
        return id_agent;
    }

    public void setId_agent(Integer id_agent) {
        this.id_agent = id_agent;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getDeals() {
        return Deals;
    }

    public void setDeals(Integer deals) {
        Deals = deals;
    }

    public Double getEarned_money() {
        return Earned_money;
    }

    public void setEarned_money(Double earned_money) {
        Earned_money = earned_money;
    }
}
