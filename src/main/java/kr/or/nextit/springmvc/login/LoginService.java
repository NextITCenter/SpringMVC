package kr.or.nextit.springmvc.login;

import kr.or.nextit.springmvc.membro.AuthorityVO;
import kr.or.nextit.springmvc.membro.MembroVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                .disabled(!membro.isEnabled())
                .authorities(membro.getAuthorities())
                .build();
    }

}
