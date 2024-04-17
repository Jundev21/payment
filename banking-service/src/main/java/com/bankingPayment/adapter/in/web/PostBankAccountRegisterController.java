package com.bankingPayment.adapter.in.web;

import org.springframework.web.bind.annotation.RestController;

import com.payment.common.WebAdapter;

import lombok.RequiredArgsConstructor;


//헥사고날 흐름
//request -> command -> usecase(request, command)

@WebAdapter // controller spring 일반적인 의미 이기때문에 핵사고날에서 알리기위하여 어노테이션을 ㅈ가성
@RestController
@RequiredArgsConstructor
public class PostBankAccountRegisterController {


}
