package com.study.zooyun3.springboot.service.major;

import com.study.zooyun3.springboot.domain.major.MajorRepository;
import com.study.zooyun3.springboot.domain.university.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MajorService {
    private final MajorRepository majorRepository;
    private final UniversityRepository universityRepository;

    @Transactional(readOnly = true)
    public List<String> selectMajorListByUniversityCode(String university) {
        String universityCode = universityRepository.selectUniversityCodeByUniversity(university);
        return majorRepository.selectMajorListByUniversityCode(universityCode).stream().map(String::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public String selectMajorCodeByMajor(String major) {
        return majorRepository.selectMajorCodeByMajor(major);
    }

    @Transactional(readOnly = true)
    public String findMajor(String majorCode) {
        return majorRepository.findMajor(majorCode);
    }
}
