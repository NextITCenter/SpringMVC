package kr.or.nextit.springmvc.login;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class AuthorityVO implements GrantedAuthority {
    private String membroId;
    private String authority;

//    public String getAuthority() {
//        return authority;
//    }
}
