package io.cosmos.transfer.store;

import io.cosmos.transfer.aggregate.Transfer;
import io.cosmos.transfer.store.jpa.TransferJpo;
import io.cosmos.transfer.store.jpa.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TransferStore {

    private final TransferRepository transferRepository;

    public void create(Transfer transfer) {
        this.transferRepository.save(new TransferJpo(transfer));
    }

    public Transfer retrieve(String transferId) {

        Optional<TransferJpo> transferJpoOptional = this.transferRepository.findById(transferId);

        if(transferJpoOptional.isEmpty()){
            throw new NoSuchElementException();
        }
        return transferJpoOptional.get().toTransfer();
    }

    public void update(Transfer transfer) {
        this.transferRepository.save(new TransferJpo(transfer));
    }
}
