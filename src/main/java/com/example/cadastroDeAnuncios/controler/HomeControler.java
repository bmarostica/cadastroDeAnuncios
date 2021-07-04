package com.example.cadastroDeAnuncios.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {

    @GetMapping("/")
    public String abrirHomePage(){
        return "homepage";
    }
}