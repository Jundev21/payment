package com.bankingPayment.adapter.in.web;

import com.bankingPayment.application.port.in.BankAccountRegisterCommand;
import com.bankingPayment.application.port.in.BankAccountRegisterUseCase;
import com.bankingPayment.domain.BankingInfo;
import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.common.WebAdapter;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetBankAccountRegisterController {

    private final BankAccountRegisterUseCase bankAccountRegisterUseCase


    @PostMapping("banking/account/register")
    BankingInfo registerBankAccount(
            @RequestBody GetBankAccountRegisterRequest request
    ) {
        BankAccountRegisterCommand bankAccountRegisterCommand =
                BankAccountRegisterCommand.builder()
                        .build();

    };

}
