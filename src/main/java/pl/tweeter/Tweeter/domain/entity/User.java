package pl.tweeter.Tweeter.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column (nullable = false)
    @Email
    private String email;
    private Boolean active = Boolean.TRUE;
//    @OneToMany(mappedBy = "user")
//    private List<Tweet> tweet;
    @ManyToMany
    private Set<Role> roles = new HashSet<> ( );
}
