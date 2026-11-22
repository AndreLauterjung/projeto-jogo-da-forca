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
    GerenciadorPartida gerenciador = new GerenciadorPartida(dados);
    
    Scanner sc = new Scanner(System.in);
    boolean isRodadaEmAndamento = false;
    boolean isProgramaFuncionando = false;
    
    public void iniciarJogo() {
        
        //onde será mostrado o menu.
        isProgramaFuncionando = true;
        while(isProgramaFuncionando) {
            
            gerenciador.atualizarPalavraAtualListas();
            TelaJogo.mensagemJogoDaForca();
            
            menuOpcoes(sc);
           
            while(isRodadaEmAndamento) {
                    
                    gerenciador.mostrarBoneco(dados);
                    
                    gerenciador.mostrarPalavra();
                    
                    char letraDigitada = entradaDados.lerLetra(sc);

                    gerenciador.verificarLetraNaPalavra(letraDigitada);

                    isRodadaEmAndamento = gerenciador.continuarRodada();
                    isProgramaFuncionando = gerenciador.continuarPrograma();

                } // Fechamento Loop While

            } // Fechamento do método iniciarJogo().
        }
        
        
        
        
        
     
    
    public void menuOpcoes(Scanner sc) {
        TelaJogo.menuOpcoes();
        int opcaoDigitadaMenu = sc.nextInt();
        sc.nextLine();
        
        if(opcaoDigitadaMenu == 0) {
            
            isProgramaFuncionando = false;
            isRodadaEmAndamento = false;
            MensagemEncerramento.exibirMensagemEncerramentoPrograma();
            
        }
        else if(opcaoDigitadaMenu == 1) {
            
            gerenciador.contagemRodada();
            isRodadaEmAndamento = true;
        }
    }
} // Fechamento da classe.
