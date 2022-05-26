package com.study.zooyun3.springboot.service.university;

import com.study.zooyun3.springboot.domain.university.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UniversityService {
    private final UniversityRepository universityRepository;

    @Transactional(readOnly = true)
    public List<String> selectUniversityList() {
        return universityRepository.selectUniversityList().stream().map(String::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public String selectUniversityCodeByUniversity(String university) {
        return universityRepository.selectUniversityCodeByUniversity(university);
    }

    @Transactional(readOnly = true)
    public String findUniversity(String universityCode) {
        return universityRepository.findUniversity(universityCode);
    }
}
