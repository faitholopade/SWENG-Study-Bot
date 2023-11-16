package ie.tcd.scss.studybot.domain;

import jakarta.persistence.*;

@Entity
public class Module {

    @Id
    private String name;

    @Column(length = 256)
    private String description;

    @Column
    private double highestScore;
}
