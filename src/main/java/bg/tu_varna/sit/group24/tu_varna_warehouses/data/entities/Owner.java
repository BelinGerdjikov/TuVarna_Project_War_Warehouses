package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name="owner1")
public class Owner implements Serializable {
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name="owner_id", nullable=false)
    private Owner owner;

    @Column(name="owner_name",nullable = false)
    private String owner_name;

    @Column(name="contract_id",nullable = true)
    private Long contract_id;

    @Column(name="agent_id",nullable = true)
    private Long agent_id;

    @Column(name="warehouse_id",nullable = true)
    private Long warehouse_id;

    @OneToMany(mappedBy="warehouse")
    private Set<WareHouse> wareHouses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    private Login login;




}
