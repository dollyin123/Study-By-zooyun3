package com.study.zooyun3.springboot.web;

import com.study.zooyun3.springboot.service.student.StudentService;
import com.study.zooyun3.springboot.web.dto.student.StudentSaveRequestDto;
import com.study.zooyun3.springboot.web.dto.student.StudentStNumberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StudentApiCotroller {
    private final StudentService studentService;

    @PostMapping("/api/v1/students")
    public Long save(@RequestBody StudentSaveRequestDto requestDto) {
        return studentService.save(requestDto);
    }

    @PutMapping("/api/v1/students/{id}")
    public Long update(@PathVariable Long id, @RequestBody StudentStNumberUpdateRequestDto requestDto) {
        return studentService.update(id, requestDto);
    }
}
