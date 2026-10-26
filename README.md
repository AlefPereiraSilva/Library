# 📚 Sistema de Gerenciamento de Biblioteca

Este projeto consiste em um sistema completo de gerenciamento de biblioteca, unindo conceitos avançados de **Programação Orientada a Objetos (POO) em Java** e modelagem, população e extração de dados com **Banco de Dados Relacional PostgreSQL**.

O desenvolvimento seguiu rigorosamente os requisitos estipulados e adotou padrões de nível de mercado em todas as etapas, desde o encapsulamento até o histórico de versionamento de código.

---

## 🛠️ Tecnologias Utilizadas

*   **Java JDK (21+)**: Implementação das regras de negócio, polimorfismo dinâmico e tratamento de estados.
*   **PostgreSQL**: Modelagem física, integridade referencial, triggers de integridade e consultas analíticas.
*   **Git & GitHub**: Versionamento de código utilizando boas práticas de gerenciamento de ramificações e *Conventional Commits*.

---

## 🚀 Arquitetura do Projeto

### ☕ 1. Camada Java (POO)
A aplicação Java foi estruturada em pacotes isolados para garantir modularidade e segurança de escopo:
*   `br.com.library.model`: Contém a classe abstrata mãe `ItemBiblioteca` (herdada por `Livro`, `Revista` e `DVD`) e a classe abstrata mãe `Usuario` (herdada por `Aluno` e `Professor`).
    *   **Encapsulamento Estrito (Item 8):** Não existem métodos públicos genéricos do tipo `setDisponivel(boolean)`. O status de disponibilidade do acervo é controlado internamente de forma segura através dos métodos específicos de comportamento de negócio `registrarEmprestimo()` e `registrarDevolucao()`.
    *   **Polimorfismo:** Os prazos de entrega e cálculos de multas por atraso variam dinamicamente por tipo de item sem a necessidade de checagem de tipos em estruturas condicionais.
*   `br.com.library.service`: Gerencia a classe controladora `Biblioteca`, responsável por processar empréstimos, retornos e listar o acervo de maneira eficiente em um único laço (`for`), sem checagem de instâncias com `if`.

### 💾 2. Camada de Banco de Dados (PostgreSQL)
A pasta `database/` está dividida em scripts sequenciais estruturados para automação e legibilidade:
1.  `01_ddl_create.sql`: Criação das tabelas `item`, `usuario` e `emprestimo` utilizando a cláusula moderna `GENERATED ALWAYS AS IDENTITY` para chaves primárias e integridade em cascata (`ON DELETE CASCADE`).
2.  `02_dml_insert.sql`: Povoamento inicial com dados válidos e simulação de cenários reais de empréstimos (ativos e finalizados com multas).
3.  `03_ddl_alter_table.sql`: Script de evolução de banco que atualiza a restrição `CHECK` para injetar suporte à nova categoria `DVD`.
4.  `04_dql_queries.sql`: Relatórios gerenciais complexos utilizando junções (`JOIN`), agrupamentos (`GROUP BY`), filtros de valores nulos e a função `COALESCE` para o tratamento estético de usuários adimplentes, exibindo saldo devedor como `0.00` em vez de campos vazios técnicos (`NULL`).

---

## 📈 Histórico de Commits (Padrão de Mercado)

O versionamento do repositório foi construído utilizando **Conventional Commits** para manter uma linha do tempo clara, padronizada e semântica de toda a evolução da aplicação:

```bash
feat(db): 01_ddl_create       # Estrutura inicial do banco
feat(db): 02_dml_insert       # Inserção de dados de teste
refactor(db): 03_alter_table  # Evolução do banco para aceitar DVD
feat(db): 04_dql_queries      # Consultas SQL e relatórios finais
```

---

## 🏃 Como Executar o Projeto

### Pré-requisitos
*   Java JDK 21 ou superior instalado.
*   Banco de dados PostgreSQL instalado e rodando.

### Executando as tabelas e relatórios (PostgreSQL)
1.  Execute o script `database/01_ddl_create.sql` no seu cliente SQL (ex: pgAdmin) para construir a estrutura.
2.  Execute o script `database/02_dml_insert.sql` para popular as tabelas.
3.  Rode o script `database/03_ddl_alter_table.sql` para aplicar a atualização de suporte a DVDs.
4.  Execute as queries de `database/04_dql_queries.sql` para extrair os relatórios gerenciais na tela.

### Executando a Aplicação Java
1.  Navegue até a raiz do projeto.
2.  Compile o código-fonte:
    ```bash
    javac br/com/library/Main.java
    ```
3.  Execute a classe Main para ver a simulação de empréstimos, devoluções, multas e tratamento de erros no terminal:
    ```bash
    java br.com.library.Main
    ```
