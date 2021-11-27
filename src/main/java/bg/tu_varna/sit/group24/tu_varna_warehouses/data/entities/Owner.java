package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="owner1")
public class Owner implements Serializable {
    private static final long serialVersionUID = 1l;

    public Long getOwner_id() {
        return owner_id;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "owner_id=" + owner_id +
                ", owner_name='" + owner_name + '\'' +
                ", agent_id=" + agent_id +
                ", pass_id='" + pass_id + '\'' +
                '}';
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public Long getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(Long agent_id) {
        this.agent_id = agent_id;
    }

    public String getPass_id() {
        return pass_id;
    }

    public void setPass_id(String pass_id) {
        this.pass_id = pass_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="owner_id",nullable = false)
    private Long owner_id;

    @Column(name="owner_name",nullable = false)
    private String owner_name;

    @Column(name="agent_id",nullable = false)
    private Long agent_id;

    @Column(name="pass_id",nullable = false)
    private String pass_id;





}
