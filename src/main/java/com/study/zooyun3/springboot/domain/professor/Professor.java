package com.study.zooyun3.springboot.domain.professor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String university;

    @Column
    private String major;

    @Column
    private String pfNumber;

    @Column
    private String name;

    @Column
    private Date entranceYear;

    @Builder
    public Professor(String university, String major, String pfNumber, String name, Date entranceYear) {
        this.university = university;
        this.major = major;
        this.pfNumber = pfNumber;
        this.name = name;
        this.entranceYear = entranceYear;
    }
}
