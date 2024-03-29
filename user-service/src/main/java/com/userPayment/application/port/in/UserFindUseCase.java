package com.userPayment.application.port.in;

import com.userPayment.domain.UserInfo;

public interface UserFindUseCase {

    UserInfo findUser(UserFindCommand userFindCommand);
}
