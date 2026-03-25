package io.cosmos.account.store;

import io.cosmos.account.aggregate.Account;
import io.cosmos.account.store.jpa.AccountJpo;
import io.cosmos.account.store.jpa.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountStore {

    private final AccountRepository accountRepository;

    public void create(Account account) {
        AccountJpo accountJpo = new AccountJpo(account);
        this.accountRepository.save(accountJpo);
    }

    public Account retrieve(String no) {
        Optional<AccountJpo> accountJpoOptional = this.accountRepository.findById(no);

        if(accountJpoOptional.isEmpty()){
            throw new NoSuchElementException();
        }
        return accountJpoOptional.get().toAccount();
    }

    public void update(Account account) {
        //
        this.accountRepository.save(new AccountJpo(account));
    }
}
