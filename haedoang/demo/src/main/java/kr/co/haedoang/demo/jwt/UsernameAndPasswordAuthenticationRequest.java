package kr.co.haedoang.demo.jwt;

/**
 * packageName : kr.co.haedoang.demo.jwt
 * fileName : UsernameAndPasswordAuthenticationRequest
 * author : haedoang
 * date : 2022-02-16
 * description :
 */
public class UsernameAndPasswordAuthenticationRequest {
    private String username;
    private String password;

    public UsernameAndPasswordAuthenticationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
