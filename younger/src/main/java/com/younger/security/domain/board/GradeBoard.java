package com.younger.security.domain.board;

import com.younger.security.domain.member.Member;
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
 * <p> 등업 게시판 엔티티 </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GradeBoard {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @OneToOne
  private Member writer;

  @Column(nullable = false)
  private boolean isUpgrade;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Builder
  public GradeBoard(Member writer, boolean isUpgrade) {
    this.writer = writer;
    this.isUpgrade = isUpgrade;
  }
}
