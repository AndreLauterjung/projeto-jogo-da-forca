package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
import com.github.andrelauterjung.jogo.forca.view.MensagemErro;

/**
 * Representa a palavra da rodada atual e o progresso do jogador nela. Guarda as
 * letras da palavra secreta, a palavra tracejada (com as letras já descobertas)
 * e as letras que o jogador já digitou. Também processa cada letra digitada,
 * revelando-a na palavra ou registrando um erro em DadosJogo.
 *
 * @author andrelauterjung
 */
public class RodadaPalavra {

    private DadosJogo dados;
    private StringBuilder letrasDigitadas;
    private char[] palavraArrayChar;
    private char[] palavraTracejadaChar;

    public RodadaPalavra(DadosJogo dados) {

        this.dados = dados;
        this.letrasDigitadas = new StringBuilder();
        this.palavraArrayChar = new char[0];
        this.palavraTracejadaChar = new char[0];
    }

    /**
     * Prepara o array de caracteres da palavra secreta da rodada, copiando cada
     * letra da palavra atual (obtida na classe DadosJogo). Deve ser chamado
     * sempre que uma nova palavra for sorteada ou carregada.
     */
    public void adicionarPalavraArrayChar() {

        this.palavraArrayChar = new char[this.dados.getQuantidadeLetras()];

        for (int i = 0; i < this.dados.getPalavraAtual().length(); i++) {

            palavraArrayChar[i] = this.dados.getPalavraAtual().charAt(i);
        }
    }

    /**
     * Prepara a palavra tracejada da rodada, com um traço (_) para cada letra
     * da palavra atual. Exemplo: "abobora" vira _ _ _ _ _ _ _. Deve ser chamado
     * junto com adicionarPalavraArrayChar(), no início de cada rodada.
     */
    public void adicionarPalavraTracejadaArray() {

        this.palavraTracejadaChar = new char[this.dados.getQuantidadeLetras()];

        for (int i = 0; i < this.dados.getPalavraAtual().length(); i++) {

            palavraTracejadaChar[i] = '_';
        }
    }

    /**
     * Processa a letra digitada pelo usuário na rodada atual.
     * <ul>
     * <li>Se a letra já foi digitada, exibe um aviso e não conta como
     * erro.</li>
     * <li>Se a letra está na palavra, revela todas as posições em que ela
     * aparece.</li>
     * <li>Se a letra não está na palavra, exibe a mensagem de erro e soma um
     * erro.</li>
     * </ul>
     * Toda letra nova é registrada na lista de letras digitadas.
     *
     * @param letra a letra digitada, já validada e em minúscula
     */
    public void processarLetra(char letra) {

        boolean isLetraErrada = true;

        boolean letraJaDigitada = this.letrasDigitadas.indexOf(String.valueOf(letra)) >= 0;
        if (letraJaDigitada) {

            TelaJogo.avisoLetraJaDigitada();
        } else {

            this.letrasDigitadas.append(letra);

            for (int i = 0; i < this.dados.getPalavraAtual().length(); i++) {

                if (this.palavraArrayChar[i] == letra) {

                    isLetraErrada = false;
                    this.palavraTracejadaChar[i] = letra;
                }
            }
            if (isLetraErrada) {
                MensagemErro.mensagemLetraErrada();
                this.dados.atualizaQuantidadeErros(1);
            }
        }
    }

    /**
     * Indica se a palavra ainda tem letras não descobertas (traços).
     *
     * @return true se ainda houver algum traço, false se a palavra estiver
     * completa
     */
    public boolean temLetraFaltando() {

        for (char caractere : this.palavraTracejadaChar) {

            if (caractere == '_') {

                return true;
            }
        }
        return false;
    }

    /**
     * Reinicia o estado da palavra da rodada, limpando as letras já digitadas
     * e redefinindo os arrays da palavra secreta e da palavra tracejada.
     * <p>
     * Deve ser chamado ao encerrar uma rodada para preparar o objeto para a
     * próxima partida.
     */
    public void resetar() {
        resetarLetrasDigitadas();
        this.palavraArrayChar = new char[0];
        this.palavraTracejadaChar = new char[0];
    }
    
    /**
     * Limpa as letras digitadas na rodada atual. Deve ser chamado ao encerrar
     * uma rodada, para que a próxima comece sem letras.
     */
    public void resetarLetrasDigitadas() {

        this.letrasDigitadas.setLength(0);
    }

    /**
     * Retorna as letras que o usuário já digitou na rodada atual, na ordem em
     * que foram digitadas.
     *
     * @return as letras digitadas, ou uma String vazia se ainda não houve
     * tentativa
     */
    public String getLetrasDigitadas() {

        return this.letrasDigitadas.toString();
    }

    /**
     * Retorna a palavra da rodada no estado atual, com as letras já descobertas
     * e traços (_) no lugar das que faltam, separados por espaço.
     *
     * Exemplo: "a b o b o _ a ".
     *
     * @return a palavra tracejada como String.
     */
    public String getPalavraLinhaTracejada() {

        StringBuilder palavra = new StringBuilder();

        for (char caractere : this.palavraTracejadaChar) {

            palavra.append(caractere).append(" ");
        }
        return palavra.toString();
    }

}
