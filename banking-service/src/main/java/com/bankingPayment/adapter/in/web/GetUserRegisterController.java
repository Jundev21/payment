package com.bankingPayment.adapter.in.web;


import com.payment.common.WebAdapter;
import com.userPayment.application.port.in.UserFindCommand;
import com.userPayment.application.port.in.UserFindUseCase;
import com.userPayment.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


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
