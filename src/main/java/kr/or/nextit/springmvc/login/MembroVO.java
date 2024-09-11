package kr.or.nextit.springmvc.login;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MembroVO {
    private String id;
    private String password;
    private String name;
    private String email;
    private String mobileNumber;
    private LocalDateTime registerDate;
    private LocalDateTime modifiedDate;
    private boolean enabled;
    private List<AuthorityVO> authorities;
}
