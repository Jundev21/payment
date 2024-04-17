package com.bankingPayment.adapter.out.persistence;

import com.bankingPayment.application.port.out.BankAccountRegisterPort;
import com.bankingPayment.domain.BankingInfo;
import com.payment.common.PersistenceAdapter;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class BankAccountPersistenceAdapter implements BankAccountRegisterPort {

    private final BankRepository bankRepository;
    private final BankingMapper bankingMapper;

    @Override
    public BankEntity createUserInfo(BankingInfo.MemberId memberId, BankingInfo.BankName bankName,
        BankingInfo.BankAccountNumber bankAccountNumber, BankingInfo.AccountStatus accountStatus) {
        return null;
    }
}
