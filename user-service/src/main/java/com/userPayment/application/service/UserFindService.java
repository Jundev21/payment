package com.userPayment.application.service;

import com.payment.common.UserCase;
import com.userPayment.application.port.in.UserFindCommand;
import com.userPayment.application.port.in.UserFindUseCase;
import com.userPayment.application.port.out.UserFindPort;
import com.userPayment.domain.UserInfo;

import lombok.RequiredArgsConstructor;

// 흐름
// 받아온 command 객체를 entity 와 소통 후 결과값을 반환한다.
// 서비스는 디비랑 통신해야하는데 결국 디비도 외부통신이다.
// 핵사고날 아키텍처이기때문에 포트와 어뎁터를 통해야 코드가 나가야한다.
// 외부 통신은 포트이고 데이터를 보내는거기때문에 port out 에 작성해야함.
@UserCase
@RequiredArgsConstructor
public class UserFindService implements UserFindUseCase {

    private final UserFindPort userFindPort;

    @Override
    public UserInfo findUser(UserFindCommand userFindCommand) {
        return userFindPort.findUserInfo(new UserInfo.UserId(userFindCommand.getUserId()));
    }
}
