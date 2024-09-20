package kr.or.nextit.springmvc.membro;

import java.util.List;

public interface MembroMapper {
    List<MembroVO> selectMembroList();
    MembroVO selectMembro(String id);
    void registerMembro(MembroVO membro);
    void modifyMembro(MembroVO membro);
    void removeMembro(String id);

    List<AuthorityVO> selectAuthority(String membroId);
    void grantAuthority(AuthorityVO authority);
    void revokeAuthority(AuthorityVO authority);

}
