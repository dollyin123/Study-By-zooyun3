package com.study.zooyun3.springboot.web.dto.student;

import lombok.Getter;

@Getter
public class StudentUpdateRequestDto {
    private String phoneNumber;
    private String address;

    StudentUpdateRequestDto(String phoneNumber, String address) {
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
