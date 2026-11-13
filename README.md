# TESTES JAVA

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-%20-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Docker-blue)


## Sobre o projeto

Explique em um ou dois parágrafos:

- **O que é:** que problema o sistema resolve ou que funcionalidade ele entrega (por exemplo, "cadastro de clientes com listagem, inclusão, alteração e exclusão").
- **Para quem:** quem usaria o sistema.
- **Por que foi feito:** trabalho do 2º bimestre de Modelos e Linguagem de Programação III, Multivix Vitória, 2026/2.

## Equipe

| Integrante | Parte desenvolvida | O que fez |
| --- | --- | --- |
| Henrique Langa | Ex.: dados (entidade e repositório) | Resumo em uma frase |
| Jhon Wesley | Ex.: interface | Resumo em uma frase |
| Vitor Sena | Ex.: padrões de projeto | Resumo em uma frase |


## Temas do bimestre

Especifique, para cada um dos quatro temas, como ele foi aplicado e onde está no código.

| Tema | Como foi aplicado | Onde está no código |
| --- | --- | --- |
| Classes de manipulação de dados de BD | Ex.: entidade `Cliente` e `ClienteRepository` com Spring Data JPA | `src/main/java/.../Cliente.java`, `ClienteRepository.java` |
| Interface web | Explique como a página, o controller e o serviço (ou repositório) se ligam | `src/main/java/.../ClienteController.java` e `src/main/resources/templates/clientes.html` |
| Padrões de projeto e boas práticas | Qual padrão foi applied, por quê, e o que melhorou no código | Classe(s) e pacote(s) onde o padrão aparece |
| Teste unitário | O que foi testado e com que ferramenta (JUnit) | `src/test/java/...` |

## Tecnologias

- Java 25
- Spring Boot e Spring Data JPA
- MySQL (em Docker)
- Interface: Spring MVC com Thymeleaf
- JUnit para testes

## Estrutura do projeto

```text
projeto/
├── docker-compose.yml
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/example/aula/
    │   │   ├── Cliente.java
    │   │   ├── ClienteRepository.java
    │   │   └── ...
    │   └── resources/
    │       ├── application.properties
    │       └── templates/        (somente se a interface for web)
    └── test/java/com/example/aula/


## Autores

Equipe Henrique Langa| John Wesley| Vitor Sena | Turma SIN05NA/SIN06NA | Multivix Vitória - 2026/2 |  Professora: Juliana Rodrigues de Lima Meirelles.