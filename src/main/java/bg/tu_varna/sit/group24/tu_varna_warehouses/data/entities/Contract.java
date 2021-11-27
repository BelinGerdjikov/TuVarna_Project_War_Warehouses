package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="contract")
public class Contract implements Serializable {
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contract_id",nullable = false)
    private Long contract_id;

    @Column(name="agent_name",nullable = false)
    private String agent_name;

    @Column(name="agent_id",nullable = false)
    private String agent_phone;

    @Column(name="start_date",nullable = false)
    private String start_date;

    @Column(name="end_date",nullable = false)
    private String end_date;

    @Column(name="money",nullable = false)
    private Double money;

    @Column(name="id_owner",nullable = false)
    private Long id_owner;

    @Column(name="id_ware_house",nullable = false)
    private Long id_ware_house;

    @Override
    public String toString() {
        return "Contract{" +
                "contract_id=" + contract_id +
                ", agent_name='" + agent_name + '\'' +
                ", agent_phone='" + agent_phone + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", money=" + money +
                ", id_owner=" + id_owner +
                ", id_ware_house=" + id_ware_house +
                '}';
    }
}
