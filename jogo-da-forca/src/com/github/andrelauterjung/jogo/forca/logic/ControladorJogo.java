package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.logic.GerenciadorPalavrasJogo;
import com.github.andrelauterjung.jogo.forca.logic.EntradaDados;
import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
import com.github.andrelauterjung.jogo.forca.view.MensagemEncerramento;
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
    int qtdErros = 0;
    

    
    public void iniciarJogo() {
        
        gerenciador.atualizarPalavraAtualListas();
        TelaJogo.mensagemJogoDaForca();
        isRunning = true;
        while(isRunning) {
            
            boolean isHaLetraTracejada;
            boolean isLetraNaPalavra = false;
            
            
            
            gerenciador.mostrarBoneco(dados);
            
            gerenciador.mostrarPalavraTracejada();
            
            char letraDigitada = entradaDados.entradaDados(sc);
            
            isLetraNaPalavra = gerenciador.verificarLetraNaPalavra(letraDigitada);
            
           
            if(isLetraNaPalavra == false) {
                System.out.println("A letra não está na palavra!");
               
                dados.setQuantidadeErros(++qtdErros);
            }
             
            
            isRunning = gerenciador.isEncerrarPrograma();
            
        }
        
        
      
    }
    
    
    
    
    
    
    
    
    
}
