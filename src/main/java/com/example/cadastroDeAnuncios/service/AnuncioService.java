package com.example.cadastroDeAnuncios.service;

import com.example.cadastroDeAnuncios.domain.Anuncio;
import com.example.cadastroDeAnuncios.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    public void salvarAnuncio(Anuncio anuncio){
        anuncioRepository.save(anuncio);
    }
}
