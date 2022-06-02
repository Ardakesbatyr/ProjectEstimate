package kz.projectestimate.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(nullable = false, length = 50, unique = true)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
 
    public User() { }
     
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
     
}
