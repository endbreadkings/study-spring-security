package io.haedoang.apiserver.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static io.haedoang.apiserver.security.ApplicationUserPermission.*;

/**
 * author : haedoang
 * date : 2022/03/13
 * description :
 */
public enum ApplicationUserRole {
    BASIC(Sets.newHashSet(BOARD_READ)),
    PREMIUM(Sets.newHashSet(BOARD_READ, BOARD_WRITE)),
    STAFF(Sets.newHashSet(USER_READ, BOARD_READ, BOARD_WRITE)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, BOARD_READ, BOARD_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        final Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        
        return permissions;
    }

}
