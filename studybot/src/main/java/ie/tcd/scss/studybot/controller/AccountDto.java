package ie.tcd.scss.studybot.controller;
import java.lang.reflect.Array;
import java.util.ArrayList;

import ie.tcd.scss.studybot.domain.Account;
import ie.tcd.scss.studybot.domain.Module;

public class AccountDto {

    private String email;
    private String name;
    private String username;
    private String password;
    private ArrayList<Module> modules;  

    public AccountDto(Account account) {
        this.email = account.getEmail();
        this.name = account.getName();
        this.username = account.getUsername();
        this.password = account.getPassword();
    }

    public AccountDto(String email, String name, String username, String password) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
    protected AccountDto() {
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String setPassword(String password){
        return this.password = password;
    }

    public ArrayList<Module> getModules(){
        return modules;
    }

    public void setModules(ArrayList<Module> modules){
        this.modules = modules;
    }

    public boolean loginAccount(String username, String password){
        if (this.username.equals(username) && this.password.equals(password)){
            return true;
        }
        return false;
    }



    
}
