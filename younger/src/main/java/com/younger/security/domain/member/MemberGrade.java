package com.younger.security.domain.member;

import lombok.Getter;

/**
 * create on 2022/02/20. create by IntelliJ IDEA.
 *
 * <p> 멤버 등급 </p>
 *
 * @author Yeonha Kim
 * @version 1.0
 */
public enum MemberGrade {
  GUEST("예비 죠랭이"),
  JOBLESS("취준 죠랭이"),
  WORKER("사원 죠랭이"),
  EXECUTIVE("임원 죠랭이");

  @Getter
  private final String name;

  MemberGrade (String name) {
    this.name = name;
  }

  public static MemberGrade getGradeByName(String name) {
    for (MemberGrade grade : MemberGrade.values()) {
      if (grade.getName().equals(name)) {
        return grade;
      }
    }

    throw new IllegalArgumentException(String.format("%s is wrong value for MemberGrade.", name));
  }
}
