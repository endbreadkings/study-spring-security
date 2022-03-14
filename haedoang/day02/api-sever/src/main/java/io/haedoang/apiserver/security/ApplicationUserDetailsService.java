package io.haedoang.apiserver.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static io.haedoang.apiserver.security.ApplicationUserRole.*;

/**
 * packageName : io.haedoang.apiserver.security
 * fileName : ApplicationUserDetailsService
 * author : haedoang
 * date : 2022-03-14
 * description :
 */
@Service
@RequiredArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return fakeUserList().stream().filter(it -> it.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("username:" + username));
    }

    private List<UserDetails> fakeUserList() {
        final UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("1234"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        final UserDetails staff = User.builder()
                .username("staff")
                .password(passwordEncoder.encode("1234"))
                .authorities(STAFF.getGrantedAuthorities())
                .build();

        final UserDetails premium = User.builder()
                .username("premium")
                .password(passwordEncoder.encode("1234"))
                .authorities(PREMIUM.getGrantedAuthorities())
                .build();

        final UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("1234"))
                .authorities(BASIC.getGrantedAuthorities())
                .build();

        return Arrays.asList(
                admin, staff, user, premium
        );
    }
}


