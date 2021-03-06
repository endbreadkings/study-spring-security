# 스프링 시큐리티 스터디

---

당신은 죠르디의 열렬한 팬입니다.

귀여운 죠르디를 널리 알리기 위해 죠르디 팬클럽인 **< 죠.사.모 >** 을 만들기로 결심했죠.

그럼 어서 죠르디 팬클럽을 만들어 볼까요?!

## 요구사항
    
### 회원 등급

- 팬클럽은 회원제로 운영이 됩니다. 회원이 아니면 아무런 게시글도 읽을 수 없습니다.
- 회원 등급은 다음과 같습니다.
    1. `예비 죠랭이` - 게스트
    2. `취준생 죠랭이` - 준회원
    3. `사원 죠랭이` - 정회원
    4. `임원 죠랭이` - 관리자
    
### 구성 페이지

- 구성 페이지는 다음과 같고, 페이지별로 접근 가능한 등급이 있습니다.
    1. 로그인 / 회원가입 페이지 - `예비 죠랭이`
    2. 등업 신청 페이지 - `취준생 죠랭이`만
    3. 자유 게시판 페이지 - `취준생 죠랭이` 이상
    4. 죠르디 갤러리 페이지 - `사원 죠랭이` 이상
    5. 마이 페이지 - `취준생 죠랭이` 이상
    6. 관리자 페이지 - `임원 죠랭이`만

> `임원 죠랭이`는 모든 페이지에 들어갈 수 있습니다.


1. 등업 신청 페이지
   
    - 등업 신청은 `취준생 죠랭이`만 접근이 가능합니다.
    - 등업 신청 글은 한 번만 올릴 수 있습니다.
    - 임원 죠랭이의 승인 시, `사원 죠랭이`로 등급이 상향됩니다. 


2. 자유 게시판 페이지

    - 자유 게시판은 `취준생 죠랭이`부터 접근이 가능합니다.
    - 자유롭게 글을 쓰고 자신이 작성한 게시글에 한해 수정/삭제가 가능합니다.


3. 죠르디 갤러리 페이지

    - 죠르디 갤러리 페이지는 `사원 죠랭이`부터 접근이 가능합니다.
    - 귀여운 죠르디의 사진을 맘껏 올리세요! 자신이 올린 이미지에 한해 삭제가 가능합니다.


4. 마이 페이지

    - 마이 페이지는 가입한 회원인 `취준생 죠랭이` 이상 접근이 가능합니다.
    - 본인에 대한 정보 수정 및 회원 탈퇴가 가능합니다.

    
5. 관리자 페이지

    - 관리자 페이지는 `임원 죠랭이`만 접근이 가능합니다.
    - 회원 등업이 가능합니다.
    - 클린한 팬클럽을 위해 작성된 게시글을 삭제하고 회원을 추방시킬 수 있습니다.
    

## 사용 기술

- JDK 17
- Spring boot
- Spring Data JPA
- Spring Security
- Maria DB
- Junit Test