package com.bankingPayment.application.port.out;

import com.userPayment.domain.UserInfo;

public interface UserFindPort {
    UserInfo findUserInfo(UserInfo.UserId userId);
}
