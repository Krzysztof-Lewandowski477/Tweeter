package pl.tweeter.Tweeter.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Slf4j
@Table(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne(optional = false)
//    private User userTweet;
    private String text;
    private LocalDateTime created;
}
