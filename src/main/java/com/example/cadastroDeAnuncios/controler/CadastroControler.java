package com.example.cadastroDeAnuncios.controler;

import com.example.cadastroDeAnuncios.domain.Anuncio;
import com.example.cadastroDeAnuncios.service.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
@Component
public class CadastroControler {

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping(path = "/cadastro")
    public String novoCadastro(Model model){
        model.addAttribute("anuncio", new Anuncio());
        return "cadastrohomepage";
    }

    @PostMapping(path = "/cadastro/save")
    public String cadastrarAnuncio(@ModelAttribute("anuncio") @Valid Anuncio anuncio,
                                   Errors errors,
                                   Model model){

        if(!errors.hasErrors()){
            anuncioService.salvarAnuncio(anuncio);
            model.addAttribute("anuncio", new Anuncio());
            return "cadastrohomepage";
        }

        return "cadastrohomepage";
    }
}
