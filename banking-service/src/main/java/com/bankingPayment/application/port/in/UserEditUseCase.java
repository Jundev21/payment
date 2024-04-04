package com.bankingPayment.application.port.in;

import com.userPayment.domain.UserInfo;

public interface UserEditUseCase {

    UserInfo editUserInfo(UserEditCommand userEditCommand);

}
