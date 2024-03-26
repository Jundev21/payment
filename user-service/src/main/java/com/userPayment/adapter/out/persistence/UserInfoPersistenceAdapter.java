package com.userPayment.adapter.out.persistence;


import com.userPayment.application.port.out.UserRegisterPort;
import com.userPayment.domain.UserInfo;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserInfoPersistenceAdapter implements UserRegisterPort {

    private final UserRepository userRepository;
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
}
