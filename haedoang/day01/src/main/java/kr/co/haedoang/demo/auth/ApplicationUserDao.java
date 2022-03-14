package kr.co.haedoang.demo.auth;

import java.util.Optional;

/**
 * packageName : kr.co.haedoang.demo.auth
 * fileName : ApplicationUserDAO
 * author : haedoang
 * date : 2022-02-16
 * description :
 */
public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
