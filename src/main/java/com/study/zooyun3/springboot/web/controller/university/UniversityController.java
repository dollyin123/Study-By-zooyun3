package com.study.zooyun3.springboot.web.controller.university;

import com.study.zooyun3.springboot.service.university.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping("/json/getUniversityList.json")
    public @ResponseBody List<String> selectUniversityList() {
        return universityService.selectUniversityList();
    }

    @GetMapping("/json/getUniversityCodeByUniversity{university}.json")
    public @ResponseBody String selectUniversityCodeByUniversity(@PathVariable String university) {
        return universityService.selectUniversityCodeByUniversity(university);
    }

    @GetMapping("/json/university{universityCode}.json")
    public @ResponseBody String findUniversity(@PathVariable String universityCode) {
        return universityService.findUniversity(universityCode);
    }
}
