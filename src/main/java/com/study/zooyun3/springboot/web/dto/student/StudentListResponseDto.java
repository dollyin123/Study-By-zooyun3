package com.study.zooyun3.springboot.web.dto.student;

import com.study.zooyun3.springboot.domain.students.Students;
import lombok.Getter;

@Getter
public class StudentListResponseDto {
    private String university;
    private String major;
    private Integer grade;
    private String stNumber;
    private String name;

    public StudentListResponseDto(Students entity) {
        this.university = entity.getUniversity();
        this.major = entity.getMajor();
        this.grade = entity.getGrade();
        this.stNumber = entity.getStNumber();
        this.name = entity.getName();
    }
}
