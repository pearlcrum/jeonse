package com.jeonse.controller;

import com.jeonse.dto.CommonchecklistDTO;
import com.jeonse.dto.MemberDTO;
import com.jeonse.service.CommonchecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CommonchecklistController {
    @Autowired
    private CommonchecklistService commonchecklistService;


    //체크리스트 보여주기
    @GetMapping("/checklist")
    public String checklist(@SessionAttribute(name="memID", required = false) String memID,  CommonchecklistDTO commonchecklistDTO) {
        //체크리스트에 값이 이미 있는 경우
        if(commonchecklistService.checkCommonchecklistID(memID)!=0){
            //세션 초기화 및 profile로 이동하여 기존 체크리스트 삭제 요청 필요 (-->해야해?)
            //return "profile";
        }else{
            //체크리스트에 값이 없는 경우
            //memid 를 받아야함.
            System.out.println("memID is " + memID);
        }
        return "checklist";
    }

    @PostMapping("/checklist")
    public String checklistSubmit(CommonchecklistDTO commonchecklistDTO) {
        System.out.println("@@@"+  commonchecklistDTO.getLandlordPossessionMonth());
        commonchecklistService.insertCommonchecklist(commonchecklistDTO);
        return "redirect/main";
    }
    /*@PostMapping("/checklistNextStep")
    public String checklistNextStep(@RequestParam("checklistNextStep") CommonchecklistDTO checklistDto ) {
        System.out.println("여기는 잘 들어 오나요?");
        commonchecklistService.insertCommonchecklist(checklistDto);
        return "redirect:/index";
    }*/


    /*@GetMapping("/checklist")
    //public String checklist(HttpServletRequest request) throws Exception{
    public String checklist(CommonchecklistDTO commonchecklistDTO) {
        //체크리스트에 값이 이미 있는 경우
        //세션 초기화 및 profile로 이동하여 기존 체크리스트 삭제 요청 필요
        //체크리스트에 값이 없는 경우

        //HttpSession session = request.getSession();

        System.out.println("@@@@" + commonchecklistDTO.getLandlordPossessionMonth());
        //session.setAttribute("memID",memID); //세션에 현재 들어온 사람 정보 넣기.
        return "checklist";
    }*/
    //체크리스트 값 입력
    /*@PostMapping("/checklistNextStep")
    public String checklistNextStep(@RequestParam("checklistNextStep") CommonchecklistDTO checklistDto, HttpServletRequest request) {
        System.out.println("여기는 잘 들어 오나요?");
        HttpSession session=request.getSession();
        String memID=(String)session.getAttribute("memID");
        System.out.println(memID);
        System.out.println("여기보세요"+checklistDto.getJeonseTerm());
        //session.setAttribute(); //여기에 넣자
        commonchecklistService.insertCommonchecklist(checklistDto);
        return "redirect:/index";
    }*/
    public String processSignup(@RequestParam("inputName") String inputName,
                                @RequestParam("inputEmail") String inputEmail,
                                @RequestParam("inputPassword") String inputPassword,
                                Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("inputName", inputName);
        model.addAttribute("inputEmail", inputEmail);
        model.addAttribute("inputPassword", inputPassword);

        redirectAttributes.addAttribute("inputEmail", inputEmail);
        redirectAttributes.addAttribute("inputPassword", inputPassword);
        return "redirect:index";
    /*
    //아이디 중복체크
    @PostMapping(value="/joinForm/checkId")
    @ResponseBody
    public int checkId(@RequestParam("memId") String memId) {

        System.out.println("memId"+memId);

        int cnt = memberService.checkId(memId);

        return cnt;
    }*/
    }

}