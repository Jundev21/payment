package com.bankingPayment.application.port.out;

import com.bankingPayment.adapter.out.persistence.BankEntity;
import com.bankingPayment.domain.BankingInfo;

public interface BankAccountRegisterPort {

    BankEntity createUserInfo(
        BankingInfo.MemberId memberId,
        BankingInfo.BankName bankName,
        BankingInfo.BankAccountNumber bankAccountNumber,
        BankingInfo.AccountStatus accountStatus
    );
}
