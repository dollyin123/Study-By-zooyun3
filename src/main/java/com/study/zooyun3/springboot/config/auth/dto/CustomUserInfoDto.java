package com.study.zooyun3.springboot.config.auth.dto;

import com.study.zooyun3.springboot.domain.user.CustomUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomUserInfoDto {
    private String email;
    private String password;
    private String name;
    private String role;

    @Builder
    public CustomUserInfoDto(String email, String password, String name, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public CustomUser toEntity() {
        return CustomUser.builder()
                .email(email)
                .password(password)
                .name(name)
                .role(role)
                .build();
    }
}
