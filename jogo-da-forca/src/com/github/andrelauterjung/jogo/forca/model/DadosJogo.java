package com.github.andrelauterjung.jogo.forca.model;

/**
 *
 * @author andrelauterjung
 */
public class DadosJogo {
    
        private String palavraAtual;
        private int quantidadeLetras;
        private int quantidadeErro;
    
        
        public DadosJogo() {
            
            this.palavraAtual = "";
            this.quantidadeLetras = 0;
            this.quantidadeErro = 0;
        }
        
        // Métodos Getters
        public String getPalavraAtual() {
            return this.palavraAtual;
        }
        
        public int getQuantidadeLetras() {
            return this.quantidadeLetras;
        }
                
        public int getQuantidadeErros() {
            return this.quantidadeErro;
        }
                
        // Métodos Setters
        public void setPalavraAtual(String palavra) {
            this.palavraAtual = palavra;
        }
        
        public void setQuantidadeLetras(int quantidadeLetras) {
            this.quantidadeLetras = quantidadeLetras;
        }
        
        public void setQuantidadeErros(int erros) {
            this.quantidadeErro = erros;
        }
}
