package com.bankingPayment.application.service;

import com.bankingPayment.application.port.in.BankAccountRegisterCommand;
import com.bankingPayment.application.port.in.BankAccountRegisterUseCase;
import com.bankingPayment.domain.BankingInfo;
import com.payment.common.UserCase;

import lombok.RequiredArgsConstructor;

// 흐름
// 받아온 command 객체를 entity 와 소통 후 결과값을 반환한다.
// 서비스는 디비랑 통신해야하는데 결국 디비도 외부통신이다.
// 핵사고날 아키텍처이기때문에 포트와 어뎁터를 통해야 코드가 나가야한다.
// 외부 통신은 포트이고 데이터를 보내는거기때문에 port out 에 작성해야함.
@UserCase
@RequiredArgsConstructor
public class BankAccountRegisterService implements BankAccountRegisterUseCase {

    @Override
    public BankingInfo userRegister(BankAccountRegisterCommand bankAccountRegisterCommand) {
        return null;
    }
}
