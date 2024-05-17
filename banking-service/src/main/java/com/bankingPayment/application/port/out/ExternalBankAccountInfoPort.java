package com.bankingPayment.application.port.out;

import com.bankingPayment.adapter.out.external.bank.BankAccount;
import com.bankingPayment.adapter.out.external.bank.GetBankAccountRequest;

public interface ExternalBankAccountInfoPort {
	BankAccount getBankAccountInfo(GetBankAccountRequest getBankAccountRequest);
}
