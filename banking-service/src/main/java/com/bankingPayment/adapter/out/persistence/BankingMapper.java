package com.bankingPayment.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.bankingPayment.domain.BankingInfo;



// bean 으로 사용 예정
@Component
public class BankingMapper {

    public BankingInfo mapToBankingInfoEntity(BankEntity bankEntity) {

        return BankingInfo.generateUser(
            new BankingInfo.BankingId(bankEntity.getBankId()),
            new BankingInfo.MemberId(bankEntity.getMemberId()),
            new BankingInfo.BankName(bankEntity.getBankName()),
            new BankingInfo.BankAccountNumber(bankEntity.getBankAccountNumber()),
            new BankingInfo.AccountStatus(bankEntity.getAccountStatus())
        );

    }
}