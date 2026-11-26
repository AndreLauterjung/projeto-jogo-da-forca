package com.github.andrelauterjung.jogo.forca.view;

/**
 * Fornece métodos utilitários estáticos para exibir mensagens de encerramento
 * no console ao finalizar o Jogo da Forca.
 * <p>
 * Apresenta avisos formatados tanto para a saída voluntária pelo menu quanto
 * para o término automático quando todas as palavras disponíveis forem utilizadas.
 *
 * @author andrelauterjung
 */
public class MensagemEncerramento {
    
    /**
     * Exibe no console a mensagem padrão de encerramento do programa quando o
     * jogador escolhe a opção de saída no menu principal.
     */
    public static void exibirMensagemEncerramentoPrograma() {
        
        System.out.println("\n=====================================================");
        System.out.println("================ PROGRAMA ENCERRADO! ================");
        System.out.println("=====================================================");
    }
    
    /**
     * Exibe no console a mensagem de encerramento informando que todas as
     * palavras disponíveis na lista do jogo já foram utilizadas.
     */
    public static void exibirMensagemEncerramentoProgramaLimitePalavras() {
        
        System.out.println("\n=====================================================");
        System.out.println("============= FIM DA LISTA DE PALAVRAS! =============");
        System.out.println("================ PROGRAMA ENCERRADO! ================");
        System.out.println("=====================================================");
    }
}
