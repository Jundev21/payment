package com.userPayment.adapter.in.web;


import com.payment.common.WebAdapter;
import com.userPayment.adapter.out.persistence.UserInfoPersistenceAdapter;
import com.userPayment.application.port.in.UserFindCommand;
import com.userPayment.application.port.in.UserFindUseCase;
import com.userPayment.application.port.in.UserRegisterCommand;
import com.userPayment.application.port.in.UserRegisterUseCase;
import com.userPayment.application.port.out.UserFindPort;
import com.userPayment.application.service.UserFindService;
import com.userPayment.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//헥사고날 흐름
//request -> command -> usecase(request, command)

@WebAdapter // controller spring 일반적인 의미 이기때문에 핵사고날에서 알리기위하여 어노테이션을 ㅈ가성
@RestController
@RequiredArgsConstructor
public class GetUserRegisterController {

    private final UserFindUseCase userFindUseCase;

    @GetMapping("/user/{userId}")
    ResponseEntity<UserInfo> getMember(@PathVariable Long userId){
        UserFindCommand userFindCommand = UserFindCommand.builder()
                .userId(userId)
                .build();

        return ResponseEntity.ok(userFindUseCase.findUser(userFindCommand));
    }

}
