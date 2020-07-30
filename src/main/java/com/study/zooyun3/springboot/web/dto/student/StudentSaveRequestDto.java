package com.study.zooyun3.springboot.web.dto.student;

import com.study.zooyun3.springboot.domain.students.Students;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class StudentSaveRequestDto {
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
    private String picture;

    @Builder
    public StudentSaveRequestDto(String university, String major, String stNumber, Integer grade, String name, String sex,
                                 String phoneNumber, String address, Date birthday, Date entranceYear, String picture) {
        this.university = university;
        this.major = major;
        this.stNumber = stNumber;
        this.grade = grade;
        this.name = name;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.entranceYear = entranceYear;
        this.picture = picture;
    }

    public Students toEntity() {
        return Students.builder()
                .university(university)
                .major(major)
                .stNumber(stNumber)
                .grade(grade)
                .name(name)
                .sex(sex)
                .phoneNumber(phoneNumber)
                .address(address)
                .birthday(birthday)
                .entranceYear(entranceYear)
                .picture(picture)
                .build();
    }
}
