package com.study.zooyun3.springboot.web.controller.user;

import com.study.zooyun3.springboot.config.auth.LoginUser;
import com.study.zooyun3.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    @GetMapping("/json/MyName.json")
    public @ResponseBody
    String getMyName(@LoginUser SessionUser user) {
        if(user != null) {
            return user.getName();
        }
        return null;
    }
}
