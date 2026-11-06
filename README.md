# Jogo da Forca em Java (Console)

Um jogo da forca clássico desenvolvido em **Java**, estruturado em camadas (MVC) e executado diretamente via terminal. Este projeto faz parte dos meus estudos práticos para consolidação de lógica de programação, Orientação a Objetos e versionamento com Git.

---

## Funcionalidades da Versão (v1.0)
* **Dinâmica de Palavras (A-Z):** O jogo conta com uma lista de 26 palavras exclusivas organizadas em ordem alfabética.
* **Controle de Erros:** Exibição progressiva do boneco da forca a cada erro cometido (limite de 6 erros).
* **Reset de Rodadas:** O estado da partida e a contagem de erros são limpos automaticamente ao concluir uma palavra, permitindo avançar para a próxima.
* **Interface Textual Limpa:** Menus interativos no console utilizando `Scanner` e formatação customizada.

---

## 📂 Arquitetura do Projeto
O código foi estruturado seguindo uma separação clara de responsabilidades:

```text
src/
└── com/
    └── github/
        └── andrelauterjung/
            └── jogo/
                └── forca/
                    ├── app/          # Ponto de entrada da aplicação (Main)
                    ├── logic/        # Regras de negócio, controladores e gerenciadores
                    ├── model/        # Objetos de dados e listas de palavras
                    └── view/         # Telas, menus e mensagens de exibição no console
