package com.study.zooyun3.springboot.web.controller.major;

import com.study.zooyun3.springboot.service.major.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MajorController {
    private final MajorService majorService;

    @GetMapping("/json/getMajorList{university}.json")
    public @ResponseBody List<String> selectMajorListByUniversityCode(@PathVariable String university) {
        return majorService.selectMajorListByUniversityCode(university);
    }

    @GetMapping("/json/getMajorCodeByMajor{major}.json")
    public @ResponseBody
    String selectMajorCodeByMajor(@PathVariable String major) {
        return majorService.selectMajorCodeByMajor(major);
    }

    @GetMapping("/json/major{majorCode}.json")
    public @ResponseBody String findMajor(@PathVariable String majorCode) {
        return majorService.findMajor(majorCode);
    }
}
