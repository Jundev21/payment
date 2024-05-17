package com.bankingPayment.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BankAccount {
//실제 데이터 은행 조회시 받아오는 은행 정보

private String bankName;
private String bankAccountNumber;
private boolean isValidBankAccount;

}
