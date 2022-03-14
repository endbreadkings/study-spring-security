package com.younger.security.config.filter;

import com.younger.security.service.TokenProvider;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * create on 2022/02/20. create by IntelliJ IDEA.
 *
 * <p> JWT 검증 관련 필터 구현체 </p>
 * <p> 토큰을 검증하고, 유저의 권한 정보를 셋팅합니다. </p>
 * <p> 클라이언트로 부터의 모든 요청 당 1번 씩 해당 로직이 수행됩니다. </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
  private final TokenProvider tokenProvider;

  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String BEARER_PREFIX = "Bearer ";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String token = resolveToken(request);

    if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
      Authentication authentication = tokenProvider.getAuthentication(token);
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }

  /**
   * Header에서 accessToken을 꺼낸다.
   *
   * @param request {@link HttpServletRequest}
   * @return accessToken
   */
  private String resolveToken(HttpServletRequest request) {
    String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
      return bearerToken.replace(BEARER_PREFIX, "");
    }

    return null;
  }
}
