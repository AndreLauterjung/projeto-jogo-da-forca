package com.github.andrelauterjung.jogo.forca.view;

/**
 * Fornece métodos utilitários estáticos para exibir mensagens de erro e alerta
 * no console durante a execução do Jogo da Forca.
 * <p>
 * Centraliza os avisos visuais apresentados ao jogador em casos de tentativas
 * incorretas, caracteres inválidos ou opções incorretas no menu principal.
 *
 * @author andrelauterjung
 */
public class MensagemErro {

    /**
     * Exibe no console um aviso destacado informando que a letra digitada pelo
     * jogador não pertence à palavra secreta da rodada atual.
     */
    public static void mensagemLetraErrada() {

        LinhasDivisorias.exibirLinhaExclamacao();
        System.out.println("ERRO! A letra não está na palavra!");
        LinhasDivisorias.exibirLinhaExclamacao();
    }

    /**
     * Exibe no console uma mensagem de erro informando que o caractere digitado
     * durante a tentativa de letra é inválido e solicita nova entrada.
     */
    public static void erroEntradaDados() {

        System.out.println("\nX X X  ERRO!  X X X");
        System.out.println("Caractere inválido!");
        System.out.println("Tente novamente!");
    }

    /**
     * Exibe no console uma mensagem de erro quando o usuário informa um número
     * fora das opções válidas (0 ou 1) no menu principal.
     */
    public static void usuarioDigitouOpcaoInvalida() {
        System.out.println("\nX X X  ERRO!  X X X");
        System.out.println("Opção inválida! Digite 0 ou 1.");
        System.out.println("Tente novamente!");
    }

    /**
     * Exibe no console uma mensagem de erro quando o usuário digita um valor
     * não numérico ao selecionar uma opção no menu principal.
     */
    public static void avisoEntradaDados() {
        System.out.println("\nX X X  ERRO!  X X X");
        System.out.println("Você precisa digitar um número!");
        System.out.println("Tente novamente!");
    }

}
