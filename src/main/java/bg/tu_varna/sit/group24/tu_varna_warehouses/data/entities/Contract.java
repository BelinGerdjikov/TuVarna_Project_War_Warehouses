package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="contract")
public class Contract implements Serializable {
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name="contract_id", nullable=false)
    private Contract contract;

    @Column(name="client_name",nullable = false)
    private String client_name;

    @Column(name="agent_id",nullable = false)
    private String agent_id;

    @Column(name="id_owner",nullable = false)
    private Long id_owner;

    @Column(name="id_warehouse",nullable = false)
    private Long id_ware_house;

    @Column(name="start_date",nullable = false)
    private String start_date;

    @Column(name="end_date",nullable = false)
    private String end_date;

    @Column(name="cost",nullable = false)
    private Double cost;

}
