package ie.tcd.scss.studybot;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ie.tcd.scss.studybot.controller.AccountController;
import ie.tcd.scss.studybot.controller.AccountDto;
import ie.tcd.scss.studybot.domain.Account;
import ie.tcd.scss.studybot.service.AccountService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateAccount() {
        AccountDto accountDto = new AccountDto();
        Account account = new Account();
        account.setEmail("test@example.com");
        account.setName("Test User");
        account.setUsername("testuser");
        account.setPassword("password");
        accountDto.setAccount(account);
        when(accountService.createAccount(anyString(), anyString(), anyString(), anyString())).thenReturn(account);
        ResponseEntity<String> response = accountController.createAccount(accountDto);
        assertEquals("Account created successfully: " + account.getEmail(), response.getBody());
        verify(accountService, times(1)).createAccount(account.getEmail(), account.getName(), account.getUsername(), account.getPassword());
    }
    @Test
    public void testLoginAccount() {
        AccountDto accountDto = new AccountDto();
        Account account = new Account();
        account.setEmail("test@example.com");
        account.setPassword("password");
        accountDto.setAccount(account);
        Account realAccount = new Account();
        realAccount.setEmail("test@example.com");
        realAccount.setPassword("password");
        when(accountService.getAccount(anyString())).thenReturn(realAccount);
        boolean loginResult = accountController.loginAccount(accountDto);
        assertTrue(loginResult);
        verify(accountService, times(1)).getAccount(account.getEmail());
    }


}
