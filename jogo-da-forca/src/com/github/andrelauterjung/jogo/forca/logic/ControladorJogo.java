package com.github.andrelauterjung.jogo.forca.logic;

import com.github.andrelauterjung.jogo.forca.model.DadosJogo;
import com.github.andrelauterjung.jogo.forca.view.MensagemEncerramento;
import com.github.andrelauterjung.jogo.forca.view.MensagemErro;
import com.github.andrelauterjung.jogo.forca.view.TelaJogo;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Controla o fluxo geral de execução do Jogo da Forca no console.
 * <p>
 * Coordena o ciclo de vida do programa, exibindo o menu principal, processando
 * a opção escolhida pelo usuário e integrando a entrada de dados com o
 * gerenciamento das rodadas e dos estados do jogo.
 *
 * @author andrelauterjung
 */
public class ControladorJogo {

    private DadosJogo dados = new DadosJogo();
    private EntradaDados entradaDados = new EntradaDados();
    private GerenciadorPartida gerenciador = new GerenciadorPartida(dados);

    private Scanner sc = new Scanner(System.in);

    private boolean isRodadaEmAndamento = false;
    private boolean isProgramaFuncionando = false;

    /**
     * Inicia e controla o fluxo principal de execução do Jogo da Forca.
     * <p>
     * Mantém o programa em execução enquanto o jogador optar por continuar e
     * ainda houver palavras disponíveis na lista. A cada ciclo, prepara uma
     * nova rodada, exibe o cabeçalho do jogo e apresenta o menu de opções.
     * <p>
     * Quando uma rodada é iniciada, gerencia o loop de tentativas: exibe o
     * estado atual do boneco e da palavra tracejada, lê e valida cada letra
     * digitada e verifica se a rodada ou o programa devem ser encerrados.
     */
    public void iniciarJogo() {

        this.isProgramaFuncionando = true;
        while (this.isProgramaFuncionando) {

            this.gerenciador.prepararNovaRodada();
            TelaJogo.mensagemJogoDaForca();

            menuOpcoes(this.sc);

            while (this.isRodadaEmAndamento) {

                this.gerenciador.mostrarBoneco(this.dados);

                this.gerenciador.mostrarPalavra();

                char letraDigitada = this.entradaDados.lerLetra(this.sc);

                this.gerenciador.verificarLetraNaPalavra(letraDigitada);

                this.isRodadaEmAndamento = this.gerenciador.continuarRodada();
                this.isProgramaFuncionando = this.gerenciador.continuarPrograma();

            } // Fechamento do loop da rodada.

        } // Fechamento do loop principal do jogo.

        this.sc.close();
    } // Fechamento do método iniciarJogo().

    /**
     * Exibe o menu principal do jogo e processa a opção escolhida pelo usuário.
     * <ul>
     * <li><b>1:</b> inicia uma nova rodada e atualiza a contagem de
     * partidas.</li>
     * <li><b>0:</b> encerra a execução do programa e exibe a mensagem de
     * saída.</li>
     * </ul>
     * Caso o usuário digite um número diferente de 0 ou 1, ou informe um valor
     * não numérico, exibe uma mensagem de erro e solicita a entrada novamente
     * até receber uma opção válida.
     *
     * @param sc o Scanner usado para ler a entrada do console.
     */
    private void menuOpcoes(Scanner sc) {

        boolean entradaInvalida = true;
        while (entradaInvalida) {

            try {

                TelaJogo.menuOpcoes();
                int opcaoDigitadaMenu = sc.nextInt();
                sc.nextLine();

                switch (opcaoDigitadaMenu) {

                    case 0:

                        entradaInvalida = false;
                        this.isProgramaFuncionando = false;
                        this.isRodadaEmAndamento = false;
                        MensagemEncerramento.exibirMensagemEncerramentoPrograma();
                        break;

                    case 1:

                        entradaInvalida = false;
                        this.gerenciador.contagemRodada();
                        this.isRodadaEmAndamento = true;
                        break;

                    default:

                        MensagemErro.usuarioDigitouOpcaoInvalida();
                        entradaInvalida = true;

                } // Fechamento switch-case.
            } catch (InputMismatchException inputMismatchException) {

                MensagemErro.avisoEntradaDados();
                sc.next();
            }

        } // Fechamento do loop while.

    } // Fechamento do método menuOpcoes().

} // Fechamento da classe.
