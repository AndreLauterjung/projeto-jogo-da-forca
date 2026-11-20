package com.github.andrelauterjung.jogo.forca.app;

import com.github.andrelauterjung.jogo.forca.logic.ControladorJogo;

/**
 * Ponto de entrada do Jogo da Forca.
 * Cria o controlador do jogo e inicia a partida no console.
 *
 * @author andrelauterjung
 */
public class Main {
    
    /**
     * Inicia o programa.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        
        ControladorJogo partida = new ControladorJogo();

        partida.iniciarJogo();
    }
}
