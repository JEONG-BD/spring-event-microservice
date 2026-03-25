package io.cosmos.transfer.command;

import io.cosmos.core.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompleteDeposit extends Command {
    private String transferId;
}
