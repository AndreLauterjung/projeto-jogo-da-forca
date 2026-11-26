package com.github.andrelauterjung.jogo.forca.view;

/**
 * Gerencia a exibição das telas, menus, prompts e representações visuais
 * do Jogo da Forca no console.
 * <p>
 * Centraliza a saída visual da partida, incluindo o cabeçalho do jogo,
 * identificação da rodada, desenho progressivo do boneco de acordo com os
 * erros e exibição das letras digitadas e da palavra tracejada.
 *
 * @author andrelauterjung
 */
public class TelaJogo
{
    
    /**
     * Exibe no console o cabeçalho principal de apresentação do Jogo da Forca.
     */
    public static void mensagemJogoDaForca() {
        
        System.out.println("\n=====================================================");
        System.out.println("================= JOGO DA FORCA =====================");
        System.out.println("=====================================================");
    }
    
    /**
     * Exibe uma linha divisória seguida pelo número da rodada atual no console.
     *
     * @param numRodada o número identificador da rodada em andamento.
     */
    public static void mensagemRodada(int numRodada) {
        
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        System.out.println("Rodada: "+numRodada);
    }
    
    /**
     * Exibe no console o menu principal com as opções disponíveis ao jogador
     * (encerrar programa ou iniciar nova rodada).
     */
    public static void menuOpcoes(){
        System.out.println("\nDigite o número da opção: \n");
        System.out.println("0 - Encerrar Programa.");
        System.out.println("1 - Nova Rodada.");
    }
    
    /**
     * Exibe uma linha divisória e solicita que o jogador digite uma letra.
     */
    public static void mensagemDigitarLetra() {
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        System.out.println("\nDigite uma letra: ");
    }
    
    /**
     * Exibe o rótulo 'Palavra:' no console antes da palavra tracejada.
     */
    public static void textoPalavra() {
        System.out.printf("\nPalavra: ");
    }
    
    /**
     * Exibe um aviso no console informando que a letra digitada já foi
     * utilizada anteriormente na rodada atual.
     */
    public static void avisoLetraJaDigitada() {
        
        System.out.println("A letra já foi digitada!");
    }
    
    /**
     * Exibe a representação visual do boneco na forca correspondente a 1 erro
     * (cabeça).
     */
    public static void bonecoUmErro() {
        System.out.println("\nVocê tem 1 erro!");
        System.out.println("  O  ");
        LinhasDivisorias.exibirLinhaExclamacao();
    }
    
    /**
     * Exibe a representação visual do boneco na forca correspondente a 2 erros
     * (cabeça e tronco).
     */
     public static void bonecoDoisErros() {
        System.out.println("\nVocê tem 2 erros!");
        System.out.println("  O  \n  |");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
     /**
     * Exibe a representação visual do boneco na forca correspondente a 3 erros
     * (cabeça, tronco e braço esquerdo).
     */
     public static void bonecoTresErros() {
        System.out.println("\nVocê tem 3 erros!");
        System.out.println("  O  \n /|");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
     /**
     * Exibe a representação visual do boneco na forca correspondente a 4 erros
     * (cabeça, tronco e ambos os braços).
     */
     public static void bonecoQuatroErros() {
        System.out.println("\nVocê tem 4 erros: ");
        System.out.println("  O  \n /|\\");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
     /**
     * Exibe a representação visual do boneco na forca correspondente a 5 erros
     * (cabeça, tronco, braços e perna esquerda).
     */
     public static void bonecoCincoErros() {
        System.out.println("\nVocê tem 5 erros: ");
        System.out.println("  O  \n /|\\ \n / ");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
     /**
     * Exibe a representação visual completa do boneco na forca correspondente
     * ao limite de 6 erros (cabeça, tronco, braços e ambas as pernas).
     */
     public static void bonecoSeisErros() {
        System.out.println("\nVocê tem 6 erros!");
        System.out.println("  O  \n /|\\ \n / \\");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
     /**
     * Seleciona e exibe o estágio correspondente do boneco da forca de acordo
     * com a quantidade atual de erros do jogador.
     *
     * @param erros a quantidade de erros acumulados na rodada (de 0 a 6).
     */
     public void mostrarBoneco(int erros) {
         
         switch(erros) {
                
                case 0:
                    break;
                    
                case 1:
                    TelaJogo.bonecoUmErro();
                    break;
                    
                case 2: 
                    TelaJogo.bonecoDoisErros();
                    break;
                    
                case 3:
                    TelaJogo.bonecoTresErros();
                    break;
                    
                case 4:
                    TelaJogo.bonecoQuatroErros();
                    break;
                    
                case 5: 
                    TelaJogo.bonecoCincoErros();
                    break;
                    
                case 6:
                    TelaJogo.bonecoSeisErros();
                    break;
            }
     }
     
     /**
     * Exibe no console a lista de letras já digitadas pelo jogador na rodada atual.
     *
     * @param letrasDigitadas sequência contendo as letras já tentadas na rodada.
     */
     public static void mensagemLetrasDigitadas(String letrasDigitadas) {
         System.out.printf("\nLetras digitadas: %s\n", letrasDigitadas);
     }
     
     /**
     * Exibe no console o estado atual da palavra da rodada, mostrando as letras
     * já descobertas e os traços das posições restantes.
     *
     * @param palavra a palavra formatada com letras descobertas e traços.
     */
     public static void mostrarPalavraLinhaTracejada(String palavra) {
         
         System.out.printf(palavra + "\n");
     }
}
