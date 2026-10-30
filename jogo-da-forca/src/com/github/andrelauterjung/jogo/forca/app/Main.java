package com.github.andrelauterjung.jogo.forca.app;

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
        
        Scanner sc = new Scanner(System.in);
        
        // Listas
        ArrayList<String> palavras = new ArrayList<>();
        char palavraArrayChar[];
        char palavraTracejadaChar[];
        
        // Variáveis
        String palavraAtual = "";
        int quantidadeLetras = 0;
        int quantidadeErro = 0;

        boolean isRunning = false;
        
        
        palavras.add("Abobora");
        
        /* Atualiza palavra atual conforme o programa rode*/
        for(int i = 0; i < palavras.size(); i++) {
            
            palavraAtual = palavras.get(i).toLowerCase();
            quantidadeLetras = palavraAtual.length();
        }

        // cada letra fica em uma posição do char: Exemplo: a[0], b[1], c[3]
        palavraArrayChar = new char[quantidadeLetras];
        for(int i= 0; i < palavraAtual.length(); i++) {

            /* Cada letra da palavra é adicionada em uma posição do Array de Char. */
            palavraArrayChar[i] = palavraAtual.charAt(i);
        }
        
        
        palavraTracejadaChar = new char[quantidadeLetras];
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


            System.out.println("\nDigite uma letra: ");
            char letraDigitada = sc.nextLine().toLowerCase().charAt(0);

            for(int i = 0; i < palavraAtual.length(); i++) {

                /*Se na palavra contém a letra, substitui o _ pela letra digitada*/
                if(palavraArrayChar[i] == letraDigitada) {
                    
                    isLetraNaPalavra = true;
                    palavraTracejadaChar[i] = letraDigitada;  
                }
            }
            
            if(isLetraNaPalavra == false) {
                System.out.println("A letra não está na palavra!");
                quantidadeErro++;
            }
            
 
            switch(quantidadeErro) {
                
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
            
            for(int i = 0; i<palavraAtual.length(); i++) {
                
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
            else if(quantidadeErro ==6) {
                MensagemEncerramento.exibirMensagemEncerramentoPrograma();
                isRunning = false;
            }
            
        }

    }
}
