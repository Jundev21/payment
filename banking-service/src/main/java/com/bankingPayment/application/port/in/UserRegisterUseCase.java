package com.bankingPayment.application.port.in;


import com.userPayment.domain.UserInfo;

//@UserCase // 유즈케이스라는걸 의미부여하기위한 어노테이션
public interface UserRegisterUseCase {
    UserInfo userRegister(UserRegisterCommand userRegisterCommand);
}
