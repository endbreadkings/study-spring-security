package io.haedoang.apiserver.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author : haedoang
 * date : 2022/02/26
 * description :
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
