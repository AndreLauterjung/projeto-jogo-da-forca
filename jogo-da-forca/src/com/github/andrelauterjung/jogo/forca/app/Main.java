package com.github.andrelauterjung.jogo.forca.app;

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
        int quantidadeLetras = -1;
        int quantidadeErro = 0;
        
        boolean isLetraNaPalavra = false;
        boolean isRunning = false;
        
        
        palavras.add("Abobora");
        
        /* Atualiza palavra atual conforme o programa rode*/
        for(int i = 0; i < palavras.size(); i++) {
            
            palavraAtual = palavras.get(i).toLowerCase();
            quantidadeLetras = palavraAtual.length();
        }
        
        // System.out.println("Palavra atual: "+palavraAtual);
        
        

        // cada letra fica em uma posição do char: Exemplo: a[0], b[1], c[3]
        palavraArrayChar = new char[quantidadeLetras];

        for(int i= 0; i < palavraAtual.length(); i++) {

            /*A posição i, recebe o caracter da posição 1 da palavra*/
            palavraArrayChar[i] = palavraAtual.charAt(i);
            
        }

        for(int i= 0; i < palavraAtual.length(); i++) {

            /*A posição i, recebe o caracter da posição 1 da palavra*/
            palavraArrayChar[i] = palavraAtual.charAt(i);
        }
        
        
        //Até aqui, okay!
        
        
        
        
        palavraTracejadaChar = new char[quantidadeLetras];
        //Loop para fazer a palavra "tracejada": Exemplo: _ _ _ _ _ _ _
        for(int i = 0; i < palavraArrayChar.length; i++) {
            
            palavraTracejadaChar[i] = '_';
        }
        
        /*
        // Mostrar a palavra no array de char
        for(int i = 0; i < palavraArrayChar.length; i++) {
            
            System.out.println(palavraArrayChar[i]);
            
        } */
        
        
        
        isRunning = true;
        while(isRunning)
        {
            System.out.println("\n================ JOGO DA FORCA ===================");

            switch(quantidadeErro) {
                
                case 0:
                    System.out.println("Você tem 0 erros!");
                    break;
                    
                case 1: 
                    System.out.println("Você tem 1 erro!");
                    System.out.println("  O  ");
                    break;
                    
                case 2: 
                    System.out.println("Você tem 2 erros!");
                    System.out.println("  O  \n  |");
                    break;
                    
                case 3: 
                    System.out.println("Você tem 3 erros!");
                    System.out.println("  O  \n /|");
                    break;
                    
                case 4:
                    System.out.println("Você tem 4 erros: ");
                    System.out.println("  O  \n /|\\");
                    break;
                    
                case 5: 
                    System.out.println("Você tem 5 erros: ");
                    System.out.println("  O  \n /|\\ \n / ");
                    break;
                    
                case 6:
                    System.out.println("Você tem 6 erros!");
                    System.out.println("  O  \n /|\\ \n / \\");
                    
                    // mensagem encerramento programa
                    // fechamento do loop while
                    break;
            }

            

            // Mostrar as linhas tracejadas do array palavra tracejada char
            System.out.printf("\nPalavra: ");
            for(int i = 0; i < palavraArrayChar.length; i++) {

                System.out.printf("%c ", palavraTracejadaChar[i]);
            }


            System.out.println("\nDigite uma letra: ");
            char letraDigitada = sc.nextLine().charAt(0);

            for(int i = 0; i < palavraAtual.length(); i++) {

                /*Se na palavra contém a letra, substitui o _ pela letra digitada*/
                if(palavraArrayChar[i] == letraDigitada) {
                    
                    isLetraNaPalavra = true;
                    palavraTracejadaChar[i] = letraDigitada;
                    
                }
                else if(isLetraNaPalavra == false) {
                    
                    System.out.println("\nNão tem essa letra na palavra!");
                    quantidadeErro++;
                }
            }
            
            System.out.println("Quantidade de erros: "+quantidadeErro);
            
            
            System.out.printf("\nPalavra: ");
            for(int i = 0; i < palavraArrayChar.length; i++) {

                System.out.printf("%c ", palavraTracejadaChar[i]);
            }


            System.out.println("\n==================================================");
            System.out.println("Programa encerrado!");
            System.out.println("==================================================");
        }
        
    }
}
