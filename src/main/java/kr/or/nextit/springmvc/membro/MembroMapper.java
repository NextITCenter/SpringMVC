package kr.or.nextit.springmvc.membro;

import java.util.List;

public interface MembroMapper {
    List<MembroVO> selectMembroList();
    void registerMembro(MembroVO membro);
    void modifyMembro(MembroVO membro);
    void removeMembro(String id);
    void registerAuthority(AuthorityVO authority);
}
