package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;



import javax.persistence.*;
import java.io.Serializable;

@Table(name="agent")
public class Agent implements Serializable {
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="agent_id",nullable = false)
    private Long agent_id;

    @Column(name="agent_name",nullable = false)
    private String agent_name;

    @Column(name="agent_phone",nullable = false)
    private String agent_phone;

    @Column(name="contract_id",nullable = false)
    private Long contract_id;

    @Column(name="pass",nullable = false)
    private String pass;

    @Override
    public String toString() {
        return "Agent{" +
                "agent_id=" + agent_id +
                ", agent_name='" + agent_name + '\'' +
                ", agent_phone='" + agent_phone + '\'' +
                ", contract_id=" + contract_id +
                ", pass='" + pass + '\'' +
                '}';
    }
}