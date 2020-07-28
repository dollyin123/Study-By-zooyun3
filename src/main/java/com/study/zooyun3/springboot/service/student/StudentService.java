package com.study.zooyun3.springboot.service.student;

import com.study.zooyun3.springboot.domain.students.StudentsRepository;
import com.study.zooyun3.springboot.web.dto.student.StudentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentsRepository studentsRepository;

    @Transactional
    public Long save(StudentSaveRequestDto requestDto) {
        return studentsRepository.save(requestDto.toEntity()).getId();
    }
}
