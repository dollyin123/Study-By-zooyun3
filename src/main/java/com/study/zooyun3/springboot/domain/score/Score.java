package com.study.zooyun3.springboot.domain.score;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String courseCode;

    @Column
    private String stNumber;

    @Column
    private String score;
}
