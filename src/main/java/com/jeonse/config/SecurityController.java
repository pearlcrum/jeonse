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
import java.util.List;
import java.util.Map;

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
        HttpSession session = httpServletRequest.getSession(true); //세션이 없으면 생성

        session.setAttribute("memID", userInfo.getUsername());
        System.out.println("Security Controller " + userInfo.getUsername());
        session.setMaxInactiveInterval(1800); //session이 30분동안 유지됨.

        return "/index";
    }
    @PostMapping(value="/houseSearch")
    @ResponseBody
    public HouseinfoDTO houseSearch(@RequestParam("houseID") int houseID){
        System.out.println("houseSearch success"+ houseID);
        HouseinfoDTO house = houseinfoService.getHouseinfo(houseID);
        return house;
    }
    //아파트 자동완성 검색
    @RequestMapping(value = "/autocomplete")
    public @ResponseBody Map<String, Object> autocomplete
            (@RequestParam Map<String, Object> paramMap) throws Exception{

        List<Map<String, Object>> resultList = houseinfoService.autocomplete(paramMap);
        paramMap.put("resultList", resultList);

        return paramMap;
    }
}
