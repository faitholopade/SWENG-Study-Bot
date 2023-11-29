package ie.tcd.scss.studybot.service;
import ie.tcd.scss.studybot.domain.Account;
import ie.tcd.scss.studybot.repo.AccountRepository;
import ie.tcd.scss.studybot.domain.Module;
import ie.tcd.scss.studybot.repo.ModuleRepository;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, ModuleRepository moduleRepository) {
        this.accountRepository = accountRepository;
        this.moduleRepository = moduleRepository;
    }

    public Account createAccount(String email, String name, String username, String password) {
        return accountRepository.save(new Account(email, name, username, password, new ArrayList<Module>()));
    }

    public Account getAccount(String email) {
        Optional<Account> account = accountRepository.findById(email);
        return account.orElse(null);
    }

}
