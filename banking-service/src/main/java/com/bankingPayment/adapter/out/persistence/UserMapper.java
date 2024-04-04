package com.bankingPayment.adapter.out.persistence;

import com.userPayment.domain.UserInfo;
import org.springframework.stereotype.Component;



// bean 으로 사용 예정
@Component
public class UserMapper {

    public UserInfo mapToUserEntity(UserEntity userEntity){

        return UserInfo.generateUser(
                new UserInfo.UserId(userEntity.getUserId()),
                new UserInfo.UserName(userEntity.getName()),
                new UserInfo.UserEmail(userEntity.getEmail()),
                new UserInfo.UserAddress(userEntity.getAddress()),
                new UserInfo.UserIsValidUser(userEntity.isValidUser()),
                new UserInfo.UserIsIndividualCompany(userEntity.isIndividualCompany())
        );

    }
}
