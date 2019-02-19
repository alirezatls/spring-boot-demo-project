package com.demo.security.securitydemo.principal;

import com.demo.security.securitydemo.jpa.AuthUser;
import com.demo.security.securitydemo.jpa.AuthUserRepository;
import com.demo.security.securitydemo.jpa.User;
import com.demo.security.securitydemo.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    private AuthUserRepository authUserRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, AuthUserRepository authUserRepository) {
        this.userRepository = userRepository;
        this.authUserRepository = authUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("not found");
        }
        List<AuthUser> roles = authUserRepository.findByUsername(username);
        return new UserPrincipal(user,roles);
    }
}
