package com.example.cadastroDeAnuncios.controler;


import com.example.cadastroDeAnuncios.domain.Anuncio;
import com.example.cadastroDeAnuncios.domain.RelatorioFiltro;
import com.example.cadastroDeAnuncios.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Component
@RequestMapping
public class RelatorioControler {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping(path = "/relatorio")
    public String abrirRelatorio(@ModelAttribute("relatorioFilter") RelatorioFiltro filtro,
                                 Model model){

        List<Anuncio> anunciosCadastrados = relatorioService.listarAnuncios(filtro);
        model.addAttribute("anunciosCadastrados", anunciosCadastrados);

        model.addAttribute("filtro", filtro);

        return "relatoriohomepage";
    }
}
