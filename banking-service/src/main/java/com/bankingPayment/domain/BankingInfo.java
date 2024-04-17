package com.bankingPayment.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;


// getter setter data 어노테셔 사용.
// 정보 클래스는 절대 바뀌면 안됨으로 접근제어자를 걸어둔다.
// 핵심 도메인이기 때문에 절대적으로 안전하게해야한다.
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BankingInfo {
    @Getter private final Long bankId;
    @Getter private final String memberId;
    @Getter private final String bankName;
    @Getter private final String bankAccountNumber;
    @Getter private final Boolean accountStatus;

    public static BankingInfo generateUser(
            BankingId bankingId,
            MemberId memberId,
            BankName bankName,
            BankAccountNumber bankAccountNumber,
            AccountStatus accountStatus

    ){
        return new BankingInfo(
            bankingId.bankingId,
            memberId.memberId,
            bankName.bankName,
            bankAccountNumber.bankAccount,
            accountStatus.accountStatus

        );
    }

    @Value
    public static class BankingId{
        Long bankingId;
        public BankingId(Long value){
            this.bankingId = value;
        }
    }

    @Value
    public static class MemberId{
        String memberId;
        public MemberId(String value){
            this.memberId = value;
        }
    }

    @Value
    public static class BankName{
        String bankName;
        public BankName(String value){
            this.bankName = value;
        }
    }

    @Value
    public static class BankAccountNumber{
        String bankAccount;
        public BankAccountNumber(String value){
            this.bankAccount = value;
        }
    }

    @Value
    public static class AccountStatus{
        Boolean accountStatus;
        public AccountStatus(Boolean value){
            this.accountStatus = value;
        }
    }

}
