package kr.or.nextit.springmvc.membro;

public enum Authority {
    ROLE_USER("일반회원"),
    ROLE_MANAGER("매니저"),
    ROLE_ADMIN("관리자");
    private String title;
    Authority(String title) {
        this.title = title;
    }
}
