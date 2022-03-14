/*
 * Created by Yeonha Kim on 2022/02/20
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dev Backend Team <jongsang@bigin.io>, 2022/02/20
 */
package com.younger.security.service;

import com.younger.security.domain.auth.AuthRole;
import com.younger.security.domain.member.Member;
import com.younger.security.domain.member.MemberGrade;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * create on 2022/02/20. create by IntelliJ IDEA.
 *
 * <p> JWT 관련 비즈니스 로직을 처리합니다. </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 */
@Component
@Slf4j
public class TokenProvider {
  private final AuthService authService;
  private final Key key;
  private final String expiredTime;

  private static final String GRADE_CLAIM_KEY = "grade";

  public TokenProvider(
      AuthService authService,
      @Value("${application.jwt.secret}") String secret,
      @Value("${application.jwt.expired-time.access}") String expiredTime) {
    this.authService = authService;
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
    this.expiredTime = expiredTime;
  }

  /**
   * jwt를 발급한다.
   *
   * @param member claim에 담길 멤버 정보
   * @return jwt
   */
  public String generateToken(Member member) {
    Date now = new Date();
    Date tokenExpiresIn = new Date(now.getTime() + expiredTime);

    Map<String, Object> header = new HashMap<>();
    header.put(Header.TYPE, Header.JWT_TYPE);

    return Jwts.builder()
        .setHeader(header)
        .setSubject(member.getId().toString())
        .claim(GRADE_CLAIM_KEY, member.getGrade().toString())
        .setExpiration(tokenExpiresIn)
        .setIssuedAt(now)
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  /**
   * jwt를 검증한다.
   *
   * @param token jwt
   * @return 검증 결과
   */
  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      log.error(e.getMessage());
      return false;
    }
  }

  /**
   * jwt를 기반으로 인증 정보를 생성한다.
   *
   * @param token jwt
   * @return 인증 정보
   */
  public Authentication getAuthentication(String token) {
    Claims claims = parseClaims(token);

    if (isBlankClaims(claims)) {
      throw new RuntimeException("There is no authentication information.");
    }

    try {
      Long memberId = Long.parseLong(claims.getSubject());
      MemberGrade memberGrade = MemberGrade.valueOf((String) claims.get(GRADE_CLAIM_KEY));

      boolean isVerifiedMember = authService.verifyMember(memberId, memberGrade);

      if (isVerifiedMember) {
        AuthRole role = AuthRole.getRoleByGrade(memberGrade);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority memberAuth = new SimpleGrantedAuthority(role.getName());
        authorities.add(memberAuth);

        UserDetails principal = new User(memberId.toString(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
      }

      throw new RuntimeException("There is no authentication information.");
    } catch (Exception e) {
      throw new InsufficientAuthenticationException(e.getMessage());
    }
  }

  /**
   * jwt의 body를 파싱한다.
   *
   * @param token jwt
   * @return 토큰의 body claims
   */
  private Claims parseClaims(String token) {
    try {
      return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    } catch (ExpiredJwtException e) {
      return e.getClaims();
    }
  }

  /**
   * claim 정보가 비었는지 확인한다.
   *
   * @param claims {@link Claims}
   * @return claim 검증 결과
   */
  private boolean isBlankClaims(Claims claims) {
    return claims.getSubject() == null || claims.get(GRADE_CLAIM_KEY) == null;
  }
}
