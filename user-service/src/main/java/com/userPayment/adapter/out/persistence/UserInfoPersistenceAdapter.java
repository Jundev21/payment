package com.userPayment.adapter.out.persistence;


import com.userPayment.application.port.out.UserFindPort;
import com.userPayment.application.port.out.UserRegisterPort;
import com.userPayment.domain.UserInfo;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserInfoPersistenceAdapter implements UserRegisterPort, UserFindPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
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
}
