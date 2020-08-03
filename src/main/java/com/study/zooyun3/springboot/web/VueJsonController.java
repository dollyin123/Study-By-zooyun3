package com.study.zooyun3.springboot.web;

import com.study.zooyun3.springboot.config.auth.LoginUser;
import com.study.zooyun3.springboot.config.auth.dto.SessionUser;
import com.study.zooyun3.springboot.service.address.AddressService;
import com.study.zooyun3.springboot.service.posts.PostsService;
import com.study.zooyun3.springboot.service.student.StudentService;
import com.study.zooyun3.springboot.web.dto.address.AddressOoopmienRequestDto;
import com.study.zooyun3.springboot.web.dto.address.AddressSidoRequestDto;
import com.study.zooyun3.springboot.web.dto.address.AddressSigunguRequestDto;
import com.study.zooyun3.springboot.web.dto.posts.PostsListResponseDto;
import com.study.zooyun3.springboot.web.dto.posts.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class VueJsonController {

    private final PostsService postsService;
    private final StudentService studentService;
    private final AddressService addressService;

    @GetMapping("/json/MyName.json")
    public @ResponseBody String getMyName(@LoginUser SessionUser user) {
        if(user != null) {
            return user.getName();
        }
        return null;
    }

    @GetMapping("/json/{id}/post.json")
    public @ResponseBody PostsResponseDto post(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/json/posts.json")
    public @ResponseBody List<PostsListResponseDto> posts() {
        return postsService.findAllDesc();
    }

    @GetMapping("/json/newId.json")
    public @ResponseBody String idByStNumber() {
        return studentService.idByStNumber();
    }

    @GetMapping("/json/sido.json")
    public @ResponseBody List<AddressSidoRequestDto> sido() {
        return addressService.findSido();
    }

    @GetMapping("/json/sigungu{sido}.json")
    public @ResponseBody List<AddressSigunguRequestDto> sigungu(@PathVariable String sido) {
        return addressService.findSigungu(sido);
    }

    @GetMapping("/json/oopmien{sigungu}.json")
    public @ResponseBody List<AddressOoopmienRequestDto> oopmien(@PathVariable String sigungu) {
        return addressService.findOppmien(sigungu);
    }
}
