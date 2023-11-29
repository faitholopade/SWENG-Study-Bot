package ie.tcd.scss.studybot.controller;
import ie.tcd.scss.studybot.domain.Account;
import ie.tcd.scss.studybot.domain.Module;
import ie.tcd.scss.studybot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    protected AccountController(){
    }

    @PostMapping("/register")
    public ResponseEntity<String> createAccount(@RequestBody AccountDto accountDto){
        Account account = accountDto.getAccount();
        accountService.createAccount(account.getEmail(), account.getName(), account.getUsername(), account.getPassword());
        return ResponseEntity.ok("Account created successfully");
        
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public boolean loginAccount(@RequestBody AccountDto accountDto){
        Account account = accountDto.getAccount();
        return accountService.loginAccount(account.getUsername(), account.getPassword());
    }

}
