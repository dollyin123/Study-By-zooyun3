package com.study.zooyun3.springboot.domain.major;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Long> {
    @Query("SELECT major FROM Major WHERE universityCode = :universityCode")
    List<String> selectMajorListByUniversityCode(@Param("universityCode") String universityCode);

    @Query("SELECT majorCode FROM Major WHERE major = :major")
    String selectMajorCodeByMajor(@Param("major") String major);

    @Query("SELECT major FROM Major WHERE majorCode = :majorCode")
    String findMajor(@Param("majorCode") String majorCode);

    @Query("select m.major from Students s inner join Major m on s.major = m.majorCode")
    List<Major> majorList();
}
