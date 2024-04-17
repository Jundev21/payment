package com.bankingPayment.application.port.in;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class BankAccountFindCommand {

    @NotNull
    private Long userId;

    public BankAccountFindCommand(Long userId) {
        this.userId = userId;
    //        this.validateSelf();
    }
}
