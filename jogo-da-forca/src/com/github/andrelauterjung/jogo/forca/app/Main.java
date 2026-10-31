package com.github.andrelauterjung.jogo.forca.app;

import com.github.andrelauterjung.jogo.forca.logic.EntradaDados;
import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
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
        TelaJogo telaInfos = new TelaJogo();
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
        
        TelaJogo.mensagemJogoDaForca();
        
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
 
            telaInfos.mostrarBoneco(dados.getQuantidadeErros());
            
            
            // Mostrar como a palavra está após o usuário digitar uma letra
            for(int i = 0; i<dados.getPalavraAtual().length(); i++) {
                
                if(palavraTracejadaChar[i] == '_')
                {
                     isHaLetraTracejada = true;
                }
            }
            
            // Se não há mais linhas tracejadas, a palavra está completa.
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
            // Se ele chegou aos 6 erros, o programa para.
            else if(dados.getQuantidadeErros() ==6) {
                MensagemEncerramento.exibirMensagemEncerramentoPrograma();
                isRunning = false;
            }
            
        }

    }
}
