package com.bankingPayment.application.port.in;

import com.bankingPayment.domain.BankingInfo;

public interface BankAccountRegisterUseCase {
    BankingInfo userRegister(BankAccountRegisterCommand bankAccountRegisterCommand);
}
