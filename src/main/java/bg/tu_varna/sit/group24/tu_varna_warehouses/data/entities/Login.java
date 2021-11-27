package bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities;


import javax.persistence.*;
import java.io.Serializable;

@Table(name="login")
public class Login implements Serializable {
    private static final long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "login_id",nullable = false)
    private Long login_id;


    @Column(name= "user_name",nullable = false)
    private String username;


    @Column(name= "password1",nullable = false)
    private String password;

    public Long getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Long login_id) {
        this.login_id = login_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "login_id=" + login_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
