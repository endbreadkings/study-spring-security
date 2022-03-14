package io.haedoang.apiserver.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import static io.haedoang.apiserver.security.ApplicationUserRole.BASIC;

/**
 * author : haedoang
 * date : 2022/03/09
 * description :
 */
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserDetailsService applicationUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenFilter(), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/board/**").hasRole(BASIC.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        final UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("1234"))
//                .authorities(ADMIN.getGrantedAuthorities())
//                .build();
//
//        final UserDetails staff = User.builder()
//                .username("staff")
//                .password(passwordEncoder.encode("1234"))
//                .authorities(STAFF.getGrantedAuthorities())
//                .build();
//
//        final UserDetails premium = User.builder()
//                .username("premium")
//                .password(passwordEncoder.encode("1234"))
//                .authorities(PREMIUM.getGrantedAuthorities())
//                .build();
//
//        final UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder.encode("1234"))
//                .authorities(BASIC.getGrantedAuthorities())
//                .build();
//
//        return new InMemoryUserDetailsManager(
//                Arrays.asList(
//                        admin,
//                        staff,
//                        premium,
//                        user
//                )
//        );
//    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserDetailsService);
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
}
