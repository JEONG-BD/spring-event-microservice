package io.cosmos.account.service;

import io.cosmos.account.aggregate.Account;
import io.cosmos.account.command.CreateAccount;
import io.cosmos.account.command.Deposit;
import io.cosmos.account.command.Withdraw;
import io.cosmos.account.query.QueryAccount;
import io.cosmos.account.store.AccountStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountStore accountStore;

    public String createAccount(CreateAccount command) {
        return null;
    }

    public Account queryAccount(QueryAccount query) {
    }

    public void deposit(Deposit command) {

    }

    public void withdraw(Withdraw command) {

    }
}
