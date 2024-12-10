package com.example.KJ_NoticeBoard.controller;

import com.example.KJ_NoticeBoard.dto.UserDTO;
import com.example.KJ_NoticeBoard.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String successLogin(@RequestParam("id") String id, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean loginSuccess = loginService.successLogin(id, password);

        System.out.println(loginSuccess);

        if (loginSuccess) {
            UserDTO user = loginService.getList(id);
            session.setAttribute("user", user);  // 로그인한 사용자 정보를 세션에 저장
            model.addAttribute("loginSuccess", loginSuccess);
            return "redirect:/";
        } else {
            model.addAttribute("loginSuccess", loginSuccess);
            return "login";
        }
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String save(UserDTO userDTO) {
        loginService.save(userDTO);
        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화 (로그아웃)
        return "redirect:/";
    }
}
