package com.bankingPayment.adapter.in.web;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetBankAccountRegisterRequest {
    private String userRegisterId;
    private String bankName;
    private String bankAccountNumber;
    private boolean isValidAccountNumber;
}
