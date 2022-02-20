package com.younger.security.domain.member;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * create on 2022/02/20. create by IntelliJ IDEA.
 *
 * <p> 회원 인증 정보 엔티티 </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Authorization {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String type;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String refreshToken;

  @OneToOne
  private Member owner;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Builder
  public Authorization(String type, String password, String refreshToken,
      Member owner) {
    this.type = type;
    this.password = password;
    this.refreshToken = refreshToken;
    this.owner = owner;
  }
}
