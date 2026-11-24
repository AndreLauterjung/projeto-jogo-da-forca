package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.MensagemEncerramento;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
import java.util.Scanner;
import java.util.InputMismatchException;
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
            
            gerenciador.prepararNovaRodada();
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
        
        boolean entradaInvalida = true;
        
        while(entradaInvalida) {
            
            try {
            
                TelaJogo.menuOpcoes();
                int opcaoDigitadaMenu = sc.nextInt();
                sc.nextLine();

                if(opcaoDigitadaMenu == 0) {
                    
                    entradaInvalida = false;
                    isProgramaFuncionando = false;
                    isRodadaEmAndamento = false;
                    MensagemEncerramento.exibirMensagemEncerramentoPrograma();

                }
                else if(opcaoDigitadaMenu == 1) {

                    entradaInvalida = false;
                    gerenciador.contagemRodada();
                    isRodadaEmAndamento = true;
                }
                else {
                    System.out.println("Opção inválida! Digite 0 ou 1.");
                    entradaInvalida = true;
                }
            }
            catch(InputMismatchException inputMismatchException) {
                System.out.println("Você precisa digitar um número!");
                sc.next();
            }
        }
    } // Fechamento do método
    
} // Fechamento da classe.
