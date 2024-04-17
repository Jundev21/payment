package com.bankingPayment.application.port.in;

import com.bankingPayment.domain.BankingInfo;

public interface BankAccountFindUseCase {

    BankingInfo findUser(BankAccountFindCommand bankAccountFindCommand);
}
