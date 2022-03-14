package com.younger.security.service;

import com.younger.security.domain.member.Member;
import com.younger.security.domain.member.MemberGrade;
import com.younger.security.repository.AuthorizationJpaRepository;
import com.younger.security.repository.MemberJpaRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
@Service
@RequiredArgsConstructor
public class AuthService {
  private final MemberJpaRepository memberRepository;
  private final AuthorizationJpaRepository authRepository;

  public boolean verifyMember(Long id, MemberGrade grade) {
    Optional<Member> member = memberRepository.findByIdAndGrade(id, grade.toString());
    return member.isPresent();
  }
}
