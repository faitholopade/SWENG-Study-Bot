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

    public Module(String name, String description, double highestScore) {
        this.name = name;
        this.description = description;
        this.highestScore = highestScore;
    }

    public Module() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(double highestScore) {
        this.highestScore = highestScore;
    }
}
