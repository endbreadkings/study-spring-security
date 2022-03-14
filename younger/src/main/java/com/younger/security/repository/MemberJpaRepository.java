/*
 * Created by Yeonha Kim on 2022/02/20
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dev Backend Team <jongsang@bigin.io>, 2022/02/20
 */
package com.younger.security.repository;

import com.younger.security.domain.member.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {

  @Query("select m from Member m where m.id = :id and m.grade = :grade")
  Optional<Member> findByIdAndGrade(@Param("id") Long id, @Param("grade") String grade);
}
