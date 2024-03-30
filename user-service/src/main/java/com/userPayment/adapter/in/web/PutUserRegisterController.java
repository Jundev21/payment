package com.userPayment.adapter.in.web;


import com.userPayment.application.port.in.UserEditCommand;
import com.userPayment.application.port.in.UserEditUseCase;
import com.userPayment.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PutUserRegisterController {

    private final UserEditUseCase userEditUseCase;
    @PutMapping("/user/modify/{userId}")
    public ResponseEntity<UserInfo> editUserInfo(
            @RequestBody PutUserRegisterRequest request
    ){
        UserEditCommand userEditCommand = UserEditCommand.builder()
                .userId(request.getUserId())
                .name(request.getName())
                .email(request.getEmail())
                .isValidUser(true)
                .isIndividualCompany(request.isIndividualCompany())
                .build();

        return ResponseEntity.ok(userEditUseCase.editUserInfo(userEditCommand));
    }
}
