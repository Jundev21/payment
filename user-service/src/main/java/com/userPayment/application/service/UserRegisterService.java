package com.userPayment.application.service;

import com.userPayment.adapter.out.persistence.UserEntity;
import com.userPayment.adapter.out.persistence.UserInfoPersistenceAdapter;
import com.userPayment.adapter.out.persistence.UserMapper;
import com.userPayment.adapter.out.persistence.UserRepository;
import com.userPayment.application.port.in.UserRegisterCommand;
import com.userPayment.application.port.in.UserRegisterUseCase;
import com.userPayment.application.port.out.UserRegisterPort;
import com.userPayment.domain.UserInfo;
import common.UserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

// 흐름
// 받아온 command 객체를 entity 와 소통 후 결과값을 반환한다.
// 서비스는 디비랑 통신해야하는데 결국 디비도 외부통신이다.
// 핵사고날 아키텍처이기때문에 포트와 어뎁터를 통해야 코드가 나가야한다.
// 외부 통신은 포트이고 데이터를 보내는거기때문에 port out 에 작성해야함.
@UserCase
@RequiredArgsConstructor
public class UserRegisterService implements UserRegisterUseCase {

    private final UserRegisterPort userRegisterPort;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserInfo userRegister(UserRegisterCommand userRegisterCommand) {

        UserEntity userEntity = userRegisterPort.createUserInfo(
                new UserInfo.UserName(userRegisterCommand.getName()),
                new UserInfo.UserEmail(userRegisterCommand.getEmail()),
                new UserInfo.UserAddress(userRegisterCommand.getAddress()),
                new UserInfo.UserIsValidUser(userRegisterCommand.isValidUser()),
                new UserInfo.UserIsIndividualCompany(userRegisterCommand.isIndividualCompany())
        );

        return userMapper.mapToUserEntity(userEntity);
    }
}
