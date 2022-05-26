package com.study.zooyun3.springboot.web.dto.student;

import com.study.zooyun3.springboot.domain.students.Students;
import lombok.Getter;

import java.sql.Date;

@Getter
public class StudentsResponseDto {
    private Long id;
    private String university;
    private String major;
    private String stNumber;
    private Integer grade;
    private String name;
    private String sex;
    private String phoneNumber;
    private String address;
    private Date birthday;
    private Date entranceYear;

    public StudentsResponseDto(Students entity) {
        this.id = entity.getId();
        this.university = entity.getUniversity();
        this.major = entity.getMajor();
        this.stNumber = entity.getStNumber();
        this.grade = entity.getGrade();
        this.name = entity.getName();
        this.sex = entity.getSex();
        this.phoneNumber = entity.getPhoneNumber();
        this.address = entity.getAddress();
        this.birthday = entity.getBirthday();
        this.entranceYear = entity.getEntranceYear();
    }
}
