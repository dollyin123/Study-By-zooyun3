package com.study.zooyun3.springboot.service.student;

import com.study.zooyun3.springboot.domain.students.Students;
import com.study.zooyun3.springboot.domain.students.StudentsRepository;
import com.study.zooyun3.springboot.web.dto.student.StudentSaveRequestDto;
import com.study.zooyun3.springboot.web.dto.student.StudentStNumberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentsRepository studentsRepository;

    @Transactional
    public Long save(StudentSaveRequestDto requestDto) {
        return studentsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, StudentStNumberUpdateRequestDto requestDto) {
        Students students = studentsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        students.stNumberUpdate(requestDto.getStNumber());

        return id;
    }

    @Transactional(readOnly = true)
    public String idByStNumber() {
        return studentsRepository.idByStNumber();
    }
}
