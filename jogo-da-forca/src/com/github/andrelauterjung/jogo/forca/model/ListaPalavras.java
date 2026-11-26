package com.github.andrelauterjung.jogo.forca.model;

import java.util.ArrayList;

/**
 * Armazena e fornece o banco de palavras utilizado nas partidas do Jogo da
 * Forca.
 * <p>
 * Contém uma coleção pré-definida de 26 palavras em português (uma para cada
 * letra do alfabeto, de A a Z), escritas sem acentuação gráfica ou cedilha para
 * facilitar a validação das tentativas no console.
 *
 * @author andrelauterjung
 */
public class ListaPalavras {

    private ArrayList<String> listaPalavras;

    /**
     * Inicializa a lista e a preenche com o conjunto padrão de 26 palavras
     * disponíveis para sorteio nas rodadas do jogo.
     */
    public ListaPalavras() {
        this.listaPalavras = new ArrayList<>();

        listaPalavras.add("abobora");
        listaPalavras.add("bandeira");
        listaPalavras.add("computador");
        listaPalavras.add("dentista");
        listaPalavras.add("escalada");
        listaPalavras.add("framboesa");
        listaPalavras.add("guitarra");
        listaPalavras.add("helicoptero");
        listaPalavras.add("isqueiro");
        listaPalavras.add("jacare");
        listaPalavras.add("karaoke");
        listaPalavras.add("limonada");
        listaPalavras.add("macarrao");
        listaPalavras.add("navio");
        listaPalavras.add("orelha");
        listaPalavras.add("paralelepipedo");
        listaPalavras.add("queijo");
        listaPalavras.add("ratoeira");
        listaPalavras.add("salsicha");
        listaPalavras.add("tatuagem");
        listaPalavras.add("umidecido");
        listaPalavras.add("vassoura");
        listaPalavras.add("web");
        listaPalavras.add("xicara");
        listaPalavras.add("yakisoba");
        listaPalavras.add("zumbi");
    }

    /**
     * Retorna a lista completa de palavras cadastradas para o jogo.
     *
     * @return um ArrayList do tipo String contendo todas as palavras
     * disponíveis.
     */
    public ArrayList<String> getListaPalavras() {
        return this.listaPalavras;
    }

}
