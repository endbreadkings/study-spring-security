package kr.co.haedoang.demo.security;

/**
 * packageName : kr.co.haedoang.demo.security
 * fileName : ApplicationUserPermission
 * author : haedoang
 * date : 2022-02-07
 * description :
 */
public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
