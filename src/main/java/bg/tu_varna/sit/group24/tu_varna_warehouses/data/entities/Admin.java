package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="admin1")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id",nullable = false)
    private Long admin_id;


    @Column(name="login_id",nullable = false)
    private Long login_id;

    @Column(name="pass",nullable = false)
    private String pass;


    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public Long getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Long login_id) {
        this.login_id = login_id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", login_id=" + login_id +
                ", pass=" + pass +
                '}';
    }
}