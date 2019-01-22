package application.services.account;

import application.models.Account;
import application.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Primary
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        if (money.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Money cannot be negative!");
        }
        if (!this.accountRepository.exists(id)){
            throw new IllegalArgumentException("No such user!");
        }
        if(this.accountRepository.findOne(id).getBalance().subtract(money).compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalStateException("Insufficient balance!");
        }

        Account account = this.accountRepository.findOne(id);
        BigDecimal newBalance = account.getBalance().subtract(money);
        account.setBalance(newBalance);
        this.accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        if (money.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Money cannot be negative!");
        }
        if (!this.accountRepository.exists(id)){
            throw new IllegalArgumentException("No such account!");
        }

        Account account = this.accountRepository.findOne(id);
        BigDecimal newBalance = account.getBalance().add(money);
        account.setBalance(newBalance);
        this.accountRepository.save(account);
    }
}
