package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
/**
 *
 * @author andrelauterjung
 */
public class PalavraAtualArray {
    
    private DadosJogo dados;
    char[] palavraArrayChar;
    char[]  palavraTracejadaChar;

    
    public PalavraAtualArray(DadosJogo dados) {
        this.dados = dados;
    }
    
    public void adicionarPalavraArrayChar() {
        
        palavraArrayChar = new char[this.dados.getQuantidadeLetras()];
        /* Cada letra da palavra é adicionada em uma posição do Array de Char. */
        for(int i= 0; i < this.dados.getPalavraAtual().length(); i++) {

            palavraArrayChar[i] = this.dados.getPalavraAtual().charAt(i);
        }
    }
    
     public void adicionarPalavraTracejadaArray() {
        
        palavraTracejadaChar = new char[dados.getQuantidadeLetras()];
        //Loop para fazer a palavra "tracejada": Exemplo: _ _ _ _ _ _ _
        for(int i = 0; i < dados.getPalavraAtual().length(); i++) {
            
            palavraTracejadaChar[i] = '_';
        }
    }
    
    public void mostrarPalavraLinhaTracejada() {
         /* Este loop serve para mostrar palavra atual de forma tracejada (exemplo: _ _ _ _ _ _ _)*/
            System.out.printf("\nPalavra: ");
            for(int i = 0; i < dados.getPalavraAtual().length(); i++)
            {
                System.out.printf("%c ", palavraTracejadaChar[i]);
            }
            System.out.println("");
    }
   
    public boolean isLetraAtualPalavra(char letra) {
        boolean isLetraNaPalavra = false;
        
        for(int i = 0; i < dados.getPalavraAtual().length(); i++) {
            
            if(palavraArrayChar[i] == letra) {
                
                palavraTracejadaChar[i] = letra;
                isLetraNaPalavra = true;
            }
        }
        return isLetraNaPalavra;
    }
    
    public boolean isLetraTracejada() {
        boolean isLetraTracejada = false;
        
        for(int i = 0; i < dados.getPalavraAtual().length(); i++) {
            
            if(palavraTracejadaChar[i] == '_')
            {
                isLetraTracejada = true;
            } 
        }
        return isLetraTracejada;
    }

}
