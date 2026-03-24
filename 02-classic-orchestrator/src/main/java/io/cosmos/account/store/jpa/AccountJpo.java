package io.cosmos.account.store.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import io.cosmos.account.aggregate.Account;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_ACCOUNT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountJpo {

    @Id
    private String no;
    private int balance;

    @Version
    private long version;

    public AccountJpo(Account account) {
        this.no = account.getNo();
        this.balance = account.getBalance();
        this.version = account.version();
    }

    public Account toAccount() {
        return new Account(this.no, this.balance, this.version);
    }
}
