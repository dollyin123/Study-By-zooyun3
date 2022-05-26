package com.study.zooyun3.springboot.domain.students;

import com.study.zooyun3.springboot.web.dto.student.StudentListResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class StudentMapper {
    public StudentListResponseDto toResponse(StudentListInterface studentInterface) {
        return StudentListResponseDto.builder()
                .university(studentInterface.getUniversity())
                .major(studentInterface.getMajor())
                .grade(studentInterface.getGrade())
                .stNumber(studentInterface.getStNumber())
                .name(studentInterface.getName())
                .build();
    }
}
