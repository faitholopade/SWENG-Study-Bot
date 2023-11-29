package ie.tcd.scss.studybot.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    private String email;

    @Column
    private String name;

    @Column
    private String username;
    
    @Column
    private String password;

    @OneToMany
    private List<Module> modules;

    public Account(String email, String name, String username, String password, List<Module> modules) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
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

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules2) {
        this.modules = modules2;
    }
}
