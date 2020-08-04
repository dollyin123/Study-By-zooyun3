package com.study.zooyun3.springboot.domain.course;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Getter
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String major;

    @Column
    private String pfNumber;

    @Column
    private String courseCode;

    @Column
    private String courseTime;

    @Column
    private Time firstTime;

    @Column
    private Time secondTime;

    @Column
    private Time lastTime;

    @Column
    private Boolean isMajor;

    @Column
    private Boolean isNecessary;

    @Builder
    public Course(String major, String pfNumber, String courseCode, String courseTime, Time firstTime,
                  Time secondTime, Time lastTime, Boolean isMajor, Boolean isNecessary) {
        this.major = major;
        this.pfNumber = pfNumber;
        this.courseCode = courseCode;
        this.courseTime = courseTime;
        this.firstTime = firstTime;
        this.secondTime = secondTime;
        this.lastTime = lastTime;
        this.isMajor = isMajor;
        this.isNecessary = isNecessary;
    }
}
