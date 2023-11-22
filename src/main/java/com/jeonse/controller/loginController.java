package com.jeonse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class loginController {

    /*
    * 로그인 페이지로, 이메일과 비번을 입력하면 메인페이지로 리다이렉트되고 이메일 비번이 토스트 메시지로 생성됨.
    * */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/processLogin")
    public String processLogin(@RequestParam("inputEmail") String inputEmail,
                               @RequestParam("inputPassword") String inputPassword,
                               Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("inputEmail", inputEmail);
        model.addAttribute("inputPassword", inputPassword);

        redirectAttributes.addAttribute("inputEmail", inputEmail);
        redirectAttributes.addAttribute("inputPassword", inputPassword);
        return "redirect:/index";
    }

}

