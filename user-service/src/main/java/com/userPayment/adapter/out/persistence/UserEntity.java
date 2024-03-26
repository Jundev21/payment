package com.userPayment.adapter.out.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;


@Entity
@Table(name = "Member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    private String address;
    private String email;
    private boolean isValidUser;
    private boolean isIndividualCompany;


    public UserEntity(String name, String address, String email, boolean isValidUser, boolean isIndividualCompany) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValidUser = isValidUser;
        this.isIndividualCompany = isIndividualCompany;
    }
}
