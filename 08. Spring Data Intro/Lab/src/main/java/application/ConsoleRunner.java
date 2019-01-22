package application;

import application.models.Account;
import application.models.User;
import application.services.account.AccountService;
import application.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService,
                         AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... strings) throws Exception {
        /*User example = new User();
        example.setUsername("toshko");
        example.setAge(20);

        Account account = new Account();
        account.setBalance(new BigDecimal(25000));
        account.setOwner(example);

        example.getAccounts().add(account);

        userService.registerUser(example);

        accountService.withdrawMoney(new BigDecimal(20000),account.getId());*/

        accountService.transferMoney(new BigDecimal(10000),1L);

    }
}
