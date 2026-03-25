package io.cosmos.transfer.store.jpa;

import io.cosmos.transfer.aggregate.Transfer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "TB_TRANSFER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferJpo {

    @Id
    private String transferId;
    private String fromAccount;
    private boolean withdrawed;
    private String toAccount;
    private boolean deposited;
    private int amount;
    private boolean completed;

    @Version
    private long version;

    public TransferJpo(Transfer transfer) {
        this.transferId = transfer.getTransferId();
        this.fromAccount = transfer.getFromAccount();
        this.withdrawed = transfer.isWithdrawed();
        this.toAccount = transfer.getToAccount();
        this.deposited = transfer.isDeposited();
        this.amount = transfer.getAmount();
        this.completed = transfer.isCompleted();
        this.version = transfer.version();
    }

    public Transfer toTransfer() {
        return new Transfer(this.transferId,
                this.fromAccount, this.withdrawed,
                this.toAccount, this.deposited,
                this.amount,
                this.completed,
                this.version);
    }
}
