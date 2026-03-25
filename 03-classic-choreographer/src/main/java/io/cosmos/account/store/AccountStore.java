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

    private AccountRepository accountRepository;


    public void create(Account account) {
        this.accountRepository.save(new AccountJpo(account));
    }

    public Account retrieve(String no) {
        Optional<AccountJpo> jpo = this.accountRepository.findById(no);
        if (jpo.isEmpty()) {
            throw new NoSuchElementException();
        }
        return jpo.get().toAccount();
    }

    public void update(Account account) {
    }
}
