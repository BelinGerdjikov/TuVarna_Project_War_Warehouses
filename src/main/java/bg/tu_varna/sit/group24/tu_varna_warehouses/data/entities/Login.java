package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;


import javax.persistence.*;
import java.io.Serializable;

@Table(name="login")
public class Login implements Serializable {
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(mappedBy = "login")
    private Login login;


    @Column(name= "user_name",nullable = false)
    private String username;


    @Column(name= "password1",nullable = false)
    private String password;


}
