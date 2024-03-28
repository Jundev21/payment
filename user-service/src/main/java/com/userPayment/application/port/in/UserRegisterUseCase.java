package com.userPayment.application.port.in;


import com.userPayment.domain.UserInfo;
import common.UserCase;

//@UserCase // 유즈케이스라는걸 의미부여하기위한 어노테이션
public interface UserRegisterUseCase {
    UserInfo userRegister(UserRegisterCommand userRegisterCommand);
}
