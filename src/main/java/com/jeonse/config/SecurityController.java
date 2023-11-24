package com.jeonse.controller;

import com.jeonse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/main")
    public String home(@AuthenticationPrincipal UserDetails userInfo, Model model) {
        if(userInfo!=null) {
            model.addAttribute("user", memberService.getUserInfo(userInfo.getUsername()));
        }
        return "/member/home";
    }
}
