package com.demo.security.securitydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(path = "/index")
    public String showInex() {
        return "index";
    }

    @GetMapping(path = "/view")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String showView() {
        return "view";
    }

    @GetMapping(path = "/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showAdimnPanel() {
        return "admin";
    }

    @GetMapping(path = "/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping(path = "/logout-succuss")
    public String logoutPage() {
        return "logout";
    }
}
