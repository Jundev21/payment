package com.bankingPayment.application.service;

import org.springframework.stereotype.Service;

import com.bankingPayment.adapter.out.external.bank.BankAccount;
import com.bankingPayment.adapter.out.external.bank.GetBankAccountRequest;
import com.bankingPayment.adapter.out.persistence.BankEntity;
import com.bankingPayment.adapter.out.persistence.BankingMapper;
import com.bankingPayment.application.port.in.BankAccountRegisterCommand;
import com.bankingPayment.application.port.in.BankAccountRegisterUseCase;
import com.bankingPayment.application.port.in.NewBankAccountRegisterCommand;
import com.bankingPayment.application.port.out.BankAccountRegisterPort;
import com.bankingPayment.application.port.out.ExternalBankAccountInfoPort;
import com.bankingPayment.domain.BankingInfo;
import com.payment.common.UserCase;

import lombok.RequiredArgsConstructor;

// 흐름
// 받아온 command 객체를 entity 와 소통 후 결과값을 반환한다.
// 서비스는 디비랑 통신해야하는데 결국 디비도 외부통신이다.
// 핵사고날 아키텍처이기때문에 포트와 어뎁터를 통해야 코드가 나가야한다.
// 외부 통신은 포트이고 데이터를 보내는거기때문에 port out 에 작성해야함.
@UserCase
@Service
@RequiredArgsConstructor
public class BankAccountRegisterService implements BankAccountRegisterUseCase {

    public final ExternalBankAccountInfoPort externalBankAccountInfoPort;
    public final BankAccountRegisterPort bankAccountRegisterPort;
    public final BankingMapper bankingMapper;

    @Override
    public BankingInfo userRegister(NewBankAccountRegisterCommand newBankAccountRegisterCommand) {

        // 은행계좌를 등록해야하는 영역이다. 비즈니스 처리를 해야함.
        // 1. 은행계좌가 있는지 먼저 확인한다. (외부 은행계좌로 부터 확인)
        // 2. 계좌 확인 여부
        //      1. 확인이 되었을경우에는 회원 등록이 된다.
        //      2. 확인이 안되는 계좌일 경우 에러를 표시한다.

        // 외부 계좌를 먼저 확인하고 확인 결과에 따른 처리를 여기 다음에 처리한다.
        // 파라미터는 사용자의 이름과 계좌 번화를 전송하여 확인한다.
        BankAccount bankAccount = externalBankAccountInfoPort.getBankAccountInfo(
            new GetBankAccountRequest(
                newBankAccountRegisterCommand.getBankName(),
                newBankAccountRegisterCommand.getBankAccountNumber()
            )
        );
        boolean accountIsValid = bankAccount.isValidBankAccount();

        // 만약 등록이 가능한 계좌면 등록에 은행계좌 정보를 리턴한다.
        // 아닐 경우에는 에러를 리턴한다.
        if(accountIsValid){
          BankEntity newBankEntity = bankAccountRegisterPort.createUserInfo(
                new BankingInfo.MemberId(newBankAccountRegisterCommand.getMemberShipId()),
                new BankingInfo.BankName(newBankAccountRegisterCommand.getBankName()),
                new BankingInfo.BankAccountNumber(newBankAccountRegisterCommand.getBankAccountNumber()),
                new BankingInfo.AccountStatus(newBankAccountRegisterCommand.isAccountStatus())
            );
            return bankingMapper.mapToBankingInfoEntity(newBankEntity);
        }else{

            // 임시적인 에러 응답 반환한다.
            return null;
        }
    }
}
