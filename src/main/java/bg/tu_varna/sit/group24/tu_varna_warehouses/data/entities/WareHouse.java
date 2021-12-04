package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="warehouse")
public class WareHouse implements Serializable {
    private static final long serialVersionUID = 1l;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="warehouse_id",nullable = false)
    private Long warehouse_id;

    @Column(name="owner_id",nullable = false)
    private Long owner_id;

    @Column(name="is_empty",nullable = false)
    private Boolean is_empty;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="cost",nullable = false)
    private Double cost;

    @Column(name="type_warehouse",nullable = false)
    private String type_warehouse;

    @Column(name="size",nullable = false)
    private Long size;

    @Column(name="climate",nullable = false)
    private String climate;





}