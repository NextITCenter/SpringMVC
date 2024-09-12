package kr.or.nextit.springmvc.login;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final LoginMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MembroVO membro = mapper.selectMembroById(username);
        return User.withUsername(username)
                .password(membro.getPassword())
                .authorities(membro.getAuthorities())
                .build();
    }

    public void registerMembro(MembroVO membro) {
        mapper.registerMembro(membro);
        AuthorityVO authorityVO = new AuthorityVO();
        authorityVO.setMembroId(membro.getId());
//        authorityVO.setAuthority("ROLE_MANAGER");
        mapper.registerAuthority(authorityVO);
    }
}
