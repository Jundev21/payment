package com.bankingPayment.application.port.out;

import com.bankingPayment.domain.BankingInfo;

public interface BankAccountFindPort {
    BankingInfo findUserInfo(BankingInfo.BankingId bankingId);
}
