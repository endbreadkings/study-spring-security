## Spring Security 알기 

### Spring Security 란?
 - Spring Security 란 강력하고 고도로 사용자 지정 가능한 인증 및 액세스 제어 프레임워크. 
 - Spring 기반 애플리케이션을 보호하기 위한 표준.
 - Java 애플리케이션에 인증과 권한 부여를 모두 제공하는데 중점을 둠
 - 사용자 지정 요구 사항을 쉽게 확장할 수 있다.

### 기능 
 - 포괄적이고 확장 가능한 인증 및 권한 기능을 지원한다.
 - `session fixation` `clickjacking`, `cross site request forgery` 등을 보호
    <details>
        <summary>
            내용 설명
        </summary>
        <p>session fixation: attacker가 서버로부터 받은 session을 user에게 넘겨주어 해당 session을 공유하는 공격 방식</p>
           <p>clickjacking: 감춰진 링크를 사용자가 클릭함으로써 의도하지 않은 행동을 수행하도록 함 ex) 라이크재킹</p>
        <p>CSRF/XSRF: 사용자가 자신의 의조아 무관하게 공격자가 의도한 웹 사이트의 요청을 수행하게하는 공격 방식</p>
    </details>
 - 서블릿 API 통합
 - Spring Web MVC와 선택적 통합 


### 종류
 - Spring Security Kerberos : 비밀키 암호화를 사용한 인증 방식
 - Spring Security OAuth : OAuth2.0인증 프레임워크를 통한 인증 방식 
 - Spring Security SAML(Security Assertion Markup Language): XML 기반의 인증 방식
