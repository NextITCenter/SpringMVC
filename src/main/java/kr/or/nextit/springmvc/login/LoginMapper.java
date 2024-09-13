package kr.or.nextit.springmvc.login;

import kr.or.nextit.springmvc.membro.MembroVO;

public interface LoginMapper {
    MembroVO selectMembroById(String id);
}
