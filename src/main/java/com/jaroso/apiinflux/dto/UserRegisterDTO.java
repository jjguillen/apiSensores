package com.jaroso.apiinflux.dto;

import lombok.Getter;


public record UserRegisterDTO(String username, String email, String password, String password2) {
}
