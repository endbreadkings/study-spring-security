package com.younger.security.api.v1;

import com.younger.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create on 2022/02/20. create by IntelliJ IDEA.
 *
 * <p> 인증 관련 서비스 클래스 </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 */
@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthApi {
  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<String> login() {

    return new ResponseEntity<>("login", HttpStatus.OK);
  }

  @GetMapping("/logout")
  public ResponseEntity<String> logout() {

    return new ResponseEntity<>("logout", HttpStatus.OK);
  }

  @PostMapping("/token")
  public ResponseEntity<String> getToken() {

    return new ResponseEntity<>("getToken", HttpStatus.OK);
  }
}
