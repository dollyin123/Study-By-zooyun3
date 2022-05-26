package com.study.zooyun3.springboot.domain.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long> {
    @Query("SELECT university FROM University")
    List<String> selectUniversityList();

    @Query("SELECT universityCode FROM University WHERE university = :university")
    String selectUniversityCodeByUniversity(@Param("university") String university);

    @Query("SELECT university FROM University WHERE universityCode = :universityCode")
    String findUniversity(@Param("universityCode") String universityCode);

    @Query("select u.university from Students s inner join University u on s.university = u.universityCode")
    List<University> universityList();
}
