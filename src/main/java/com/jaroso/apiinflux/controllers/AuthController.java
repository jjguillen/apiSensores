package com.jaroso.apiinflux.controllers;

import com.jaroso.apiinflux.dto.LoginRequest;
import com.jaroso.apiinflux.dto.LoginResponse;
import com.jaroso.apiinflux.dto.UserRegisterDTO;
import com.jaroso.apiinflux.entities.User;
import com.jaroso.apiinflux.security.JwtUtil;
import com.jaroso.apiinflux.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/auth/register")
    public User save(@RequestBody UserRegisterDTO userDTO){
        return this.userService.save(userDTO);
    }

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest loginDTO){

        Authentication authDTO = new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password());

        //Este método es el que llama al AuthenticationManager correspondiente para ver si la autenticación es correcta
        Authentication authentication = this.authManager.authenticate(authDTO);

        //El método nos devuelve un User (con UserDetailService) para con esos datos generar el token
        User user = (User) authentication.getPrincipal();

        String token = this.jwtUtil.generateToken(authentication);

        return new LoginResponse(user.getUsername(),
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList(),
                token);
    }

}
