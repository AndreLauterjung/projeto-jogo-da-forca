package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.ListaPalavras;
import com.github.andrelauterjung.jogo.forca.model.DadosJogo;

import java.util.ArrayList;
/**
 *
 * @author andrelauterjung
 */
public class GerenciadorPalavrasJogo {
    
    ListaPalavras listaPalavras = new ListaPalavras();
    DadosJogo dados = new DadosJogo();
    
    /* Essa lista foi criada, pois valores serão removidos durante o funcionamento do programa.
    Dessa forma, a listra principal não é alterada tornando mais fácil a adição ou remoção de palavras no jogo. */
    ArrayList<String> palavras = new ArrayList<>(listaPalavras.getListaPalavras());
    
    
    
    
}
