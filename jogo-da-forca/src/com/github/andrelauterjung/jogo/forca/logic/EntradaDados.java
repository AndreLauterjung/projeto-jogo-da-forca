package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.view.MensagemErro;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
import java.util.Scanner;

/**
 * Responsável por ler a entrada do usuário no console durante o jogo.
 * Valida o que foi digitado e só devolve uma letra válida,
 * pedindo novamente enquanto a entrada for inválida.
 *
 * @author andrelauterjung
 */
public class EntradaDados {
    
    /**
     * Lê uma letra digitada pelo usuário.
     * Espaços nas pontas são ignorados e a letra é convertida para minúscula.
     * Se a entrada estiver vazia, tiver mais de um caractere ou não for uma letra,
     * exibe uma mensagem de erro e pede novamente.
     *
     * @param sc o Scanner usado para ler a entrada do console
     * @return a letra válida digitada, em minúscula
     */
    public char lerLetra(Scanner sc) {
        
        char letra = ' ';
        boolean isInvalido = true;
        
        while(isInvalido) {
            
            TelaJogo.mensagemDigitarLetra();
            String letraDigitadaUsuario = sc.nextLine().trim().toLowerCase();

            if(letraDigitadaUsuario.length() == 1 && Character.isLetter(letraDigitadaUsuario.charAt(0))) {
                
                isInvalido = false;
                letra = letraDigitadaUsuario.charAt(0);
            }
            else {
                
                MensagemErro.erroEntradaDados();
            }
        }
        return letra;
    }
}
