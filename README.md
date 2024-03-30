
# MSA- 헥사고날 아키텍처를 사용하여 payment 만들어보는 프로젝트


### 핵사고날 파일 구조 시스템 - 모듈별로 분리하여 작성

````
 user-service
    ㄴ src.main
        ㄴ java
            ㄴ com.userMember
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

---

### 페이 시스템 서비스 흐름

페이 플랫폼, 사용자 계좌, 페이 법인 계좌

1. 사용자가 페이 플랫폼을 통하여 5만원을 타인 또는 타 은행으로 송금을 하고자한다. 
2. 사용자에게 계좌등록 여부를 확인하고 송금 금액이 맞는지 확인한다.  
3. 계좌가 등록 되어있고 송금 금액이 충분한 경우 페이 법인 계좌가 사용자 계좌로부터 5만원을 송금받는다.
4. 사용자 -> 법인계좌 송금이 성공하면 페이 플랫폼 데이터 금액 5만원이 충전이된다.

(카카오 또는 네이버 페이에서 일정금액(1만원) 이상 충전이 되어야하는이유 
=== 페이를 충전한다는 것은 개인 계좌인데, 타은행에서 페이 법인 계좌로 송금하는 것이다. 즉 돈이 외부로부터 전달되기 때문에 수수료가 붙게되는데
수수료를 감안해도 수익이 되는 최소금액이 1만원이기때문이라고한다. )

---

### 모듈화

1. 회원들을 관리하는 회원 모듈
2. 돈을 관리하는 money 모듈
3. 가맹점들을 관리하는 가맹점 모듈
4. 결재를 관리하는 결재 모듈
5. 은행과 직접적인 연관이 있는 은행관리 모듈

[//]: # (   서비스 별로 각 DB를 갖게된다. 비즈니스 점유율이 노ㅠ으면 단독적으로 불리할 수 있다.)


비즈니스 -  해결해야할 문제들의 모음
도메인 - 비즈니스에서 나온 문제들의 핵심과 규칙으로 표현하는 것
도메인 모델 - 이런 객체들 간의 관계들을 표현하는 것


---



