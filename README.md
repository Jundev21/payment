

핵사고날 파일 구조 시스템 - 모듈별로 분리하여 작성

````
 user-service
    ㄴ src.main
        ㄴ java
            ㄴ com.userPayment
                        ㄴ adapter
                        ㄴ application
                                ㄴ port
                                    ㄴ in
                                    ㄴ out
                                ㄴ service
                        ㄴ domain

````
세개 패키지로 나눠진다. \
adapter - 외부 시스템을 직접적인 연관이있어 컨트롤한다.\
application - 비즈니스로직이 들어간다. 하위 디렉터리로 service 와 port 가 있는데, service 는 실제 비즈니스 로직들을 처리하는 부분 구현체이고,  port 는 비즈니스로직에서 사용되는 app 통신들을 담당하는 인터페이스 이다. \
domain - 모델 정보를 저장하는 패키지.