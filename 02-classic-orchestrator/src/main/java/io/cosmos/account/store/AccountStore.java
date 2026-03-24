package io.cosmos.account.store;

import io.cosmos.account.store.jpa.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountStore {

    private final AccountRepository accountRepository;


}
