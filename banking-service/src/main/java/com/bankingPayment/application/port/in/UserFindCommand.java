package com.bankingPayment.application.port.in;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class UserFindCommand {

    @NotNull
    private Long userId;

    public UserFindCommand(Long userId) {
        this.userId = userId;
    //        this.validateSelf();
    }
}
