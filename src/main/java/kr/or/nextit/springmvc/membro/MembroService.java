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

    @Transactional
    public void registerMembro(MembroVO membro) {
        membro.setPassword(encoder.encode(membro.getPassword()));
        mapper.registerMembro(membro);
        AuthorityVO authorityVO = new AuthorityVO();
        authorityVO.setMembroId(membro.getId());
//        authorityVO.setAuthority("ROLE_MANAGER");
        mapper.registerAuthority(authorityVO);
    }
}
