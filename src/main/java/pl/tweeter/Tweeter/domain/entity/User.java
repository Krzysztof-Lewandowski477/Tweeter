package pl.tweeter.Tweeter.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
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

    @ManyToMany
    private Set<Role> roles = new HashSet<> ( );
    @OneToMany
    private List<Comment> comment= new ArrayList<> (  );

    @OneToMany(mappedBy = "receiver")
    private List<Message> messagesRecived;

    @OneToMany(mappedBy = "user")
    private List<Message> messagesSended;



}
