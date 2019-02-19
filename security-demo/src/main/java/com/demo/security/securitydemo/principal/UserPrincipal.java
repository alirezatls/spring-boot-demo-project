package com.demo.security.securitydemo.principal;

import com.demo.security.securitydemo.jpa.AuthUser;
import com.demo.security.securitydemo.jpa.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipal implements UserDetails {

    private User user;
    private List<AuthUser> authUsers;

    public UserPrincipal(User user, List<AuthUser> authUsers)
    {
        this.user = user;
        this.authUsers = authUsers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authUsers == null) {
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authUsers.forEach(
                authUser -> grantedAuthorities.add(new SimpleGrantedAuthority(authUser.getAuthGroup())));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
