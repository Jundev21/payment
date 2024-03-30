package com.userPayment.adapter.in.web;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PutUserRegisterRequest {
    public Long userId;
    public String name;
    public String address;
    public String email;
    public boolean isIndividualCompany;
}
