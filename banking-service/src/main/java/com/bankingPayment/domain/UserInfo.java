package com.bankingPayment.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;



// mvp version
// 최소한의 기능을 갖고있는 서비스
// 최소한의 서비스 => 페이에 등록한 회원들의 정보들을 갖고있고, 새로운 멤버 추가가 가능하고 멤버 조회가 가능한 서비스

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfo {
    @Getter private final Long userId;
    @Getter private final String name;
    @Getter private final String email;
    @Getter private final String address;
    @Getter private final boolean isValidUser;
    @Getter private final boolean isIndividualCompany;

    // memer 정의
    // getter setter data 어노테셔 사용.
    // 고객 정보의 클래스는 절대 바뀌면 안됨으로 접근제어자를 걸어둔다.
    // 핵심 도메인이기 때문에 절대적으로 안전하게해야한다.


    public static UserInfo generateUser(
            UserId userId,
            UserName userName,
            UserEmail userEmail,
            UserAddress userAddress,
            UserIsValidUser userIsValidUser,
            UserIsIndividualCompany userIsIndividualCompany){

        return new UserInfo(
                userId.userId,
                userName.name,
                userEmail.email,
                userAddress.address,
                userIsValidUser.isValidUser,
                userIsIndividualCompany.isIndividualCompany
        );
    }

    @Value
    public static class UserId{
        Long userId;
        public UserId(Long value){
            this.userId = value;
        }
    }

    @Value
    public static class UserName{
        String name;
        public UserName(String value){
            this.name = value;
        }
    }

    @Value
    public static class UserEmail{
        String email;
        public UserEmail(String value){
            this.email = value;
        }
    }

    @Value
    public static class UserAddress{
        String address;
        public UserAddress(String value){
            this.address = value;
        }
    }

    @Value
    public static class UserIsValidUser{
        boolean isValidUser;
        public UserIsValidUser(boolean value){
            this.isValidUser = value;
        }
    }

    @Value
    public static class UserIsIndividualCompany{
        boolean isIndividualCompany;
        public UserIsIndividualCompany(boolean value){
            this.isIndividualCompany = value;
        }
    }


}
