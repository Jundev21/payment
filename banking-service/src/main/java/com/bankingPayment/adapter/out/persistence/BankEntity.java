package com.bankingPayment.adapter.out.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankEntity {

    @Id
    @GeneratedValue
    private Long bankId;
    private String memberId;
    private String bankName;
    private String bankAccountNumber;
    private Boolean accountStatus;

    public BankEntity(String memberId, String bankName, String bankAccountNumber, Boolean accountStatus) {
        this.memberId = memberId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.accountStatus = accountStatus;
    }

    public void EditUserEntity(String memberId, String bankName, String bankAccountNumber, Boolean accountStatus) {
        this.memberId = memberId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.accountStatus = accountStatus;
    }
}
