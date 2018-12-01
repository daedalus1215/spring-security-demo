package com.springsecurity.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }


    // Probably would put this in its own Controller or 'RequestHandler'.
    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    @RequestMapping("/systems")
    public String showManagers() {
        return "systems";
    }
}
