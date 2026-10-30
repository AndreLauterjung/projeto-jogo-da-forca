package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.view.TelaJogo;

import java.util.Scanner;
/**
 *
 * @author andrelauterjung
 */
public class EntradaDados {
    
    public char entradaDados(Scanner sc) {
        
        TelaJogo.mensagemDigitarLetra();
        char letraDigitada = sc.nextLine().toLowerCase().charAt(0);
        
        return letraDigitada;
    }
    
    
    
}
