package kr.or.nextit.springmvc.membro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Authority {
    ROLE_USER("일반회원"),
    ROLE_MANAGER("매니저"),
    ROLE_ADMIN("관리자");
    private String title;
}
