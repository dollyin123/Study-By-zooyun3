package com.study.zooyun3.springboot.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sido;

    @Column
    private String sigungu;

    @Column
    private String oopmien;

    @Column
    private String doro;

    @Builder
    public Address(String sido, String sigungu, String oopmien, String doro) {
        this.sido = sido;
        this.sigungu = sigungu;
        this.oopmien = oopmien;
        this.doro = doro;
    }
}
