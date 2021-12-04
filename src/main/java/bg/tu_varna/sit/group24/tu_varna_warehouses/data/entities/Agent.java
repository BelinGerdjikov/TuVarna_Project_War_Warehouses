package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;



import javax.persistence.*;
import java.io.Serializable;

@Table(name="agent")
public class Agent implements Serializable {
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name="agent_id", nullable=false)
    private Agent agent;

    @Column(name="agent_name",nullable = false)
    private String agent_name;


    @ManyToOne
    @JoinColumn(name="contract_id", nullable=false)
    private Contract contract;

    @Column(name="rating",nullable = true)
    private Double rating;

    @Column(name="commission_proc",nullable = false)
    private Double commission;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    private Login login;


}