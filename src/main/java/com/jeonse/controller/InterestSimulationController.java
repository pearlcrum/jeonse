package com.jeonse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterestSimulationController {

        @GetMapping("/interestSimulation")
        public String interestSimulation() {
            return "interestSimulation";
        }
}


