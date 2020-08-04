package com.study.zooyun3.springboot.domain.university;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String universityCode;

    @Column
    private String university;

    @Builder
    public University(String universityCode, String university) {
        this.universityCode = universityCode;
        this.university = university;
    }
}
