package com.userPayment.application.service;


import com.payment.common.UserCase;
import com.userPayment.adapter.out.persistence.UserEntity;
import com.userPayment.adapter.out.persistence.UserMapper;
import com.userPayment.application.port.in.UserEditCommand;
import com.userPayment.application.port.in.UserEditUseCase;
import com.userPayment.application.port.out.UserEditPort;
import com.userPayment.domain.UserInfo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@UserCase
@AllArgsConstructor
public class UserEditService implements UserEditUseCase {

    private final UserEditPort userEditPort;
    private final UserMapper userMapper;

    @Override
    public UserInfo editUserInfo(UserEditCommand userEditCommand) {

        UserEntity entity =  userEditPort.editUserInfo(
                new UserInfo.UserId(userEditCommand.getUserId()),
                new UserInfo.UserName(userEditCommand.getName()),
                new UserInfo.UserAddress(userEditCommand.getAddress()),
                new UserInfo.UserEmail(userEditCommand.getEmail()),
                new UserInfo.UserIsValidUser(userEditCommand.isValidUser()),
                new UserInfo.UserIsIndividualCompany(userEditCommand.isIndividualCompany())
        );

        return userMapper.mapToUserEntity(entity);
    }
}
