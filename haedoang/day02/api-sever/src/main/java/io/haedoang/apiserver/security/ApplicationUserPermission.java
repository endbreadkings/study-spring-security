package io.haedoang.apiserver.security;

/**
 * author : haedoang
 * date : 2022/03/13
 * description :
 */
public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    BOARD_READ("board:read"),
    BOARD_WRITE("board:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}
