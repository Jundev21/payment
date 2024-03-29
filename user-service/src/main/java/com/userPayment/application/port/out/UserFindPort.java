package com.userPayment.application.port.out;

import com.userPayment.adapter.out.persistence.UserEntity;
import com.userPayment.domain.UserInfo;

public interface UserFindPort {
    UserInfo findUserInfo(UserInfo.UserId userId);
}
