package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
import java.util.Scanner;
/**
 *
 * @author andrelauterjung
 */
public class ControladorJogo
{
    DadosJogo dados = new DadosJogo();
    EntradaDados entradaDados = new EntradaDados();
    GerenciadorPalavrasJogo gerenciador = new GerenciadorPalavrasJogo(dados);
    
    Scanner sc = new Scanner(System.in);
    boolean isRunning = false;
    

    
    public void iniciarJogo() {
        
        
        gerenciador.atualizarPalavraAtualListas();
        TelaJogo.mensagemJogoDaForca();
        
        isRunning = true;
        while(isRunning) {
            
            gerenciador.mostrarBoneco(dados);
            
            gerenciador.mostrarPalavraTracejada();
            
            char letraDigitada = entradaDados.entradaDados(sc);
            
            gerenciador.verificarLetraNaPalavra(letraDigitada);
             
            isRunning = gerenciador.isEncerrarPrograma();
            
        } // Fechamento Loop While

    } // Fechamento do método iniciarJogo().
     
} // Fechamento da classe.
