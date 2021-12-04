package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name="admin1")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id",nullable = false)
    private Long admin_id;

    @Column(name="admin_name",nullable = false)
    private String admin_name;

   // @OneToOne
   // @JoinColumn(name="login_id",nullable = false)
   // private Login login;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    private Login login;

   //@OneToMany
   //@JoinColumn(name="agent_id",nullable = true)
   //private Set<Agent> agentSet;

   //@OneToMany
   //@JoinColumn(name="owner_id",nullable = true)
   //private Set<Owner> ownerSet;


    @OneToMany(mappedBy="agent")
    private Set<Agent> agentSet;

    @OneToMany(mappedBy="owner")
    private Set<Agent> ownerSet;





}