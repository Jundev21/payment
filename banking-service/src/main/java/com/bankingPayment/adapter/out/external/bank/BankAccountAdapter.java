package com.bankingPayment.adapter.out.external.bank;

import org.springframework.stereotype.Component;

import com.bankingPayment.adapter.out.persistence.BankEntity;
import com.bankingPayment.adapter.out.persistence.BankRepository;
import com.bankingPayment.application.port.out.BankAccountRegisterPort;
import com.bankingPayment.application.port.out.ExternalBankAccountInfoPort;
import com.bankingPayment.domain.BankingInfo;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BankAccountAdapter implements ExternalBankAccountInfoPort {

	private BankRepository bankRepository;

	@Override
	public BankAccount getBankAccountInfo(GetBankAccountRequest getBankAccountRequest) {
//		실제 외부 은행 서비스 통신 영역
		return new BankAccount(getBankAccountRequest.getBankName(), getBankAccountRequest.getBankAccountNumber(),true);
	}
}
