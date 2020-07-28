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
    private String universe;

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
    public Students(String universe, String major, String stNumber, Integer grade, String name, String sex,
                    String phoneNumber, String address, Date birthday, Date entranceYear, String picture) {
        this.universe = universe;
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
}