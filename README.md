# API com Spring Boot 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/JuniorAC90/api-attus-teste-03/blob/main/LICENSE) 

# Sobre o projeto

É uma aplicação back end construída para o processo seletivo da empresa Attus.

A aplicação consiste no registro de pessoas e endereços.

## Modelo conceitual
![Modelo Conceitual](https://github.com/JuniorAC90/api-attus-teste-03/blob/main/assets/teste-03-diagrama.drawio.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
## Implantação em ambiente teste
- Banco de dados: H2

# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/JuniorAC90/api-attus-teste-03.git

# entrar na pasta do projeto 
cd api-attus-teste-03

# executar o projeto
./mvnw spring-boot:run
```
## Rotas
Exemplos:

- GET - "/pessoas" - Lista todas as pessoas cadastradas 
- GET - "/enderecos" - Lista todos os endereços
- GET - "/pessoas/1" - Lista a pessoa de id 1
- GET - "/enderecos/1" - Lista o endereço de id 1

- POST - "/pessoas" - Cadastra uma nova pessoa 
- POST - "/enderecos/pessoas/1" - Cadastra um endereço para a pessoa de id 1

- PUT - "/pessoas/1" - Atualiza a pessoa de id 1 
- PUT - "/enderecos/1" - Atualiza o endereço de id 1

![Pessoas](https://github.com/JuniorAC90/api-attus-teste-03/blob/main/assets/pessoa-01.png)

  
![Endereços](https://github.com/JuniorAC90/api-attus-teste-03/blob/main/assets/pessoa-endereco-01.png)



# Autor

Aloizio da Costa Junior

https://www.linkedin.com/in/JuniorAC90
