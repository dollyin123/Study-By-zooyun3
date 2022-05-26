package com.study.zooyun3.springboot.domain.students;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String university;

    @Column
    private String major;

    @Column
    private String stNumber;

    @Column
    private Integer grade;

    @Column
    private String name;

    @Column
    private String sex;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private Date birthday;

    @Column
    private Date entranceYear;

    @Column
    private String picture;

    @Builder
    public Students(String university, String major, String stNumber, Integer grade, String name, String sex,
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

    @Builder
    public Students(String university, String major, Integer grade, String stNumber, String name) {
        this.university = university;
        this.major = major;
        this.grade = grade;
        this.stNumber = stNumber;
        this.name = name;
    }

    public void studentUpdate(String phoneNumber, String address) {
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
