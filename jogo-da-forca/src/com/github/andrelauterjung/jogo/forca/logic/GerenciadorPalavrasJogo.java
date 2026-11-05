package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.ListaPalavras;
import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
import java.util.Scanner;

import java.util.ArrayList;
/**
 *
 * @author andrelauterjung
 */
public class GerenciadorPalavrasJogo {
    
    TelaJogo tela = new TelaJogo();
    ListaPalavras listaPalavras = new ListaPalavras();
    
    private DadosJogo dados;
    private PalavraAtualArray palavraAtualArray;
    private int numeroRodada = 0;
    
    public GerenciadorPalavrasJogo(DadosJogo dados) {
        this.dados = dados;
        this.palavraAtualArray = new PalavraAtualArray(this.dados);
    }
        
    /* Essa lista foi criada, pois valores serão removidos durante o funcionamento do programa.
    Dessa forma, a listra principal não é alterada tornando mais fácil a adição ou remoção de palavras no jogo. */
    ArrayList<String> palavras = new ArrayList<>(listaPalavras.getListaPalavras());
    
    /* Atualiza palavra atual conforme as rodadas do jogo vão acontecendo. */
    public void atualizarPalavraAtualListas() {
        
        this.dados.setPalavraAtual(palavras.get(0).toLowerCase());
        this.dados.setQuantidadeLetras(this.dados.getPalavraAtual().length());
        
        palavraAtualArray.adicionarPalavraArrayChar();
        
        palavraAtualArray.adicionarPalavraTracejadaArray();

    }
    
    public void verificarLetraNaPalavra(char letra) {
        
        palavraAtualArray.isLetraAtualPalavra(letra);
    }
            
    public void mostrarPalavraTracejada() {
        palavraAtualArray.mostrarPalavraLinhaTracejada();
    }

    public void mostrarBoneco(DadosJogo dados) {
        
        tela.mostrarBoneco(dados.getQuantidadeErros());
    }

    /* Metodo que atualiza o número da rodada */
    public void contagemRodada() {
        int qtdPalavras = getLengthSizePalavras();
        
        if(qtdPalavras > 0) {
            ++numeroRodada;
            
            System.out.println(TelaJogo.mensagemRodada()+numeroRodada);
        }
    }
    
    public boolean isEncerrarPrograma() {
        boolean isProgramaEnd = true;
        
        if(palavraAtualArray.isLetraTracejada() == false) {
            mostrarPalavraTracejada();
            isProgramaEnd = false;
        }
        else if(dados.getQuantidadeErros() == 6)
        {
            tela.mostrarBoneco(dados.getQuantidadeErros());
            isProgramaEnd = false;
        }
        return isProgramaEnd;
    }
    
    /* Método Getter para retornar a quantidade de palavras na lista */
    public int getLengthSizePalavras() {
        
        return palavras.size();
    }
    
}
