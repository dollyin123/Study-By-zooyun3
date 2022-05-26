package com.study.zooyun3.springboot.domain.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {

    @Query("SELECT MAX(id) FROM Students")
    String maxId();

    @Query(value = "SELECT u.university, m.major, s.grade, s.st_number as stNumber, s.name \n" +
            "FROM Students s \n" +
            "INNER JOIN Major m ON s.major = m.major_code \n" +
            "INNER JOIN University u ON s.university = u.university_code \n" +
            "ORDER BY s.id ASC LIMIT :page,25", nativeQuery = true)
    List<StudentListInterface> studentList(int page);

    @Query(value = "select COUNT(*) FROM students", nativeQuery = true)
    int findRows();

    @Query(value = "SELECT id FROM Students WHERE st_number = :no", nativeQuery = true)
    Long idByStNumber(@Param("no") Long no);
}
