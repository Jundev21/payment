package com.bankingPayment.application.service;

import org.springframework.stereotype.Service;

import com.bankingPayment.application.port.in.BankAccountEditCommand;
import com.bankingPayment.application.port.in.BankAccountEditUseCase;
import com.bankingPayment.domain.BankingInfo;
import com.payment.common.UserCase;

import lombok.AllArgsConstructor;

@Service
@UserCase
@AllArgsConstructor
public class BankAccountEditService implements BankAccountEditUseCase {

    @Override
    public BankingInfo editUserInfo(BankAccountEditCommand userEditCommand) {
        return null;
    }
}
