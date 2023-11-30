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
        return ResponseEntity.ok("Account created successfully: " + account.getEmail());
        
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public boolean loginAccount(@RequestBody AccountDto accountDto){
        Account account = accountDto.getAccount();
        Account realAccount = accountService.getAccount(account.getEmail());
        String realPassword = realAccount.getPassword();
        if (realPassword.equals(account.getPassword())){
            return true;
        }
        return false;
    }

    @PostMapping("/addmodule")
    public ResponseEntity<String> addModule(@RequestBody ModuleDto moduleDto, @RequestParam String email) {
        Module module = accountService.addModule(email, moduleDto.getName(), moduleDto.getDescription());
        return ResponseEntity.ok("Module added successfully: " + module.getName());
    }

    @PostMapping("/updatemodule")
    public ResponseEntity<String> updateModule(@RequestBody ModuleDto moduleDto) {
        accountService.updateHighestScore(moduleDto.getName(), moduleDto.getHighestScore());
        return ResponseEntity.ok("Updated module successfully");
    }

}
