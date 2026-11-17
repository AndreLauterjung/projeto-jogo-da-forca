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
    StringBuilder letrasDigitadas = new StringBuilder();
    int contadorLetraErrada = 0;
    
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
        boolean letraJaDigitada = false;

        if(letrasDigitadas.indexOf(String.valueOf(letra)) >= 0) {
            letraJaDigitada = true;
        }
        
        /* Se a letra já foi digitada, não conta como erro. */
        if(letraJaDigitada) {
            
            System.out.println("A letra já foi digitada!");
        }
        /* se a letra não foi digitada, roda o else. 
        A letra é adicionada numa posição do char[] letrasDigitadas e o contador é incrementado
        O contador é incrementado para que cada letra fique em uma posição diferente.
        */ 
        else {
            letrasDigitadas.insert(contadorLetraErrada, letra);
            contadorLetraErrada++;
            
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

    
    /* Este método serve para mostrar as letras que o usuário já digitou em uma rodada.
    A letra digitada é incrementada na variável 'frase' e após o loop é mostrado o conteúdo da variável. */
    public void mostrarLetrasDigitadas() {
        
        System.out.println("\nLetras digitadas: "+letrasDigitadas);
    }
    
    /* Este método reseta a variável StringBuilder, fazendo com que limpe as letras já digitadas pelo usuário. */
    public void resetarLetrasDigitadas()  {
        
        letrasDigitadas.setLength(0);
    }
}
