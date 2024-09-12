package kr.or.nextit.springmvc.login;

import java.util.List;

public interface LoginMapper {
    MembroVO selectMembroById(String id);

    void registerMembro(MembroVO membro);
    void modifyMembro(MembroVO membro);
    void removeMembro(String id);

    void registerAuthority(AuthorityVO authority);
}
