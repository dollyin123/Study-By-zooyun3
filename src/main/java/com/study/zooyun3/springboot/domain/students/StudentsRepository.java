package com.study.zooyun3.springboot.domain.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {

    @Query("SELECT id FROM Students WHERE stNumber = '0'")
    String idByStNumber();

    @Query("SELECT p FROM Students p ORDER BY p.stNumber ASC")
    List<Students> simpleList();
}
