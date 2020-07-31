package com.study.zooyun3.springboot.web.dto.student;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentStNumberUpdateRequestDto {
    private String stNumber;

    @Builder
    public StudentStNumberUpdateRequestDto(String stNumber) {
        this.stNumber = stNumber;
    }
}
