package com.younger.security.domain.board;

import com.younger.security.domain.member.Member;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * create on 2022/02/20. create by IntelliJ IDEA.
 *
 * <p> 자유 게시판 댓글 엔티티 </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FreeBoardComment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String comment;

  @Column(nullable = false)
  private Long likes;

  @ManyToOne
  private Member writer;

  @ManyToOne
  private FreeBoard board;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Builder
  public FreeBoardComment(String comment, Long likes,
      Member writer, FreeBoard board) {
    this.comment = comment;
    this.likes = likes;
    this.writer = writer;
    this.board = board;
  }
}
