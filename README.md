# Documentação Técnica - Banco Bomvader

**Projeto:** Sistema Bancário (Banco-Bomvader)

## 1. Visão Geral do Projeto
O **Banco-Bomvader** (ou Banco Malvader) é uma aplicação desktop desenvolvida em Java para o gerenciamento de rotinas bancárias. O sistema simula as operações de um banco real, dividindo as funcionalidades entre os perfis de **Cliente** e **Funcionário/Administrador**. A aplicação possui uma interface gráfica (GUI) interativa e utiliza um banco de dados relacional para persistência de dados.

## 2. Tecnologias Implementadas
* **Linguagem:** Java (Padrão Orientado a Objetos).
* **Interface Gráfica:** Java Swing (evidenciado pelos arquivos `.form` e classes de visão).
* **Banco de Dados:** MySQL. A comunicação é feita via JDBC utilizando a biblioteca `mysql-connector-java-5.1.23-bin.jar`.
* **Arquitetura:** O projeto segue o padrão arquitetural em camadas MVC/DAO, separando as regras de negócio, acesso a dados e interface de usuário.

## 3. Estrutura do Projeto
O código-fonte está estruturado no pacote principal `br.edu`, subdividido nas seguintes camadas:
* **modelo:** Contém as classes de entidade que representam as regras de negócio:
    * `Usuario`, `Cliente`, `Funcionario`.
    * `Conta`, `ContaCorrente`, `ContaPoupanca`.
    * `Endereco`.
* **DAO (Data Access Object):** Responsável pela comunicação direta com o banco de dados. Contém as classes que executam as queries SQL (ex: `ClienteDAO`, `FuncionarioDAO`, `CCDAO`, `CPDAO`) e a classe de configuração `ConexaoBanco`.
* **visao:** Contém todas as telas da aplicação construídas em Java Swing (ex: `TelaBoasVindas`, `TelaLoginCliente`, `TelaLoginFuncionario`).
* **main:** Contém a classe principal `BancoMalvader` que inicializa a aplicação.
* **util:** Classes utilitárias, como o gerador de relatórios (`Relatorio`).

## 4. Funcionalidades do Sistema
    
### 4.1. Módulo do Cliente
Os clientes têm acesso a um menu dedicado (`TelaMenuCliente`) após efetuarem login, onde podem realizar as seguintes operações:
* **Consultas:** Visualizar Saldo (`TelaConsultarSaldoMenuCliente`), verificar Limite (`TelaConsultarLimiteMenuCliente`) e emitir Extrato (`TelaExtratoMenuCliente`).
* **Transações:** Realizar Saques (`TelaSaqueMenuCliente`) e Depósitos (`TelaDepositoMenuCliente`).

### 4.2. Módulo do Funcionário / Administrador
Os funcionários gerenciam a infraestrutura do banco através do menu administrativo (`TelaMenuFuncionario`):
* **Gestão de Contas:** Abertura de Conta Corrente (`TelaAberturaCCfunc`) e Conta Poupança (`TelaAberturaCPfunc`), e Encerramento de Contas (`TelaEncerramentoDeConta`).
* **Gestão de Clientes:** Cadastrar (`TelaCadastroCliente`), Alterar dados (`TelaAlterarCliente`) e Consultar informações (`TelaConsultarClienteDados`).
* **Gestão Interna:** Cadastro e alteração de Funcionários (`TelaAdmCadastroFuncionario`, `TelaAdmAlterarFuncionario`).
* **Relatórios:** Geração de relatórios de movimentação (`TelaRelatorioDeMovimentacao`).

## 5. Como Utilizar a Aplicação
Para executar o sistema em um ambiente de desenvolvimento local, siga as instruções abaixo:
    
### 5.1. Pré-requisitos
* Java Development Kit (JDK) versão 8 ou superior instalado.
* Servidor MySQL rodando localmente ou remotamente.
* Uma IDE Java (como IntelliJ IDEA, Eclipse ou NetBeans).

### 5.2. Configuração do Banco de Dados
1. Inicie o servidor MySQL e crie o banco de dados necessário para a aplicação.
2. Crie uma conta específica para a aplicação com apenas os privilégios necessários. Evite usar a conta administrativa `root` e não use senhas vazias.
3. Configure as variáveis de ambiente no terminal ou na configuração de execução da IDE. Use a URL, usuário e senha do seu próprio ambiente:

   **macOS/Linux (shell):**
   ```bash
   export BOMVADER_DB_URL="jdbc:mysql://localhost:3306/banco_bomvader"
   export BOMVADER_DB_USER="banco_bomvader_app"
   export BOMVADER_DB_PASSWORD="<senha-configurada-localmente>"
   ```

   **Windows PowerShell:**
   ```powershell
   $env:BOMVADER_DB_URL = "jdbc:mysql://localhost:3306/banco_bomvader"
   $env:BOMVADER_DB_USER = "banco_bomvader_app"
   $env:BOMVADER_DB_PASSWORD = "<senha-configurada-localmente>"
   ```

   Substitua os valores pelos da sua instalação. Não coloque segredos no código, em commits, no README, em Issues ou em logs. O programa falha explicitamente se alguma variável estiver ausente e evita imprimir a URL ou a senha quando a conexão falha.

### 5.3. Configuração do Projeto
1. Importe o projeto `Banco-Bomvader` na sua IDE.
2. Certifique-se de que a biblioteca `mysql-connector-java-5.1.23-bin.jar` (localizada na pasta `libs/`) esteja adicionada ao **Classpath/Build Path** do projeto.

### 5.4. Execução
Execute a classe principal `BancoMalvader.java` localizada no pacote `br.edu.main`. A `TelaBoasVindas` será exibida, permitindo que você navegue como Cliente ou Funcionário.
