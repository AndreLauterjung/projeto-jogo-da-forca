package com.github.andrelauterjung.jogo.forca.model;

/**
 * Armazena e gerencia os dados de estado da rodada atual do Jogo da Forca.
 * <p>
 * Mantém a palavra sorteada para a partida, a sua quantidade total de letras e
 * o contador acumulado de erros cometidos pelo jogador durante as tentativas.
 *
 * @author andrelauterjung
 */
public class DadosJogo {

    private String palavraAtual;
    private int quantidadeLetras;
    private int quantidadeErro;

    /**
     * Inicializa uma nova instância de dados da partida com valores padrão
     * (palavra vazia e contadores zerados).
     */
    public DadosJogo() {

        this.palavraAtual = "";
        this.quantidadeLetras = 0;
        this.quantidadeErro = 0;
    }

    // Métodos Getters.
    /**
     * Retorna a palavra secreta sorteada para a rodada atual.
     *
     * @return a palavra atual da partida.
     */
    public String getPalavraAtual() {
        return this.palavraAtual;
    }

    /**
     * Retorna a quantidade total de letras da palavra atual.
     *
     * @return o número de caracteres da palavra sorteada.
     */
    public int getQuantidadeLetras() {
        return this.quantidadeLetras;
    }

    /**
     * Retorna a quantidade acumulada de erros cometidos pelo jogador na rodada.
     *
     * @return o número atual de erros registrados.
     */
    public int getQuantidadeErros() {
        return this.quantidadeErro;
    }

    // Métodos Setters.
    /**
     * Define a palavra secreta para a rodada atual.
     *
     * @param palavra a nova palavra sorteada para a partida.
     */
    public void setPalavraAtual(String palavra) {
        this.palavraAtual = palavra;
    }

    /**
     * Define a quantidade total de letras da palavra atual.
     *
     * @param quantidadeLetras o total de caracteres da palavra.
     */
    public void setQuantidadeLetras(int quantidadeLetras) {
        this.quantidadeLetras = quantidadeLetras;
    }

    /**
     * Incrementa o contador de erros da rodada atual.
     *
     * @param erros a quantidade de erros a ser somada ao total atual.
     */
    public void atualizaQuantidadeErros(int erros) {
        this.quantidadeErro += erros;
    }

    /**
     * Reinicia o contador de erros para zero, preparando o estado para uma nova
     * rodada.
     */
    public void zeraQuantidadeErros() {
        this.quantidadeErro = 0;
    }
}
