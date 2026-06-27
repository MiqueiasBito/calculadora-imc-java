# Calculadora de IMC em Java

## Descrição

Este projeto foi desenvolvido para a disciplina de Programação Orientada a Objetos.

A aplicação funciona por linha de comando (CLI) e permite realizar o cadastro de pessoas e atletas, calcular o Índice de Massa Corporal (IMC) e apresentar sua classificação de acordo com a tabela de IMC.

O projeto foi desenvolvido utilizando os principais conceitos de Programação Orientada a Objetos em Java.

---

## Funcionalidades

- Cadastro de pessoas
- Cadastro de atletas
- Listagem de pessoas cadastradas
- Busca por nome
- Edição de cadastro
- Remoção de cadastro
- Cálculo automático do IMC
- Classificação do IMC
- Validação de entradas do usuário
- Tratamento de exceções

---

## Conceitos de POO utilizados

- Classes e Objetos
- Encapsulamento
- Herança
- Polimorfismo
- Classe Abstrata
- Interface
- Composição
- Exceções Personalizadas

---

## Estrutura do projeto

```
calculadora-imc-java
│
├── pom.xml
├── README.md
└── src
    └── main
        └── java
            ├── Main.java
            ├── PessoaBase.java
            ├── Pessoa.java
            ├── Atleta.java
            ├── HistoricoIMC.java
            ├── CalculavelIMC.java
            └── EntradaInvalidaException.java
```

---

## Tecnologias utilizadas

- Java 17
- Maven
- Visual Studio Code

---

## Como executar

### Compilar com Maven

```bash
mvn compile
```

### Executar

```bash
java -cp target/classes Main
```

Ou, caso esteja compilando manualmente:

```bash
javac *.java
java Main
```

---

## Autor

Projeto desenvolvido por **Miquéias Bito** para a disciplina de Programação Orientada a Objetos.

---

## Agradecimentos

Agradecimento aos professores e materiais que contribuíram para o desenvolvimento deste projeto:

- Prof. Dr. Romes Heriberto
- YouTube: Professor Isidro (Curso de Java)
- YouTube: Gustavo Guanabara (Curso em Vídeo)

Também agradeço às ferramentas de apoio utilizadas durante o desenvolvimento:

- ChatGPT (OpenAI)
- Codex
- Claude (Anthropic)