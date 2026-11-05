package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.MensagemEncerramento;
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
    boolean isProgramaFuncionando = false;
    
    public void iniciarJogo() {
        
        //onde será mostrado o menu.
        isProgramaFuncionando = true;
        while(isProgramaFuncionando) {
            
            gerenciador.atualizarPalavraAtualListas();
            TelaJogo.mensagemJogoDaForca();
            
            menuOpcoes(sc);
           
            while(isRunning) {
                    
                    gerenciador.mostrarBoneco(dados);

                    gerenciador.mostrarPalavraTracejada();

                    char letraDigitada = entradaDados.entradaDados(sc);

                    gerenciador.verificarLetraNaPalavra(letraDigitada);

                    isRunning = gerenciador.encerrarRodada();
                    isProgramaFuncionando = gerenciador.encerrarPrograma();

                } // Fechamento Loop While

            } // Fechamento do método iniciarJogo().
        }
        
        
        
        
        
     
    
    public void menuOpcoes(Scanner sc) {
        TelaJogo.menuOpcoes();
        int opcaoDigitadaMenu = sc.nextInt();
        sc.nextLine();
        
        if(opcaoDigitadaMenu == 0) {
            
            isProgramaFuncionando = false;
            isRunning = false;
            MensagemEncerramento.exibirMensagemEncerramentoPrograma();
            
        }
        else if(opcaoDigitadaMenu == 1) {
            
            gerenciador.contagemRodada();
            isRunning = true;
        }
    }
} // Fechamento da classe.
