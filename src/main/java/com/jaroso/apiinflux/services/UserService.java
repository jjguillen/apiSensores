package com.jaroso.apiinflux.services;

import com.jaroso.apiinflux.dto.UserRegisterDTO;
import com.jaroso.apiinflux.entities.User;
import com.jaroso.apiinflux.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    public User save(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setUsername(userRegisterDTO.username());
        user.setEmail(userRegisterDTO.email());
        //Falta comprobación de que password2 es igual a password
        user.setPassword(this.passwordEncoder.encode(userRegisterDTO.password()));
        return this.userRepository.save(user);
    }

}
