package pl.tweeter.Tweeter.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String text;
    @ManyToOne
    private User user;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;



}
