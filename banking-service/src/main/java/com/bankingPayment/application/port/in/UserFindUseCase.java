package com.bankingPayment.application.port.in;

import com.userPayment.domain.UserInfo;

public interface UserFindUseCase {

    UserInfo findUser(UserFindCommand userFindCommand);
}
