package io.haedoang.apiserver.user.domain;

import io.haedoang.apiserver.security.ApplicationUserRole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * author : haedoang
 * date : 2022/02/26
 * description :
 */
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String profileUrl;

    @Enumerated(EnumType.STRING)
//    private Role role;
    private ApplicationUserRole role;

    private User(String email, String password, String profileUrl, ApplicationUserRole role) {
        this.email = email;
        this.password = password;
        this.profileUrl = profileUrl;
        this.role = Objects.isNull(role) ? ApplicationUserRole.BASIC : role;
    }

    public static User valueOf(String email, String password, String profileUrl, ApplicationUserRole role) {
        return new User(email, password, profileUrl, role);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public ApplicationUserRole getRole() {
        return role;
    }
}
