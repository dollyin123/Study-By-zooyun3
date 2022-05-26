package com.study.zooyun3.springboot.config.auth.dto;

import com.study.zooyun3.springboot.domain.user.CustomUser;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CustomSessionUser implements Serializable {
    private String name;
    private String email;

    public CustomSessionUser(CustomUser customUser) {
        this.name = customUser.getName();
        this.email = customUser.getEmail();
    }

    @Builder
    public CustomSessionUser(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public CustomUser toEntity() {
        return CustomUser.builder()
                .email(email)
                .name(name)
                .build();
    }
}
