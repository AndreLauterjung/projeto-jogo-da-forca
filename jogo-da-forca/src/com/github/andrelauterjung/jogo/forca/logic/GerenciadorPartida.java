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
public class GerenciadorPartida {
    
    TelaJogo tela = new TelaJogo();
    ListaPalavras listaPalavras = new ListaPalavras();
    
    private DadosJogo dados;
    private RodadaPalavra palavraAtual;
    private int numeroRodada = 0;
    
    public GerenciadorPartida(DadosJogo dados) {
        this.dados = dados;
        this.palavraAtual = new RodadaPalavra(this.dados);
    }
        
    /**
     * Cópia da lista principal de palavras, usada durante o jogo.
     * <p>
     * As palavras são removidas desta cópia a cada rodada, então a lista
     * original (ListaPalavras) não é alterada, e fica fácil adicionar ou
     * remover palavras do jogo.
     */
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
       
    
    public void mostrarLetrasJaDigitadas() {
        TelaJogo.mensagemLetrasDigitadas(palavraAtual.getLetrasDigitadas());
    }
    
    
    public void mostrarPalavra() {
        mostrarLetrasJaDigitadas();
        
        TelaJogo.textoPalavra();
        TelaJogo.mostrarPalavraLinhaTracejada(palavraAtual.getPalavraLinhaTracejada());
    }

    
    public void mostrarBoneco(DadosJogo dados) {
        
        tela.mostrarBoneco(dados.getQuantidadeErros());
    }

    /* Metodo que atualiza o número da rodada */
    public void contagemRodada() {
        int qtdPalavras = getQuantidadePalavras();
        
        if(qtdPalavras > 0) {
            ++this.numeroRodada;
            
            System.out.println(TelaJogo.mensagemRodada()+numeroRodada);
        }
    }
    

    
    /**
     * Verifica se a rodada atual deve continuar ou ser encerrada.
     * <ul>
     * <li>Se todas as letras da palavra forem descobertas, exibe a palavra
     * completa e encerra a rodada.</li>
     * <li>Se o jogador atingir o limite de 6 erros, exibe o boneco e encerra
     * a rodada.</li>
     * <li>Caso nenhuma dessas condições seja atendida, a rodada continua.</li>
     * </ul>
     * Ao encerrar a rodada, realiza a limpeza dos dados e remove a palavra
     * utilizada da lista de palavras disponíveis.
     *
     * @return true se a rodada deve continuar ou false se foi encerrada
     */
    public boolean continuarRodada() {
        
        if(palavraAtual.temLetraFaltando() == false) {
            
            mostrarPalavra();
            resetar();
            return false;
        }
        else if(dados.getQuantidadeErros() == 6) {
            
            tela.mostrarBoneco(dados.getQuantidadeErros());
            resetar();
            return false;        
        }
        else {
            
            return true;
        }
    }
    
    
    /**
     * Reinicializa os dados da rodada atual, limpando a palavra, a quantidade
     * de erros e a quantidade de letras.
     * <p>
     * Também reseta os atributos de RodadaPalavra e remove a palavra utilizada
     * da lista de palavras disponíveis.
     */
    public void resetar() {
        
        palavraAtual.resetar();
        dados.setPalavraAtual("");
        dados.zeraQuantidadeErros();
        dados.setQuantidadeLetras(0);
        removePalavraAtual();
    }
    
    
    /**
     * Remove a primeira palavra da lista de palavras disponíveis,
     * descartando a palavra utilizada na rodada atual.
     */
    public void removePalavraAtual() {
        
        palavras.remove(0);
    }
    
    
    /**
     * Verifica se ainda existem palavras disponíveis para continuar a execução
     * do programa.
     * <p>
     * Caso não existam palavras restantes, exibe a mensagem de encerramento
     * por limite de palavras e interrompe a execução.
     *
     * @return true se ainda houver palavras disponíveis ou false caso contrário
     */
    public boolean continuarPrograma() {
        
        int qtdPalavras = getQuantidadePalavras();
        
        if(qtdPalavras == 0) {
            
            MensagemEncerramento.exibirMensagemEncerramentoProgramaLimitePalavras();
            return false;
        }
        else {
            
            return true;
        }
    }
    
    
    /**
     * Retorna a quantidade de palavras que ainda restam na lista do jogo.
     *
     * @return o número de palavras restantes na lista
     */
    public int getQuantidadePalavras() {
        
        return palavras.size();
    }
    
}
