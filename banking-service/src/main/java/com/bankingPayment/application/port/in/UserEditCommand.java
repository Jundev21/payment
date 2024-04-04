package com.bankingPayment.application.port.in;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


//command 는 request 데이터들을 한번 거쳐서 변형되는 단계
//여기서 유효성 검사

@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserEditCommand{

    @NotNull
    private Long userId;
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

    public UserEditCommand(Long userId, String address, String email, boolean isValidUser, boolean isIndividualCompany) {
        this.userId = userId;
        this.address = address;
        this.email = email;
        this.isValidUser = isValidUser;
        this.isIndividualCompany = isIndividualCompany;
    }
}
