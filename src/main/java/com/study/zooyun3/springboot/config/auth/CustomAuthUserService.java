package com.study.zooyun3.springboot.config.auth;

import com.study.zooyun3.springboot.config.auth.dto.CustomUserInfoDto;
import com.study.zooyun3.springboot.domain.user.CustomUser;
import com.study.zooyun3.springboot.domain.user.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomAuthUserService implements UserDetailsService {

    private final CustomUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public Long save(CustomUserInfoDto infoDto) {
        return userRepository.save(infoDto.toEntity()).getId();
    }

    public CustomUser login(String email, String password) {
        CustomUser customUser = userRepository.findByEmail(email).
                filter(m -> m.getPassword().equals(password))
                .orElse(null);
        return userRepository.save(customUser);
    }
}
