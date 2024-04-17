package com.bankingPayment.application.port.in;

import com.bankingPayment.domain.BankingInfo;

public interface BankAccountEditUseCase {

    BankingInfo editUserInfo(BankAccountEditCommand userEditCommand);

}
