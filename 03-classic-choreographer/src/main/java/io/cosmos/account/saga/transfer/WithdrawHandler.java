package io.cosmos.account.saga.transfer;

import io.cosmos.account.command.Withdraw;
import io.cosmos.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WithdrawHandler {
    //
    private final AccountService accountService;

    @EventListener
    public void on(Withdraw command) {
        this.accountService.withdraw(command);
    }
}
