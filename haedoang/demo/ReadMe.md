
### demo application
- [영상_북마크](https://youtu.be/her_7pa0vrg?t=6675)


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

[참고 링크](https://youtu.be/her_7pa0vrg?t=7410)
