# Jogo da Forca em Java (Console)

Um jogo da forca clássico desenvolvido em **Java**, estruturado em camadas (**MVC**) e executado diretamente via terminal. Este projeto faz parte dos meus estudos práticos para consolidação de lógica de programação, Orientação a Objetos, tratamento de exceções, documentação com **Javadoc** e versionamento semântico com **Git**.

---

## Funcionalidades (v1.1.0)

- **Catálogo de Palavras (A–Z):** Lista pré-definida com 26 palavras em português (uma para cada letra do alfabeto), sem acentuação gráfica para padronizar as tentativas no console.
- **Histórico de Letras Digitadas:** Exibição contínua das letras já tentadas na rodada atual, evitando repetições acidentais.
- **Alerta de Letra Repetida:** Caso o jogador informe uma letra já utilizada na mesma rodada, o sistema exibe um aviso sem contabilizar erro.
- **Controle Progressivo de Erros:** Desenho incremental do boneco da forca a cada tentativa incorreta (limite de 6 erros).
- **Validação de Entradas e Tratamento de Exceções:** Proteção contra entradas inválidas no menu principal (`InputMismatchException`) e validação rigorosa na leitura de caracteres (aceitando apenas letras únicas).
- **Ciclo Automático de Rodadas:** Limpeza automática de estado entre partidas e tela de encerramento dedicada quando todas as palavras da lista são concluídas.

---

## Arquitetura do Projeto

O código foi organizado com isolamento total de responsabilidades — as camadas `model` e `logic` não possuem dependências de saída no console (`System.out`), mantendo toda a interface textual centralizada em `view`:

```text
src/
└── com/
    └── github/
        └── andrelauterjung/
            └── jogo/
                └── forca/
                    ├── app/
                    │   └── Main.java                  # Ponto de entrada da aplicação
                    ├── logic/
                    │   ├── ControladorJogo.java       # Fluxo principal, menus e loop da aplicação
                    │   ├── EntradaDados.java          # Leitura e validação das letras digitadas
                    │   ├── GerenciadorPartida.java    # Regras das rodadas, controle de erros e palavras
                    │   └── RodadaPalavra.java         # Manipulação da palavra secreta e tracejada
                    ├── model/
                    │   ├── DadosJogo.java             # Estado da partida (palavra, tamanho e erros)
                    │   └── ListaPalavras.java         # Banco de palavras do jogo
                    └── view/
                        ├── LinhasDivisorias.java      # Separadores visuais no console
                        ├── MensagemEncerramento.java  # Telas de finalização do programa
                        ├── MensagemErro.java          # Alertas de erro e entradas inválidas
                        └── TelaJogo.java              # Cabeçalhos, prompts e desenho da forca
```

---

## Tecnologias e Conceitos Aplicados

- **Java (JDK 21+)**
- **Arquitetura MVC** (Model-View-Controller) e encapsulamento
- **Manipulação de Strings e Coleções:** `StringBuilder`, `ArrayList` e arrays primitivos (`char[]`)
- **Tratamento de Exceções:** blocos `try-catch` para controle de fluxo no terminal
- **Documentação:** cobertura completa de **Javadoc** em classes, construtores e métodos
- **Git & Conventional Commits:** histórico organizado por escopo (`feat`, `refactor`, `docs`, `style`) e tags de versão

---

## Como Executar

### Opção 1: Pacote pronto (Linux x64 com JRE embutida)
1. Acesse a aba **Releases** deste repositório e baixe o arquivo compactado da versão **`v1.1.0`**.
2. Extraia o conteúdo e acesse a pasta pelo terminal.
3. Conceda permissão de execução ao script (caso necessário) e inicie o jogo:

```bash
chmod +x jogar.sh
./jogar.sh
```

### Opção 2: Compilando pelo código-fonte
Certifique-se de ter o **JDK** instalado na máquina e execute a partir da raiz do projeto:

```bash
javac -d out src/com/github/andrelauterjung/jogo/forca/*/*.java
java -cp out com.github.andrelauterjung.jogo.forca.app.Main
```

---

## Próximos Passos

- [ ] Integrar persistência com banco de dados relacional (**MySQL** via **JDBC**) na camada `model` para gerenciar o catálogo de palavras dinamicamente.
