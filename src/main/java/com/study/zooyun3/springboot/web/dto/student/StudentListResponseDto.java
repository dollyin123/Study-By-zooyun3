package com.study.zooyun3.springboot.web.dto.student;

import com.study.zooyun3.springboot.domain.students.Students;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentListResponseDto {
    private String university;
    private String major;
    private Integer grade;
    private String stNumber;
    private String name;
}
