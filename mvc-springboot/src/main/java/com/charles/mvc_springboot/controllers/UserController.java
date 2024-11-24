package com.charles.mvc_springboot.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    //PASAR DATOS A LA VISTA USANDO MAP
    // @GetMapping("/")
    // public String index(Map<String, Object> model) {
    //     model.put("title", "HOLA MUNDO JAVA MVC SPRINGBOOT CON MAP");
    //     model.put("name", "Charles");
    //     model.put("lastname", "Thenoux");
    //     model.put("wellcomeMessage", "Bienvenido al curso de SpringBoot");
    //     return "index";
    // }
    

    // PASAR DATOS A LA VISTA USANDO MODEL
    @GetMapping("/")
    public String index( Model model) {
        model.addAttribute("title", "HOLA MUNDO JAVA MVC SPRINGBOOT");
        model.addAttribute("name", "Charles");
        model.addAttribute("lastname", "Thenoux");
        model.addAttribute("wellcomeMessage", "Bienvenido al curso de SpringBoot");
        return "index";
    }

}
