package com.study.zooyun3.springboot.domain.students;

import com.study.zooyun3.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {

    @Query("SELECT id FROM Students WHERE stNumber = '0'")
    String idByStNumber();

    @Query("SELECT p.university, p.major, p.grade, p.stNumber, p.name FROM Students p ORDER BY p.stNumber DESC")
    List<Students> simpleList();
}
