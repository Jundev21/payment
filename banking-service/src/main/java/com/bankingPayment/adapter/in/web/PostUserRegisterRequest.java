package com.bankingPayment.adapter.in.web;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostUserRegisterRequest {
    private String name;
    private String address;
    private String email;
    private boolean isIndividualCompany;
}
