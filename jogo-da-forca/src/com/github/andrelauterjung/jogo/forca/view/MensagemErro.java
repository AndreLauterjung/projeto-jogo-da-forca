package com.github.andrelauterjung.jogo.forca.view;

/**
 *
 * @author andrelauterjung
 */
public class MensagemErro {

    public static void mensagemLetraErrada() {
        
        LinhasDivisorias.exibirLinhaExclamacao();
        System.out.println("ERRO! A letra não está na palavra!");
        LinhasDivisorias.exibirLinhaExclamacao();
    }

    public static void erroEntradaDados() {
        
        System.out.println("\nX X X  ERRO!  X X X");
        System.out.println("Caractere inválido!");
        System.out.println("Tente novamente!");
    }
    


    
}
