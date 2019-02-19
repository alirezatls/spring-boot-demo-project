package com.demo.rest.ajax.restdemoajax.rest;

import com.demo.rest.ajax.restdemoajax.db.tables.Human;
import com.demo.rest.ajax.restdemoajax.dto.HumanDto;
import com.demo.rest.ajax.restdemoajax.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HumanController {

    @Autowired
    HumanService humanService;

    @GetMapping(path = "api/demo/humans")
    public List<HumanDto> showAllHuman() {
        return humanService.findAllHuman();
    }

    @GetMapping(path = "api/demo/humans/{id}")
    public HumanDto showHumanById(@PathVariable int id) {
        return humanService.findHumanById(id);
    }

    @GetMapping(path = "api/demo/humans/delete/{id}")
    public int DeleteHumanById(@PathVariable int id) {
        return humanService.deleteHumanById(id);
    }
}
