package ie.tcd.scss.studybot.controller;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import ie.tcd.scss.studybot.domain.Account;
import ie.tcd.scss.studybot.domain.Module;

public class AccountDto {

    private Account account;

    public AccountDto(Account account) {
        this.account = account;
    }

    protected AccountDto() {
    }

    public Account getAccount(){
        return account;
    }
    public String getEmail() {
        return account.getEmail();
    }

    public String getName() {
        return account.getName();
    }

    public String getUsername(){
        return account.getUsername();
    }

    public String getPassword(){
        return account.getPassword();
    }

    public void setPassword(String password){
        account.setPassword(password);
    }

    public List<Module> getModules(){
        return account.getModules();
    }

    public void setModules(List<Module> modules){
        this.account.setModules(modules);
    }

    public boolean loginAccount(String username, String password){
        if (account.getUsername().equals(username) && account.getPassword().equals(password)){
            return true;
        }
        return false;
    }



    
}
