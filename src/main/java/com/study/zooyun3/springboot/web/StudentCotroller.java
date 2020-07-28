package com.study.zooyun3.springboot.web;

import com.study.zooyun3.springboot.service.student.StudentService;
import com.study.zooyun3.springboot.web.dto.student.StudentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StudentCotroller {
    private final StudentService studentService;

    @PostMapping("/api/v1/students")
    public Long save(@RequestBody StudentSaveRequestDto requestDto) {
        return studentService.save(requestDto);
    }
}
