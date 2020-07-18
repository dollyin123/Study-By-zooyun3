package com.study.zooyun3.springboot.web;

import com.study.zooyun3.springboot.config.auth.LoginUser;
import com.study.zooyun3.springboot.config.auth.dto.SessionUser;
import com.study.zooyun3.springboot.service.posts.PostsService;
import com.study.zooyun3.springboot.web.dto.PostsListResponseDto;
import com.study.zooyun3.springboot.web.dto.PostsResponseDto;
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
}
