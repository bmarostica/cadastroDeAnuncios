package com.example.cadastroDeAnuncios;

public class Calculadora {



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
    public int visualiacoesTotais(int valorInvestido){

        int visualizacoes = visualizacoesOriginais(valorInvestido);
        int cliques = cliquesRecebidos(visualizacoes);
        int compartilhamentos = compartilhamentosRealizados(cliques);
        int visualiacoesDevidoACompartilhamento = novasVisualizacoes(compartilhamentos) * 30;

        int visualizacoesTotais = visualizacoes + visualiacoesDevidoACompartilhamento;

        return visualizacoesTotais;
    }
}