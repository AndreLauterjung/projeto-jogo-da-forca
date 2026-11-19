package com.github.andrelauterjung.jogo.forca.view;

/**
 *
 * @author andrelauterjung
 */
public class TelaJogo
{
    
    public static void mensagemJogoDaForca() {
        
        System.out.println("\n=====================================================");
        System.out.println("================= JOGO DA FORCA =====================");
        System.out.println("=====================================================");
    }
    
    public static String mensagemRodada() {
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        return "Rodada: ";
    }
    
    public static void menuOpcoes(){
        System.out.println("\nDigite o número da opção: \n");
        System.out.println("0 - Encerrar Programa.");
        System.out.println("1 - Nova Rodada.");
    }
    
    
    
    public static void mensagemDigitarLetra() {
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        System.out.println("\nDigite uma letra: ");
    }
    
    
    public static void bonecoUmErro() {
        System.out.println("\nVocê tem 1 erro!");
        System.out.println("  O  ");
        LinhasDivisorias.exibirLinhaExclamacao();
    }
    
     public static void bonecoDoisErros() {
        System.out.println("\nVocê tem 2 erros!");
        System.out.println("  O  \n  |");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
     public static void bonecoTresErros() {
        System.out.println("\nVocê tem 3 erros!");
        System.out.println("  O  \n /|");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
     public static void bonecoQuatroErros() {
        System.out.println("\nVocê tem 4 erros: ");
        System.out.println("  O  \n /|\\");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
     public static void bonecoCincoErros() {
        System.out.println("\nVocê tem 5 erros: ");
        System.out.println("  O  \n /|\\ \n / ");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
     public static void bonecoSeisErros() {
        System.out.println("\nVocê tem 6 erros!");
        System.out.println("  O  \n /|\\ \n / \\");
        LinhasDivisorias.exibirLinhaExclamacao();
     }
     
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
     
     public static void mensagemLetrasDigitadas(String letrasDigitadas) {
         System.out.printf("\nLetras digitadas: %s\n", letrasDigitadas);
     }
}
