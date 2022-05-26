package com.study.zooyun3.springboot.service.student;

import com.study.zooyun3.springboot.domain.students.StudentMapper;
import com.study.zooyun3.springboot.domain.students.Students;
import com.study.zooyun3.springboot.domain.students.StudentsRepository;
import com.study.zooyun3.springboot.web.dto.student.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentsRepository studentsRepository;
    private final StudentMapper studentMapper;

    @Transactional
    public Long save(StudentSaveRequestDto requestDto) {
        return studentsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, StudentUpdateRequestDto requestDto) {
        Students students = studentsRepository.findById(studentsRepository.idByStNumber(id)).orElseThrow(() ->
                new IllegalArgumentException("해당 학생 없습니다. id=" + id));

        students.studentUpdate(requestDto.getPhoneNumber(), requestDto.getAddress());

        return id;
    }

    @Transactional(readOnly = true)
    public String maxId() {
        return studentsRepository.maxId();
    }

    @Transactional(readOnly = true)
    public List<StudentListResponseDto> studentList(int page) {
        return studentsRepository.studentList((page*25)-25).stream().map(x -> studentMapper.toResponse(x)).collect(Collectors.toList());
    }

    public int findRows() {
        return studentsRepository.findRows();
    }

    public StudentsResponseDto findByNo (Long no) {
        Students entity = studentsRepository.findById(studentsRepository.idByStNumber(no)).orElseThrow(() ->
                new IllegalArgumentException("해당 학생이 없습니다. no=" + no));

        return new StudentsResponseDto(entity);
    }
}
