## Spring Security Tutorial
- TODO: 내용 정리하기

### Cross Site Request Forgery (CSRF) 
- spring-security는 기본적으로 csrf 공격을 제한하고 있다.
- 브라우저상에서 발생하는 공격 방식이므로 브라우저 리턴이 아닌 경우 disable() 하도록 한다

### CSRF TOKEN 동작 방식
```text
Server  <----------------  Client
         (login request)

        ---------------->
          (CSRF Token)

        <---------------- 
        (put, post, delete)
           (with token) 
```

### Basic Auth
 - Authorization: BASIC ASDZXCJKASNCKFASDASWQEQW==
 - HTTPS 
 - 쉽고 빠르다
 - 로그아웃할 수 없다
```text
Server  <----------------  Client
         (GET Request)

        ---------------->
        (401 Unauthrized)

        <---------------- 
          (Get Request)
    (Base64 username:password)
    
        ---------------->
            (200 OK ) 
```

### Form Based Auth
- Username & Password
- 대부분의 웹 사이트들 표준
- Forms(Full Control)
- 로그아웃 가능
- HTTPS

```text
Server  <---------------------  Client
        (POST username password)
      
(자격증명 검증)

        --------------------->
                (OK)
              
        --------------------->
          (Cookie SESSIONID)

        <---------------------&& 
    (모든 요청에 SESSIONID를 포함하여 보낸다)
    
(SESSIONID 검증)
        --------------------->
               (200 OK ) 
```
- SESSIONID Storage (default 30min)
  - In-Memory Database  
  - Postgres
  - Redis

- remember-me Cookie(default 2week)
  - username
  - expiration time
  - md5 hash of the above 2 values 

- logoutUrl - by.docs
  - csrf 활성화인 경우 POST 요청을 해야 한다.
  - csrf가 비활성화인 경우 모둔 REQUEST를 허용한다
  - CSRF 공격으로 보호하기 위해서는 HTTP POST를 권장한다
  - HTTP Get을 사용하려면 `logoutRequestMatcher(새 AntPathRequestMatcher)(logoutUrl, "GET")` 를 사용하자


## JSON WEB TOKEN
 [jwt.io](https://jwt.io/)

 - 장점 
   + fast
   + stateless
   + 범용적으로 사용가능
 - 단점
   - Compromised Secret Key(손상된 키) 
   - 로그인 유저를 알 수 없음
   - 토큰 유출 가능
```text
Server  <---------------------  Client
          (Sends credentials)
      
(자격증명 검증 & 토큰 서명)

        --------------------->
            (sends token)


        <---------------------&& 
    (모든 요청에 token 을 포함하여 보낸다)
    
(token 검증)
        --------------------->
              (200 OK)
```

#### Request Filters
```text
  request -----------> filter1 ----------------------> filter2 -> ........ -> api
                          ↓                               ↓
     (JwtUsernameAndPasswordAuthenticationFilter) (JwtTokenVerifier)
```



- 출처 : [amigoescode - spring security full course](https://www.youtube.com/watch?v=her_7pa0vrg)
