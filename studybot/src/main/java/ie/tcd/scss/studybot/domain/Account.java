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

    public Account(String email, String name, String username, ArrayList<Module> modules) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.modules = modules;
    }

    public Account() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
}
