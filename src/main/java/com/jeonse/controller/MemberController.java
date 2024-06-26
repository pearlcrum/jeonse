package com.jeonse.controller;

import com.jeonse.dto.MemberDTO;
import com.jeonse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


//회원 컨트롤러
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    //로그인 폼 보여주기
    @GetMapping(value="/loginForm")
    public String login(@RequestParam(value="error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception,
                        @AuthenticationPrincipal  UserDetails userInfo, Model model) throws Exception{
        model.addAttribute("member",userInfo);
        model.addAttribute("exception",exception);
        return "member/login";
    }

    //회원가입 폼 보여주기
    @GetMapping(value="/joinForm")
    public String join(){
        return "member/join";
    }

    //회원가입 처리
    @PostMapping(value="/member/join")
    public String joinMember(MemberDTO memberDto) {
        memberService.insertMem(memberDto);
        return "redirect:/";
    }

    //아이디 중복체크
    @PostMapping(value="/joinForm/checkId")
    @ResponseBody
    public int checkId(@RequestParam("memID") String memID) {

        System.out.println("memId"+memID);

        int cnt = memberService.checkId(memID);

        return cnt;
    }
}