package com.github.andrelauterjung.jogo.forca.view;

/**
 * Fornece métodos utilitários estáticos para exibir linhas divisórias no console.
 * <p>
 * Auxilia na organização visual das telas, cabeçalhos e mensagens de alerta
 * durante a execução do Jogo da Forca.
 *
 * @author andrelauterjung
 */
public class LinhasDivisorias{
    
    /**
     * Exibe uma linha divisória formada por sinais de igual (=) no console,
     * precedida por uma quebra de linha para espaçamento visual.
     */
    public static void exibirLinhaDivisoriaSinalIgual() {
        
        System.out.println("\n=====================================================");
    }
    
    /**
     * Exibe uma linha divisória formada por pontos de exclamação (!)
     * separados por espaço, utilizada para destacar mensagens de erro ou alerta.
     */
    public static void exibirLinhaExclamacao() {
        
        System.out.println("! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! !");
    }
    
}
