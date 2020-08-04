package com.study.zooyun3.springboot.domain.major;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column String universityCode;

    @Column
    private String majorCode;

    @Column
    private String major;

    @Builder
    public Major(String universityCode, String majorCode, String major) {
        this.universityCode = universityCode;
        this.majorCode = majorCode;
        this.major = major;
    }
}
