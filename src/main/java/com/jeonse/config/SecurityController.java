package com.jeonse.config;

import com.jeonse.dto.HouseinfoDTO;
import com.jeonse.service.HouseinfoService;
import com.jeonse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class SecurityController {

    @Autowired
    MemberService memberService;

    @Autowired
    HouseinfoService houseinfoService;

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
    @PostMapping(value="/houseSearch")
    @ResponseBody
    public HouseinfoDTO houseSearch(@RequestParam("aptName") String aptName){
        System.out.println("houseSearch success"+ aptName);
        HouseinfoDTO house = houseinfoService.getHouseInfoByName(aptName);
        return house;
    }

    /* 아파트 명 자동완성 검색 기능
    @PostMapping(value="/houseSearch")
    @ResponseBody
    public HashMap<Integer, HouseinfoDTO> houseSearch(@RequestParam("aptName") String aptName){
        HashMap<Integer, HouseinfoDTO> houses = houseinfoService.getHouseInfoByName(aptName);
        return houses;
    }*/
}
