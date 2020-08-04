package com.study.zooyun3.springboot.web.controller.student;

import com.study.zooyun3.springboot.service.student.StudentService;
import com.study.zooyun3.springboot.web.dto.student.StudentListResponseDto;
import com.study.zooyun3.springboot.web.dto.student.StudentSaveRequestDto;
import com.study.zooyun3.springboot.web.dto.student.StudentStNumberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/api/v1/students")
    public Long save(@RequestBody StudentSaveRequestDto requestDto) {
        return studentService.save(requestDto);
    }

    @PutMapping("/api/v1/students/{id}")
    public Long update(@PathVariable Long id, @RequestBody StudentStNumberUpdateRequestDto requestDto) {
        return studentService.update(id, requestDto);
    }

    @GetMapping("/json/newId.json")
    public @ResponseBody String idByStNumber() {
        return studentService.idByStNumber();
    }

    @GetMapping("/json/simpleList.json")
    public @ResponseBody List<StudentListResponseDto> simpleList() {
        return studentService.simpleList();
    }
}
