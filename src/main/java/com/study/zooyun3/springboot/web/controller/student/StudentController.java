package com.study.zooyun3.springboot.web.controller.student;

import com.study.zooyun3.springboot.service.student.StudentService;
import com.study.zooyun3.springboot.web.dto.student.StudentListResponseDto;
import com.study.zooyun3.springboot.web.dto.student.StudentSaveRequestDto;
import com.study.zooyun3.springboot.web.dto.student.StudentUpdateRequestDto;
import com.study.zooyun3.springboot.web.dto.student.StudentsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/api/students")
    public Long save(@RequestBody StudentSaveRequestDto requestDto) {
        return studentService.save(requestDto);
    }

    @PutMapping("/api/students/{id}")
    public Long update(@PathVariable Long id, @RequestBody StudentUpdateRequestDto requestDto) {
        return studentService.update(id, requestDto);
    }

    @GetMapping("/json/newId.json")
    public @ResponseBody String maxId() {
        return studentService.maxId();
    }

    @GetMapping("/json/studentList.json/page={page}")
    public @ResponseBody List<StudentListResponseDto> simpleList(@PathVariable int page) {
        return studentService.studentList(page);
    }

    @GetMapping("/getrows")
    public int findRows() {
        return (studentService.findRows()/25)+1;
    }

    @GetMapping("/json/{no}/student.json")
    public @ResponseBody
    StudentsResponseDto student(@PathVariable Long no) {
        return studentService.findByNo(no);
    }
}
