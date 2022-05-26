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

    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/posts/{id}")  // 안쓰이고있는듯
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/json/{id}/post.json")
    public @ResponseBody
    PostsResponseDto post(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/json/postsList.json/{board}/page={page}")
    public @ResponseBody
    List<PostsListResponseDto> posts(@PathVariable String board, @PathVariable int page) {
        return postsService.findAllDesc(board, page);
    }

    @GetMapping("/getrows/{board}")
    public int findRows(@PathVariable String board) {
        return (postsService.findRows(board)/25)+1;
    }
}
