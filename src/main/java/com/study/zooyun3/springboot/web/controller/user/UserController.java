package com.study.zooyun3.springboot.web.controller.user;

import com.study.zooyun3.springboot.config.auth.CustomLoginUser;
import com.study.zooyun3.springboot.config.auth.CustomAuthUserService;
import com.study.zooyun3.springboot.config.auth.LoginUser;
import com.study.zooyun3.springboot.config.auth.SessionConstants;
import com.study.zooyun3.springboot.config.auth.dto.CustomSessionUser;
import com.study.zooyun3.springboot.config.auth.dto.CustomUserInfoDto;
import com.study.zooyun3.springboot.config.auth.dto.SessionUser;
import com.study.zooyun3.springboot.domain.user.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final CustomAuthUserService customAuthUserService;

    @GetMapping("/json/getname")
    public @ResponseBody
    String getMyName(@LoginUser SessionUser user, @CustomLoginUser CustomSessionUser customUser) {
        if(user != null) {
            return user.getName();
        } else if(customUser != null) {
            return customUser.getName();
        }
        return null;
    }

    @GetMapping("/json/getnumber")
    public String getNumber(@LoginUser SessionUser user, @CustomLoginUser CustomSessionUser customUser) {
        if(user != null) {
            return user.getEmail();
        } else if(customUser != null) {
            return customUser.getEmail();
        }
        return null;
    }

    @PostMapping("/user")
    public Long signup(@RequestBody CustomUserInfoDto infoDto) {
        return customAuthUserService.save(infoDto);
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder
                .getContext().getAuthentication());
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestBody CustomUserInfoDto infoDto, BindingResult bindingResult,
                        HttpServletRequest request) {

        if(bindingResult.hasErrors()) {
            return "/";
        }

        CustomUser loginCustomUser = customAuthUserService.login(infoDto.getEmail(), infoDto.getPassword());

        if(loginCustomUser == null) {
            bindingResult.reject("loginFail", "로그인 실패");
            return "/";
        }

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(SessionConstants.LOGIN_MEMBER, new CustomSessionUser(loginCustomUser));

        return "/";
    }
}
