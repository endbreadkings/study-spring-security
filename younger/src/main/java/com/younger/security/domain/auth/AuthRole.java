/*
 * Created by Yeonha Kim on 2022/02/20
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dev Backend Team <jongsang@bigin.io>, 2022/02/20
 */
package com.younger.security.domain.auth;

import com.younger.security.domain.member.MemberGrade;
import lombok.Getter;

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
public enum AuthRole {
  GUEST("ROLE_GUEST", null),
  JUNIOR("ROLE_JUNIOR", MemberGrade.JOBLESS),
  SENIOR("ROLE_SENIOR", MemberGrade.WORKER),
  ADMIN("ROLE_ADMIN", MemberGrade.EXECUTIVE);

  @Getter
  private final String name;

  @Getter
  private final MemberGrade grade;

  AuthRole(String name, MemberGrade grade) {
    this.name = name;
    this.grade = grade;
  }

  public static AuthRole getRoleByGrade(MemberGrade grade) {
    for (AuthRole role : AuthRole.values()) {
      if (role.getGrade() == grade) {
        return role;
      }
    }

    throw new IllegalArgumentException(String.format("%s is wrong value for AuthRole.", grade));
  }
}
