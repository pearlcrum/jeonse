package com.jeonse.config;

import com.jeonse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SecurityController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userInfo, HttpServletRequest httpServletRequest, Model model) {
        if(userInfo!=null) {
            model.addAttribute("user", memberService.getUserInfo(userInfo.getUsername()));

        }
        //https://chb2005.tistory.com/175
        //https://technology-share.tistory.com/20
        //세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true); //세션이 없으면 생성

        session.setAttribute("memID", userInfo.getUsername());
        System.out.println("Security Controller " + userInfo.getUsername());
        session.setMaxInactiveInterval(1800); //session이 30분동안 유지됨.

        return "/index";
    }
}
