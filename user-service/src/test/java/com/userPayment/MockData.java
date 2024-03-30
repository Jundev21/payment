package com.userPayment;

import com.userPayment.domain.UserInfo;

public class MockData {

    UserInfo newUser = UserInfo.generateUser(
            new UserInfo.UserId(1L),
            new UserInfo.UserName("new name"),
            new UserInfo.UserEmail("new address"),
            new UserInfo.UserAddress("new email"),
            new UserInfo.UserIsValidUser(true),
            new UserInfo.UserIsIndividualCompany(false)
    );
}
