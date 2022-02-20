package com.younger.security.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.younger.security.domain.member.Member;
import com.younger.security.domain.member.MemberGrade;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

/**
 * create on 2022/02/20. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
@Sql(scripts = {"classpath:init/member-insert.sql"})
class MemberJpaRepositoryTest extends RepositoryTest{
  @Autowired
  MemberJpaRepository memberJpaRepository;

  @Test
  @DisplayName("멤버 전체 조회 성공 테스트")
  void findAllTest() {
    List<Member> allMembers = memberJpaRepository.findAll();

    assertThat(allMembers.size()).isEqualTo(3);
  }

  @Test
  @DisplayName("ID로 멤버 조회 성공 테스트")
  void findByIdTest() {
    Long id = 1L;

    Optional<Member> optionalMember = memberJpaRepository.findById(id);

    assertThat(optionalMember).isPresent();
  }

  @Test
  @DisplayName("멤버 생성 테스트")
  void saveTest() {
    Member member = Member.builder()
        .email("test4@jordy.com")
        .grade(MemberGrade.JOBLESS)
        .nickname("신규죠랭이")
        .build();

    Member savedMember = memberJpaRepository.save(member);

    assertThat(savedMember).isEqualTo(member);
  }
}