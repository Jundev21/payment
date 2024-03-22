package com.userPayment.adapter.in.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//adapter 은 외부와의 직접적인 상호작용을한다.
//http 요청 이 외부와의 상호작용이다.
@RestController
public class Test {

    @GetMapping("/test")
    void hello(){
        System.out.println("hello world");

    }
}
