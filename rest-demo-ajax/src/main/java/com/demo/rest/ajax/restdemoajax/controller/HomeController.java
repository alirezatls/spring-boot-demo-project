package com.demo.rest.ajax.restdemoajax.controller;

import com.demo.rest.ajax.restdemoajax.dto.HumanDto;
import com.demo.rest.ajax.restdemoajax.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    HumanService humanService;

    @GetMapping(path = "/home")
    public String showHome(Model model) {
         model.addAttribute("humans",humanService.findAllHuman());
        return "index";
    }

}
