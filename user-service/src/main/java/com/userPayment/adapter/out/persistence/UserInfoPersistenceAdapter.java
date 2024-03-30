package com.userPayment.adapter.out.persistence;


import com.payment.common.PersistenceAdapter;
import com.userPayment.application.port.out.UserEditPort;
import com.userPayment.application.port.out.UserFindPort;
import com.userPayment.application.port.out.UserRegisterPort;
import com.userPayment.domain.UserInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserInfoPersistenceAdapter implements UserRegisterPort, UserFindPort, UserEditPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public UserEntity createUserInfo(
            UserInfo.UserName userName,
            UserInfo.UserEmail userEmail,
            UserInfo.UserAddress userAddress,
            UserInfo.UserIsValidUser userIsValidUser,
            UserInfo.UserIsIndividualCompany userIsIndividualCompany
    ){
        UserEntity newUser = new UserEntity(
                userName.getName(),
                userEmail.getEmail(),
                userAddress.getAddress(),
                userIsValidUser.isValidUser(),
                userIsIndividualCompany.isIndividualCompany()
        );
        return userRepository.save(newUser);
    }

    @Override
    public UserInfo findUserInfo(UserInfo.UserId userId) {
        UserEntity findUserEntity = userRepository.findById(userId.getUserId()).orElseThrow(()-> new RuntimeException("can't find member"));
        return userMapper.mapToUserEntity(findUserEntity);
    }

    @Transactional
    @Override
    public UserEntity editUserInfo(
            UserInfo.UserId userId,
            UserInfo.UserName userName,
            UserInfo.UserAddress userAddress,
            UserInfo.UserEmail userEmail,
            UserInfo.UserIsValidUser userIsValidUser,
            UserInfo.UserIsIndividualCompany userIsIndividualCompany
    ){

        UserEntity findUserEntity = userRepository.findById(userId.getUserId()).orElseThrow(()-> new RuntimeException("can't find member"));

        findUserEntity.EditUserEntity(
                userName.getName(),
                userAddress.getAddress(),
                userEmail.getEmail(),
                userIsValidUser.isValidUser(),
                userIsIndividualCompany.isIndividualCompany()

        );

        return findUserEntity;
    }
}
