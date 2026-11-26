package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.ListaPalavras;
import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
import com.github.andrelauterjung.jogo.forca.view.MensagemEncerramento;
import java.util.ArrayList;

/**
 * Gerencia o fluxo da partida do Jogo da Forca, controlando as rodadas,
 * as palavras disponíveis, o processamento das tentativas do jogador
 * e o encerramento da partida.
 *
 * @author andrelauterjung
 */
public class GerenciadorPartida {
    
    private TelaJogo tela = new TelaJogo();
    private ListaPalavras listaPalavras = new ListaPalavras();
    
    private DadosJogo dados;
    private RodadaPalavra palavraAtual;
    private int numeroRodada = 0;
    
    
    /**
     * Cópia da lista principal de palavras, usada durante o jogo.
     * <p>
     * As palavras são removidas desta cópia a cada rodada, então a lista
     * original (ListaPalavras) não é alterada, e fica fácil adicionar ou
     * remover palavras do jogo.
     */
     private ArrayList<String> palavras = new ArrayList<>(this.listaPalavras.getListaPalavras());
    
    /**
     * Inicializa o gerenciador da partida com os dados do jogo.
     * Também instancia o objeto responsável pelo controle da palavra da rodada.
     *
     * @param dados informações utilizadas no gerenciamento da partida
     */
    public GerenciadorPartida(DadosJogo dados) {
        this.dados = dados;
        this.palavraAtual = new RodadaPalavra(this.dados);
    }

    
    
    
    /**
     * Atualiza a palavra atual com a primeira palavra disponível na lista,
     * define sua quantidade de letras e prepara os arrays de caracteres
     * utilizados para representar a palavra secreta e sua versão tracejada.
     */
    public void prepararNovaRodada() {
        
        this.dados.setPalavraAtual(this.palavras.get(0).toLowerCase());
        this.dados.setQuantidadeLetras(this.dados.getPalavraAtual().length());
        
        palavraAtual.adicionarPalavraArrayChar();
        
        palavraAtual.adicionarPalavraTracejadaArray();
    }
    
    
    /**
     * Verifica a letra digitada pelo jogador na palavra atual,
     * processando a tentativa e atualizando o estado da rodada.
     *
     * @param letra caractere informado pelo jogador
     */
    public void verificarLetraNaPalavra(char letra) {
        
        palavraAtual.processarLetra(letra);
    }
       
    
    /**
     * Exibe as letras já digitadas pelo jogador e a palavra atual da rodada,
     * representando as letras descobertas e as posições ainda não preenchidas
     * por meio de traços.
     */
    public void mostrarPalavra() {
        TelaJogo.mensagemLetrasDigitadas(palavraAtual.getLetrasDigitadas());
        
        TelaJogo.textoPalavra();
        TelaJogo.mostrarPalavraLinhaTracejada(palavraAtual.getPalavraLinhaTracejada());
    }

    
    /**
     * Exibe o boneco da forca de acordo com a quantidade de erros
     * acumulados pelo jogador na rodada atual.
     *
     * @param dados informações da partida utilizadas para obter a quantidade de erros
     */
    public void mostrarBoneco(DadosJogo dados) {
        
        this.tela.mostrarBoneco(dados.getQuantidadeErros());
    }

    
    /**
     * Atualiza o número da rodada e exibe sua identificação na tela.
     * <p>
     * A contagem é incrementada somente quando ainda existem palavras
     * disponíveis na lista de palavras do jogo.
     */
    public void contagemRodada() {
        
        int qtdPalavras = getQuantidadePalavras();
        
        if(qtdPalavras > 0) {
            
            ++this.numeroRodada;
            
            TelaJogo.mensagemRodada(numeroRodada);
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
            
            this.tela.mostrarBoneco(dados.getQuantidadeErros());
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
        
        this.palavras.remove(0);
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
        
        return this.palavras.size();
    }
    
}
