package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.view.MensagemErro;
import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
/**
 *
 * @author andrelauterjung
 */
public class PalavraAtualArray {
    
    MensagemErro mensagemErro = new MensagemErro();
    
    private DadosJogo dados;
    private StringBuilder letrasDigitadas;
    private char[] palavraArrayChar;
    private char[]  palavraTracejadaChar;
    
    public PalavraAtualArray(DadosJogo dados) {
        
        this.dados = dados;
        this.letrasDigitadas = new StringBuilder();
        this.palavraArrayChar = new char[0];
        this.palavraTracejadaChar = new char[0];
    }
    
    
    /**
     * Prepara o array de caracteres da palavra secreta da rodada,
     * copiando cada letra da palavra atual (obtida na classe DadosJogo).
     * Deve ser chamado sempre que uma nova palavra for sorteada ou carregada.
     */
    public void adicionarPalavraArrayChar() {
        
        this.palavraArrayChar = new char[this.dados.getQuantidadeLetras()];
        
        for(int i = 0; i < this.dados.getPalavraAtual().length(); i++) {

            palavraArrayChar[i] = this.dados.getPalavraAtual().charAt(i);
        }
    }
    
    
    /**
     * Prepara a palavra tracejada da rodada, com um traço (_) para cada letra
     * da palavra atual. Exemplo: "abobora" vira _ _ _ _ _ _ _.
     * Deve ser chamado junto com adicionarPalavraArrayChar(), no início de cada rodada.
     */
    public void adicionarPalavraTracejadaArray() {
        
        this.palavraTracejadaChar = new char[this.dados.getQuantidadeLetras()];
        
        for(int i = 0; i < this.dados.getPalavraAtual().length(); i++) {
            
            palavraTracejadaChar[i] = '_';
        }
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
        boolean isLetraErrada = true;
        boolean letraJaDigitada = false;

        if(this.letrasDigitadas.indexOf(String.valueOf(letra)) >= 0) {
            letraJaDigitada = true;
        }
        
        /* Se a letra já foi digitada, não conta como erro. */
        if(letraJaDigitada) {
            
            TelaJogo.avisoLetraJaDigitada();
        }
        /* se a letra não foi digitada, roda o else. 
        A letra é adicionada numa posição do char[] letrasDigitadas e o contador é incrementado
        O contador é incrementado para que cada letra fique em uma posição diferente.
        */ 
        else {
            
            this.letrasDigitadas.append(letra);
            
            for(int i = 0; i < this.dados.getPalavraAtual().length(); i++) {

                if(this.palavraArrayChar[i] == letra) {

                    isLetraErrada = false;
                    this.palavraTracejadaChar[i] = letra;
                }
            }
            if(isLetraErrada) {
                mensagemErro.mensagemLetraErrada();
                this.dados.atualizaQuantidadeErros(1);
            }
        }
    }
    
    
    /**
     * Indica se a palavra ainda tem letras não descobertas (traços).
     *
     * @return true se ainda houver algum traço, false se a palavra estiver completa
     */
    public boolean temLetraFaltando() {

        for(char caractere: this.palavraTracejadaChar) {
            
            if(caractere == '_') {
                
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Limpa as letras digitadas na rodada atual.
     * Deve ser chamado ao encerrar uma rodada, para que a próxima comece sem letras.
     */
    public void resetarLetrasDigitadas()  {
        
        this.letrasDigitadas.setLength(0);
    }
    
    
    /**
     * Retorna as letras que o usuário já digitou na rodada atual,
     * na ordem em que foram digitadas.
     *
     * @return as letras digitadas, ou uma String vazia se ainda não houve tentativa
     */
    public String getLetrasDigitadas() {
        
        return this.letrasDigitadas.toString();
    }
    
    
    /**
     * Retorna a palavra da rodada no estado atual, com as letras já descobertas e traços (_) no lugar das que faltam,
     * separados por espaço. 
     * 
     * Exemplo: " a b o b o _ a ".
     *  
     * @return a palavra tracejada como String.
     */
    public String getPalavraLinhaTracejada() {

         StringBuilder palavra = new StringBuilder();
         
            for(int i = 0; i < this.dados.getPalavraAtual().length(); i++)
            {
                palavra.append(this.palavraTracejadaChar[i]).append(" ");
            }
            return palavra.toString();
    }
   
}
