package com.github.andrelauterjung.jogo.forca.app;

import com.github.andrelauterjung.jogo.forca.logic.EntradaDados;
import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.LinhasDivisorias;
import com.github.andrelauterjung.jogo.forca.view.MensagemEncerramento;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author andrelauterjung
 */
public class Main {
    
    public static void main(String[] args) {
        
        EntradaDados entradaDados = new EntradaDados();
        DadosJogo dados = new DadosJogo();
        Scanner sc = new Scanner(System.in);
        
        // Listas
        ArrayList<String> palavras = new ArrayList<>();
        char palavraArrayChar[];
        char palavraTracejadaChar[];
        
        // Variáveis
        boolean isRunning = false;
        int qtdErros = 0;
        
        palavras.add("Abobora");
        
        /* Atualiza palavra atual conforme o programa rode*/
        for(int i = 0; i < palavras.size(); i++) {
            
            dados.setPalavraAtual(palavras.get(i).toLowerCase());
            dados.setQuantidadeLetras(dados.getPalavraAtual().length());
        }

        palavraArrayChar = new char[dados.getQuantidadeLetras()];
        /* Cada letra da palavra é adicionada em uma posição do Array de Char. */
        for(int i= 0; i < dados.getPalavraAtual().length(); i++) {

            palavraArrayChar[i] = dados.getPalavraAtual().charAt(i);
        }
        
        
        palavraTracejadaChar = new char[dados.getQuantidadeLetras()];
        //Loop para fazer a palavra "tracejada": Exemplo: _ _ _ _ _ _ _
        for(int i = 0; i < palavraArrayChar.length; i++) {
            
            palavraTracejadaChar[i] = '_';
        }
        
        
        
        System.out.println("\n================ JOGO DA FORCA ===================");
        isRunning = true;
        while(isRunning)
        {
            boolean isHaLetraTracejada = false;
            boolean isLetraNaPalavra = false;
            
            
            
            /* Este loop serve para mostrar palavra atual de forma tracejada (exemplo: _ _ _ _ _ _ _)*/
            System.out.printf("\nPalavra: ");
            for(int i = 0; i < palavraArrayChar.length; i++)
            {
                System.out.printf("%c ", palavraTracejadaChar[i]);
            }
            System.out.println("");


            // Aqui ficava a entrada de dados da classe Main (Comentário para facilitar a minha localização durante o código)
            char letraDigitada = entradaDados.entradaDados(sc);

            for(int i = 0; i < dados.getQuantidadeLetras(); i++) {

                /*Se na palavra contém a letra, substitui o _ pela letra digitada*/
                if(palavraArrayChar[i] == letraDigitada) {
                    
                    isLetraNaPalavra = true;
                    palavraTracejadaChar[i] = letraDigitada;  
                }
            }
            
            
            if(isLetraNaPalavra == false) {
                System.out.println("A letra não está na palavra!");
                
                //qtdErros++;
                dados.setQuantidadeErros(++qtdErros);
            }
 
            switch(dados.getQuantidadeErros()) {
                
                case 0:
                    break;
                    
                case 1:
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    System.out.println("Você tem 1 erro!");
                    System.out.println("  O  ");
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    break;
                    
                case 2: 
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    System.out.println("Você tem 2 erros!");
                    System.out.println("  O  \n  |");
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    break;
                    
                case 3:
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    System.out.println("Você tem 3 erros!");
                    System.out.println("  O  \n /|");
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    break;
                    
                case 4:
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    System.out.println("Você tem 4 erros: ");
                    System.out.println("  O  \n /|\\");
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    break;
                    
                case 5: 
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    System.out.println("Você tem 5 erros: ");
                    System.out.println("  O  \n /|\\ \n / ");
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    break;
                    
                case 6:
                    LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
                    System.out.println("Você tem 6 erros!");
                    System.out.println("  O  \n /|\\ \n / \\");
                    break;
            }
            
            for(int i = 0; i<dados.getPalavraAtual().length(); i++) {
                
                if(palavraTracejadaChar[i] == '_')
                {
                     isHaLetraTracejada = true;
                }
            }
            
            if(!isHaLetraTracejada) {
                
                System.out.printf("\nPalavra: ");
                for(int i = 0; i < palavraArrayChar.length; i++)
                {
                    System.out.printf("%c ", palavraTracejadaChar[i]);
                }
                System.out.println("");
                
                MensagemEncerramento.exibirMensagemEncerramentoPrograma();
                isRunning = false;
            }
            else if(dados.getQuantidadeErros() ==6) {
                MensagemEncerramento.exibirMensagemEncerramentoPrograma();
                isRunning = false;
            }
            
        }

    }
}
