package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="warehouse")
public class WareHouse implements Serializable {
    private static final long serialVersionUID = 1l;

    @Override
    public String toString() {
        return "WareHouse{" +
                "warehouse_id=" + warehouse_id +
                ", size=" + size +
                ", climate='" + climate + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="warehouse_id",nullable = false)
    private Long warehouse_id;

    @Column(name="size",nullable = false)
    private Long size;

    @Column(name="climate",nullable = false)
    private String climate;

    @Column(name="cost",nullable = false)
    private Double cost;

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


}