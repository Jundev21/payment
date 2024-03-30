package com.payment.common;


import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;


// usecase 는 기본적으로 서비스에서 사용되는 어노테이션 사용하는 케이스 라고 알리기 위한 어노테이션
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UserCase {
    @AliasFor(annotation = Component.class)
    String value() default "";
}
