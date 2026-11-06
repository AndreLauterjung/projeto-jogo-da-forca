package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.view.MensagemErro;
import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
/**
 *
 * @author andrelauterjung
 */
public class PalavraAtualArray {
    
    MensagemErro mensagemErro = new MensagemErro();
    
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
   
    /* Método onde substitui uma linha tracejada pela letra.
    
    Como funciona: 
    
    SE uma letra for igual a letra da posição i de uma palavra, como a palavra é a mesma palavra da linha
    tracejada (_ _ _ _...) vai substituir o _ referente a posição da letra na palavra. 
    
    SE a letra estiver na posição 3 de uma palavra, o terceiro traço vai ser substituido pela letra.
    
    SE a letra digitada pelo usuário estiver na palavra, a variável boolean "letraErrada" muda o valor para false, pois
    não foi digitada uma letra errada. 
    
    Porém, se o usuário digitar uma letra errada, o valor da variável boolean "letraErrada" continua true, e essa
    variável será utilizada para contar ou não erros.
    
    SE ele digitar uma letra errada, ou seja, a letra digitada não está na palavra, "letraErrada" continua true.
    SE "letraErrada" for true, é incrementado + 1 na quantidade de erros.
    
    */
    public void isLetraAtualPalavra(char letra) {
        boolean letraErrada = true;
        
        for(int i = 0; i < dados.getPalavraAtual().length(); i++) {

            if(palavraArrayChar[i] == letra) {
                
                letraErrada = false;
                palavraTracejadaChar[i] = letra;
            }
        }
        
        if(letraErrada) {
            mensagemErro.mensagemLetraErrada();
            dados.atualizaQuantidadeErros(1);
        }
    }
    
    /* SE não tiver letra tracejada, retorna False
    SE tiver alguma letra tracejada, retorna True
    
    Método utilizado para parar o loop e encerrar quando não houver mais linhas tracejadas
    */
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
