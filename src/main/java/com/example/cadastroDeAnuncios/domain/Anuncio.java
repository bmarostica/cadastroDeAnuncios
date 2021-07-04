package com.example.cadastroDeAnuncios.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Anuncio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column
    private Integer id;

    @Column
    @NotBlank(message = "Nome do anúncio é obrigatório")
    private String nomeAnuncio;

    @Column
    @NotBlank(message = "Nome do cliente é obrigatório")
    private String cliente;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data inicial é obrigatória")
    private LocalDate dataInicio;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data final é obrigatória")
    private LocalDate dataFim;

    @Column
    @NotNull(message = "Valor do investimento é obrigatório")
    private BigDecimal investimentoDiario;

    /* Calcula o número de visualizações de acordo com o valor investido */
    public int visualizacoesOriginais (int valorInvestido){
        int visualizacoes = valorInvestido * 30;
        return visualizacoes;
    }

    /*Calcula o npumero de cliques com base nas visualizações*/
    public int cliquesRecebidos (int visualiazacoes) {
        int numeroDeCliques = (visualiazacoes * 12) / 100;
        return numeroDeCliques;
    }

    /* Calcula o número de compartilhamentos com base no número de cliques.*/
    public int compartilhamentosRealizados(int cliques){
        int qtdDeCompartilhamentos = (cliques * 3) / 20;
        return qtdDeCompartilhamentos;
    }

    /*Calcula o número de novas visualizações com base na quantidade de compartilhamentos*/
    public int novasVisualizacoes(int compartilhamentos){
        int visualizacoes;

        if(compartilhamentos == 1){
            visualizacoes = 40;
        }
        else if (compartilhamentos == 2) {
            visualizacoes = 80;
        }
        else {
            visualizacoes = 120;
        }

        return visualizacoes;
    }

    /*Número total de visualiacões com base no valor total investido*/
    public int visualizacoesTotais(){

        int visualizacoes = visualizacoesOriginais(investimentoTotal());
        int cliques = cliquesRecebidos(visualizacoes);
        int compartilhamentos = compartilhamentosRealizados(cliques);
        int visualiacoesDevidoACompartilhamento = novasVisualizacoes(compartilhamentos) * 30;

        int visualizacoesTotais = visualizacoes + visualiacoesDevidoACompartilhamento;

        return visualizacoesTotais;
    }

    public int investimentoTotal(){
        int diasAnunciados = Period.between(dataInicio, dataFim).getDays();
        return diasAnunciados * investimentoDiario.intValue();
    }

    public int totalDeCliques(){
        return (visualizacoesTotais()/100 * 12);
    }

    public int totalCompartilhamentos(){
        return (totalDeCliques() /20 * 3);
    }

}