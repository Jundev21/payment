package com.userPayment.adapter.in.web;


import lombok.*;



@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostUserRegisterRequest {
    private String name;
    private String address;
    private String email;
    private boolean isIndividualCompany;
}
