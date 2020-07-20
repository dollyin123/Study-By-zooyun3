package com.study.zooyun3.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/posts/board")
    public String postsBoard() {
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate() {
        return "index";
    }
}
