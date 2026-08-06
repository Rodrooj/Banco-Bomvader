# Documentação Técnica - Banco Bomvader

**Projeto:** Sistema Bancário (Banco-Bomvader) [cite: 1]

## 1. Visão Geral do Projeto
O **Banco-Bomvader** (ou Banco Malvader) é uma aplicação desktop desenvolvida em Java para o gerenciamento de rotinas bancárias [cite: 1]. O sistema simula as operações de um banco real, dividindo as funcionalidades entre os perfis de **Cliente** e **Funcionário/Administrador** [cite: 1]. A aplicação possui uma interface gráfica (GUI) interativa e utiliza um banco de dados relacional para persistência de dados [cite: 1].

## 2. Tecnologias Implementadas
* **Linguagem:** Java (Padrão Orientado a Objetos) [cite: 1].
* **Interface Gráfica:** Java Swing (evidenciado pelos arquivos `.form` e classes de visão) [cite: 1].
* **Banco de Dados:** MySQL [cite: 1]. A comunicação é feita via JDBC utilizando a biblioteca `mysql-connector-java-5.1.23-bin.jar` [cite: 1].
* **Arquitetura:** O projeto segue o padrão arquitetural em camadas MVC/DAO, separando as regras de negócio, acesso a dados e interface de usuário [cite: 1].

## 3. Estrutura do Projeto
O código-fonte está estruturado no pacote principal `br.edu`, subdividido nas seguintes camadas [cite: 1]:
* **modelo:** Contém as classes de entidade que representam as regras de negócio [cite: 1]:
    * `Usuario`, `Cliente`, `Funcionario` [cite: 1].
    * `Conta`, `ContaCorrente`, `ContaPoupanca` [cite: 1].
    * `Endereco` [cite: 1].
* **DAO (Data Access Object):** Responsável pela comunicação direta com o banco de dados [cite: 1]. Contém as classes que executam as queries SQL (ex: `ClienteDAO`, `FuncionarioDAO`, `CCDAO`, `CPDAO`) e a classe de configuração `ConexaoBanco` [cite: 1].
* **visao:** Contém todas as telas da aplicação construídas em Java Swing (ex: `TelaBoasVindas`, `TelaLoginCliente`, `TelaLoginFuncionario`) [cite: 1].
* **main:** Contém a classe principal `BancoMalvader` que inicializa a aplicação [cite: 1].
* **util:** Classes utilitárias, como o gerador de relatórios (`Relatorio`) [cite: 1].

## 4. Funcionalidades do Sistema
    
### 4.1. Módulo do Cliente
Os clientes têm acesso a um menu dedicado (`TelaMenuCliente`) [cite: 1] após efetuarem login, onde podem realizar as seguintes operações:
* **Consultas:** Visualizar Saldo (`TelaConsultarSaldoMenuCliente`) [cite: 1], verificar Limite (`TelaConsultarLimiteMenuCliente`) [cite: 1] e emitir Extrato (`TelaExtratoMenuCliente`) [cite: 1].
* **Transações:** Realizar Saques (`TelaSaqueMenuCliente`) [cite: 1] e Depósitos (`TelaDepositoMenuCliente`) [cite: 1].

### 4.2. Módulo do Funcionário / Administrador
Os funcionários gerenciam a infraestrutura do banco através do menu administrativo (`TelaMenuFuncionario`) [cite: 1]:
* **Gestão de Contas:** Abertura de Conta Corrente (`TelaAberturaCCfunc`) [cite: 1] e Conta Poupança (`TelaAberturaCPfunc`) [cite: 1], e Encerramento de Contas (`TelaEncerramentoDeConta`) [cite: 1].
* **Gestão de Clientes:** Cadastrar (`TelaCadastroCliente`) [cite: 1], Alterar dados (`TelaAlterarCliente`) [cite: 1] e Consultar informações (`TelaConsultarClienteDados`) [cite: 1].
* **Gestão Interna:** Cadastro e alteração de Funcionários (`TelaAdmCadastroFuncionario`, `TelaAdmAlterarFuncionario`) [cite: 1].
* **Relatórios:** Geração de relatórios de movimentação (`TelaRelatorioDeMovimentacao`) [cite: 1].

## 5. Como Utilizar a Aplicação
Para executar o sistema em um ambiente de desenvolvimento local, siga as instruções abaixo:
    
### 5.1. Pré-requisitos
* Java Development Kit (JDK) versão 8 ou superior instalado.
* Servidor MySQL rodando localmente ou remotamente.
* Uma IDE Java (como IntelliJ IDEA, Eclipse ou NetBeans).

### 5.2. Configuração do Banco de Dados
1. Inicie seu servidor MySQL.
2. É necessário criar o banco de dados e as tabelas correspondentes aos modelos (Clientes, Funcionários, Contas). (Verifique se há um arquivo `.sql` fornecido ou analise as classes DAO para inferir as tabelas).
3. Edite o arquivo `ConexaoBanco.java` localizado em `src/br/edu/DAO/` [cite: 1] para configurar suas credenciais do MySQL:
```java
// Exemplo de configuração na classe ConexaoBanco
String url = "jdbc:mysql://localhost:3306/nome_do_banco";
String user = "seu_usuario";
String password = "sua_senha";
```

### 5.3. Configuração do Projeto
1. Importe o projeto `Banco-Bomvader` na sua IDE.
2. Certifique-se de que a biblioteca `mysql-connector-java-5.1.23-bin.jar` (localizada na pasta `libs/` [cite: 1]) esteja adicionada ao **Classpath/Build Path** do projeto.

### 5.4. Execução
Execute a classe principal `BancoMalvader.java` [cite: 1] localizada no pacote `br.edu.main` [cite: 1]. A `TelaBoasVindas` [cite: 1] será exibida, permitindo que você navegue como Cliente ou Funcionário.
