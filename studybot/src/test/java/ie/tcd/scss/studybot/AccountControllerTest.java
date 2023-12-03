package ie.tcd.scss.studybot;

import ie.tcd.scss.studybot.controller.AccountController;
import ie.tcd.scss.studybot.controller.AccountDto;
import ie.tcd.scss.studybot.controller.ModuleDto;
import ie.tcd.scss.studybot.domain.Account;
import ie.tcd.scss.studybot.domain.Module;
import ie.tcd.scss.studybot.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAccount() {
        // Arrange
        AccountDto accountDto = new AccountDto();
        Account account = new Account();
        account.setEmail("test@example.com");
        account.setName("Test User");
        account.setUsername("testuser");
        account.setPassword("password");
        accountDto.setAccount(account);

        // Act
        ResponseEntity<String> response = accountController.createAccount(accountDto);

        // Assert
        assertEquals("Account created successfully: " + account.getEmail(), response.getBody());
        verify(accountService, times(1)).createAccount(account.getEmail(), account.getName(), account.getUsername(), account.getPassword());
    }

    @Test
    public void testLoginAccount() {
        // Arrange
        AccountDto accountDto = new AccountDto();
        Account account = new Account();
        account.setEmail("test@example.com");
        account.setPassword("password");
        accountDto.setAccount(account);

        Account realAccount = new Account();
        realAccount.setEmail("test@example.com");
        realAccount.setPassword("password");

        when(accountService.getAccount(anyString())).thenReturn(realAccount);

        // Act
        boolean loginResult = accountController.loginAccount(accountDto);

        // Assert
        assertTrue(loginResult);
        verify(accountService, times(1)).getAccount(account.getEmail());
    }

    @Test
    public void testAddModule() {
        // Arrange
        ModuleDto moduleDto = new ModuleDto();
        Module module = new Module();
        module.setName("Test Module");
        module.setDescription("This is a test module.");
        moduleDto.setModule(module);

        String email = "test@example.com";

        Module module1 = new Module();
        module1.setName("Test Module");

        when(accountService.addModule(anyString(), anyString(), anyString())).thenReturn(module1);

        // Act
        ResponseEntity<String> response = accountController.addModule(moduleDto, email);

        // Assert
        assertEquals("Module added successfully: " + module.getName(), response.getBody());
        verify(accountService, times(1)).addModule(email, moduleDto.getName(), moduleDto.getDescription());
    }

    @Test
    public void testUpdateModule() {
        // Arrange
        ModuleDto moduleDto = new ModuleDto();
        Module module = new Module();
        module.setName("Test Module");
        module.setHighestScore(100);
        moduleDto.setModule(module);

        doNothing().when(accountService).updateHighestScore(anyString(), anyInt());

        // Act
        ResponseEntity<String> response = accountController.updateModule(moduleDto);

        // Assert
        assertEquals("Updated module successfully", response.getBody());
        verify(accountService, times(1)).updateHighestScore(moduleDto.getName(), moduleDto.getHighestScore());
    }
}


