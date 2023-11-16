package ie.tcd.scss.studybot.domain;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Account {

    @Id
    private String email;

    @Column
    private String name;

    @Column
    private String username;

    @OneToMany
    private ArrayList<Module> modules;


}
