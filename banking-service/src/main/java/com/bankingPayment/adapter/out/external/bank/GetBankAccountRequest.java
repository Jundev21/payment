package com.bankingPayment.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class GetBankAccountRequest {
	private String bankName;
	private String bankAccountNumber;
}
