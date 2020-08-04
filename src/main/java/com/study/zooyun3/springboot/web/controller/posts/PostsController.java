package com.study.zooyun3.springboot.web.controller.posts;

import com.study.zooyun3.springboot.service.posts.PostsService;
import com.study.zooyun3.springboot.web.dto.posts.PostsListResponseDto;
import com.study.zooyun3.springboot.web.dto.posts.PostsResponseDto;
import com.study.zooyun3.springboot.web.dto.posts.PostsSaveRequestDto;
import com.study.zooyun3.springboot.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/json/{id}/post.json")
    public @ResponseBody PostsResponseDto post(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/json/posts.json")
    public @ResponseBody
    List<PostsListResponseDto> posts() {
        return postsService.findAllDesc();
    }
}
