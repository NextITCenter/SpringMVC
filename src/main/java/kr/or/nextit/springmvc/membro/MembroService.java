package kr.or.nextit.springmvc.membro;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembroService {
    private final MembroMapper mapper;
    private final PasswordEncoder encoder;

    public List<MembroVO> selectMembroList() {
        return mapper.selectMembroList();
    }

    public MembroVO selectMembro(String id) {
        return mapper.selectMembro(id);
    }

    @Transactional
    public void registerMembro(MembroVO membro) {
        membro.setPassword(encoder.encode(membro.getPassword()));
        mapper.registerMembro(membro);
        AuthorityVO authorityVO = new AuthorityVO();
        authorityVO.setMembroId(membro.getId());
//        authorityVO.setAuthority("ROLE_MANAGER");
        mapper.grantAuthority(authorityVO);
    }

    public void updateMembro(MembroVO membro) {
        mapper.modifyMembro(membro);
    }

    public void deleteMembro(String id) {
        mapper.removeMembro(id);
    }

    public List<AuthorityVO> selectAuthority(String membroId) {
        return mapper.selectAuthority(membroId);
    }

    public void grantAuthority(AuthorityVO authorityVO) {
        mapper.grantAuthority(authorityVO);
    }

    public void revokeAuthority(AuthorityVO authority) {
        mapper.revokeAuthority(authority);
    }
}
