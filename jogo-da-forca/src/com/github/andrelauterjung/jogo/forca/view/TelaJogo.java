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
    
    public static void mensagemDigitarLetra() {
        
        System.out.println("\nDigite uma letra: ");
    }
    
    
    public static void bonecoUmErro() {
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        System.out.println("Você tem 1 erro!");
        System.out.println("  O  ");
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
    }
    
     public static void bonecoDoisErros() {
         LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        System.out.println("Você tem 2 erros!");
        System.out.println("  O  \n  |");
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
     }
     
     public static void bonecoTresErros() {
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        System.out.println("Você tem 3 erros!");
        System.out.println("  O  \n /|");
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
     }
     
     public static void bonecoQuatroErros() {
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        System.out.println("Você tem 4 erros: ");
        System.out.println("  O  \n /|\\");
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
     }
     
     public static void bonecoCincoErros() {
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        System.out.println("Você tem 5 erros: ");
        System.out.println("  O  \n /|\\ \n / ");
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
     }
     
     public static void bonecoSeisErros() {
        LinhasDivisorias.exibirLinhaDivisoriaSinalIgual();
        System.out.println("Você tem 6 erros!");
        System.out.println("  O  \n /|\\ \n / \\");
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
     
}
