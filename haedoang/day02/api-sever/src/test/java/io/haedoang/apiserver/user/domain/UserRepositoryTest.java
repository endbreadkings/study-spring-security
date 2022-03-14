package io.haedoang.apiserver.user.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author : haedoangㅐ
 * date : 2022/02/26
 * description :
 */
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자 생성 테스트")
    public void userCreate() {
        // given
        final User user = User.valueOf("haedoang@gmail.com", "1234", null, null);

        // when
        final User savedUser = userRepository.save(user);

        // then
        assertThat(savedUser.getId()).isNotNull();
    }
}