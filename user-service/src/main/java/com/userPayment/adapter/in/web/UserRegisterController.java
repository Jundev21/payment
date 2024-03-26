package com.userPayment.adapter.in.web;


import com.userPayment.application.port.in.UserRegisterCommand;
import com.userPayment.application.port.in.UserRegisterUseCase;
import com.userPayment.domain.UserInfo;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//헥사고날 흐름
//request -> command -> usecase(request, command)

@WebAdapter // controller spring 일반적인 의미 이기때문에 핵사고날에서 알리기위하여 어노테이션을 ㅈ가성
@RestController
@RequiredArgsConstructor
public class UserRegisterController {
    private final UserRegisterUseCase userRegisterUseCase;
    @PostMapping("/user/register")
    UserInfo memberRegister(@RequestBody UserRegisterRequest userRegisterRequest){

        UserRegisterCommand userRegisterCommand = UserRegisterCommand.builder()
                .name(userRegisterRequest.getName())
                .address(userRegisterRequest.getAddress())
                .email(userRegisterRequest.getEmail())
                .isValidUser(true)
                .isIndividualCompany(true)
                .build();

        return userRegisterUseCase.userRegister(userRegisterCommand);
    }
}
