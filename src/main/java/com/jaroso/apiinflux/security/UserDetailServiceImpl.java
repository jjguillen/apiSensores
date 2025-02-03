package com.jaroso.apiinflux.security;

import com.jaroso.apiinflux.entities.User;
import com.jaroso.apiinflux.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userService.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username + " no encontrado")
        );


    }
}
