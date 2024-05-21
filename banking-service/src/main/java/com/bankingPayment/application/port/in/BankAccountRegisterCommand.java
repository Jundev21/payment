package com.bankingPayment.application.port.in;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class BankAccountRegisterCommand {

    @NotNull
    private String name;
    @NotNull
    @NotBlank
    private String address;
    @NotNull
    private String email;
    @AssertTrue
    private boolean isValidUser;
    private boolean isIndividualCompany;



    public BankAccountRegisterCommand(String name, String address, String email, boolean isValidUser, boolean isIndividualCompany) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValidUser = isValidUser;
        this.isIndividualCompany = isIndividualCompany;

//        this.validateSelf();
    }
}
