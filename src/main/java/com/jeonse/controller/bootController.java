package com.jeonse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@Slf4j
public class bootController {

    @GetMapping("")
    public String index(Model model, @RequestParam("inputEmail") Optional<String> inputEmail,
                        @RequestParam("inputPassword") Optional<String>  inputPassword){
        if (inputEmail.isPresent() && inputPassword.isPresent()) {
            model.addAttribute("inputEmail", inputEmail.get());
            model.addAttribute("inputPassword", inputPassword.get());
        }
        return "index";
    }

}
