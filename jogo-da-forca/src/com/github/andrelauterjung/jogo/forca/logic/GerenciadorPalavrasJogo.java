package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.ListaPalavras;
import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
import com.github.andrelauterjung.jogo.forca.view.MensagemEncerramento;

import java.util.ArrayList;
/**
 *
 * @author andrelauterjung
 */
public class GerenciadorPalavrasJogo {
    
    TelaJogo tela = new TelaJogo();
    ListaPalavras listaPalavras = new ListaPalavras();
    
    private DadosJogo dados;
    private RodadaPalavra palavraAtual;
    private int numeroRodada = 0;
    
    public GerenciadorPalavrasJogo(DadosJogo dados) {
        this.dados = dados;
        this.palavraAtual = new RodadaPalavra(this.dados);
    }
        
    /* Essa lista foi criada, pois valores serão removidos durante o funcionamento do programa.
    Dessa forma, a listra principal não é alterada tornando mais fácil a adição ou remoção de palavras no jogo. */
    ArrayList<String> palavras = new ArrayList<>(listaPalavras.getListaPalavras());
    
    /* Atualiza palavra atual conforme as rodadas do jogo vão acontecendo. */
    public void atualizarPalavraAtualListas() {
        
        this.dados.setPalavraAtual(palavras.get(0).toLowerCase());
        this.dados.setQuantidadeLetras(this.dados.getPalavraAtual().length());
        
        palavraAtual.adicionarPalavraArrayChar();
        
        palavraAtual.adicionarPalavraTracejadaArray();

    }
    
    
    public void verificarLetraNaPalavra(char letra) {
        
        palavraAtual.processarLetra(letra);
    }
            
    
    public void mostrarPalavraTracejada() {
        
        mostrarLetrasJaDigitadas();
        mostrarPalavra();
    }
    
    
    public void mostrarLetrasJaDigitadas() {
        TelaJogo.mensagemLetrasDigitadas(palavraAtual.getLetrasDigitadas());
    }
    
    
    public void mostrarPalavra() {
        TelaJogo.textoPalavra();
        TelaJogo.mostrarPalavraLinhaTracejada(palavraAtual.getPalavraLinhaTracejada());
    }

    
    public void mostrarBoneco(DadosJogo dados) {
        
        tela.mostrarBoneco(dados.getQuantidadeErros());
    }

    /* Metodo que atualiza o número da rodada */
    public void contagemRodada() {
        int qtdPalavras = getSizePalavras();
        
        if(qtdPalavras > 0) {
            ++this.numeroRodada;
            
            System.out.println(TelaJogo.mensagemRodada()+numeroRodada);
        }
    }

    
    public boolean encerrarRodada() {
        boolean isProgramaEnd = true;
 
        /* SE não houver mais traços na palavra tracejada, ou seja, está com todas as letras preenchidas,
        a palavra atual é removida da lista de palavras e as variáveis são resetadas. */
        if(palavraAtual.temLetraFaltando() == false) {
            isProgramaEnd = false;
            resetarPalavra();
        }
        else if(dados.getQuantidadeErros() == 6)
        {
            tela.mostrarBoneco(dados.getQuantidadeErros());
            palavras.remove(0);
            dados.setPalavraAtual("");
            dados.zeraQuantidadeErros();
            dados.setQuantidadeLetras(0);
            palavraAtual.resetarLetrasDigitadas();
            isProgramaEnd = false;
            
        }
        
        return isProgramaEnd;
    }
    
    
    public void resetarPalavra() {
        if(palavraAtual.temLetraFaltando() == false) {
            mostrarPalavraTracejada();
            
            palavras.remove(0);
            dados.setPalavraAtual("");
            dados.zeraQuantidadeErros();
            dados.setQuantidadeLetras(0);
            palavraAtual.resetarLetrasDigitadas();
        }
    }
    
    
    public boolean encerrarPrograma() {
        boolean encerrarProgramaGeral = true;
        
        int qtdPalavras = getSizePalavras();
        
        if(qtdPalavras == 0) {
            
            MensagemEncerramento.exibirMensagemEncerramentoProgramaLimitePalavras();
            encerrarProgramaGeral = false;
        }
        return encerrarProgramaGeral;
    }
    
    
    /* Método Getter para retornar a quantidade de palavras na lista */
    public int getSizePalavras() {
        
        return palavras.size();
    }
    
}
