package com.example.cadastroDeAnuncios.repository;

import com.example.cadastroDeAnuncios.domain.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

    @Query("SELECT a FROM Anuncio a WHERE a.cliente = ?1")
    List<Anuncio> findByNomeCliente (String nomeCliente);

    @Query("SELECT a FROM Anuncio a WHERE a.dataInicio >= ?1")
    List<Anuncio> findbyDataInicio(LocalDate dataInicial);

    @Query("SELECT a FROM Anuncio a WHERE a.dataFim <= ?1")
    List<Anuncio> findbyDataFim(LocalDate dataFim);
}
