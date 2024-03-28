package com.userPayment.application.port.out;

import com.userPayment.adapter.out.persistence.UserEntity;
import com.userPayment.domain.UserInfo;

public interface UserRegisterPort {

    UserEntity createUserInfo(
            UserInfo.UserName userName,
            UserInfo.UserEmail userEmail,
            UserInfo.UserAddress userAddress,
            UserInfo.UserIsValidUser userIsValidUser,
            UserInfo.UserIsIndividualCompany userIsIndividualCompany
    );


}
