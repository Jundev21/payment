package com.userPayment.application.port.out;

import com.userPayment.adapter.out.persistence.UserEntity;
import com.userPayment.domain.UserInfo;

public interface UserEditPort {

    UserEntity editUserInfo(
            UserInfo.UserId username,
            UserInfo.UserName userName,
            UserInfo.UserAddress userAddress,
            UserInfo.UserEmail userEmail,
            UserInfo.UserIsValidUser userIsValidUser,
            UserInfo.UserIsIndividualCompany userIsIndividualCompany
    );
}
