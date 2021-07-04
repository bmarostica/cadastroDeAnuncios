package com.example.cadastroDeAnuncios.service;


import com.example.cadastroDeAnuncios.domain.Anuncio;
import com.example.cadastroDeAnuncios.domain.RelatorioFiltro;
import com.example.cadastroDeAnuncios.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    public List<Anuncio> listarAnuncios(RelatorioFiltro filtro){

        String nomeDoCliente = filtro.getNomeCliente();
        LocalDate dataInicio = filtro.getDataInicio();
        LocalDate dataFim = filtro.getDataFim();

        if(nomeDoCliente != null && !nomeDoCliente.equals("")){
            return anuncioRepository.findByNomeCliente(nomeDoCliente);
        }

        if(dataInicio != null){
            return anuncioRepository.findbyDataInicio(dataInicio);
        }

        if(dataFim != null){
            return anuncioRepository.findbyDataFim(dataFim);
        }

        return anuncioRepository.findAll();
    }
}
