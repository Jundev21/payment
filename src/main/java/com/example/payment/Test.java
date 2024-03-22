package com.example.payment;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/test")
    void hello(){
        System.out.println("hello world");

    }
}
