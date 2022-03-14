package io.haedoang.apiserver.api.user.ui;

import io.haedoang.apiserver.user.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static io.haedoang.apiserver.security.ApplicationUserRole.*;

/**
 * author : haedoang
 * date : 2022/03/10
 * description :
 */
@RestController
@RequestMapping("management/${api.appVer}/users")
public class UserManagementRestController {
    private final AtomicLong count = new AtomicLong();

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_STAFF')")
    public ResponseEntity<List<User>> users() {
        final List<User> users = Arrays.asList(
                User.valueOf("haedoang@xmail.com", "1234", null, ADMIN),
                User.valueOf("dualipa@xmail.com", "1234", null, STAFF),
                User.valueOf("ariana@xmail.com", "1234", null, PREMIUM),
                User.valueOf("weekend@xmail.com", "1234", null, BASIC)
        );
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.created(URI.create("/users/" + count.incrementAndGet())).body(user);
    }
}