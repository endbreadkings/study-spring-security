package com.younger.security.config;

import com.younger.security.config.filter.JwtFilter;
import com.younger.security.domain.auth.AuthRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * create on 2022/02/20. create by IntelliJ IDEA.
 *
 * <p> 시큐리티 관련 설정 클래스 </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final String[] gradeBoardAuths = {
      AuthRole.JUNIOR.getName(),
      AuthRole.ADMIN.getName()
  };

  private final String[] freeBoardAuths = {
      AuthRole.JUNIOR.getName(),
      AuthRole.SENIOR.getName(),
      AuthRole.ADMIN.getName()
  };

  private final String[] galleryBoardAuths = {
      AuthRole.SENIOR.getName(),
      AuthRole.ADMIN.getName()
  };

  private final JwtFilter jwtFilter;


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()

        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

        .authorizeRequests()
        .antMatchers("/v1/auth/**").permitAll()
        .antMatchers("/v1/grade/**").hasAnyAuthority(gradeBoardAuths)
        .antMatchers("/v1/free/**").hasAnyAuthority(freeBoardAuths)
        .antMatchers("/v1/gallery/**").hasAnyAuthority(galleryBoardAuths);

//        .and()
//        .exceptionHandling()
//        .authenticationEntryPoint()
//        .accessDeniedHandler()
  }
}
