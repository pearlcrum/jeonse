package com.jeonse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class signupController { /* signup 입력 값을 전달 받아옴 */

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    @PostMapping("/processSignup")
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
    }

}
