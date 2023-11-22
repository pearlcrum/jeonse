package com.jeonse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class checkListController {
        @GetMapping("/checklist")
        public String checklist() {
            return "checklist";
        }
}
