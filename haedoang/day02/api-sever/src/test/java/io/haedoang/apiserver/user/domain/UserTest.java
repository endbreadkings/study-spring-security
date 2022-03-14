package io.haedoang.apiserver.user.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author : haedoang
 * date : 2022/02/26
 * description :
 */
class UserTest {

    @Test
    @DisplayName("사용자 도메인 생성")
    public void userCreate() {
        // given
        final User user = User.valueOf("haedoang@gmail.com", "1234", null, null);

        // then
        assertThat(user.checkPassword("1234")).isTrue();
    }
}