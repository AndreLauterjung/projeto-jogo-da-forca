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
            
    // ********************************8
    public void mostrarPalavraTracejada() {
        
        mostrarLetrasJaDigitadas();
        palavraAtualArray.mostrarPalavraLinhaTracejada();
    }

    public void mostrarBoneco(DadosJogo dados) {
        
        tela.mostrarBoneco(dados.getQuantidadeErros());
    }

    /* Metodo que atualiza o número da rodada */
    public void contagemRodada() {
        int qtdPalavras = getLengthSizePalavras();
        
        if(qtdPalavras > 0) {
            ++this.numeroRodada;
            
            System.out.println(TelaJogo.mensagemRodada()+numeroRodada);
        }
    }
    
    public void mostrarLetrasJaDigitadas() {
        palavraAtualArray.mostrarLetrasDigitadas();
    }
    
    public boolean encerrarRodada() {
        boolean isProgramaEnd = true;
 
        /* SE não houver mais traços na palavra tracejada, ou seja, está com todas as letras preenchidas,
        a palavra atual é removida da lista de palavras e as variáveis são resetadas. */
        if(palavraAtualArray.isLetraTracejada() == false) {
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
            palavraAtualArray.contadorLetraErrada = 0;
            palavraAtualArray.letrasDigitadas = new char[25];
            isProgramaEnd = false;
            
        }
        
        return isProgramaEnd;
    }
    
    public void resetarPalavra() {
        if(palavraAtualArray.isLetraTracejada() == false) {
            mostrarPalavraTracejada();
            
            palavras.remove(0);
            dados.setPalavraAtual("");
            dados.zeraQuantidadeErros();
            dados.setQuantidadeLetras(0);
            palavraAtualArray.contadorLetraErrada = 0;
            palavraAtualArray.letrasDigitadas = new char[25];
        }
    }
    
    public boolean encerrarPrograma() {
        boolean encerrarProgramaGeral = true;
        
        int qtdPalavras = getLengthSizePalavras();
        
        if(qtdPalavras == 0) {
            
            MensagemEncerramento.exibirMensagemEncerramentoProgramaLimitePalavras();
            encerrarProgramaGeral = false;
        }
        return encerrarProgramaGeral;
    }
    
    /* Método Getter para retornar a quantidade de palavras na lista */
    public int getLengthSizePalavras() {
        
        return palavras.size();
    }
    
}
