#  Desafio Attornatus - Gerenciar Pessoas -

## 🖥️ Tecnologias Utilizadas

* Spring Boot
* Java 17
* Intellij
* Postman
*  H2

## ⚙️Funcionalidades

#### 🧑🏽Pessoa
   * Criar pessoa
   * Editar pessoa
   * Buscar pessoa
   * Listar pessoas
   
#### 🏙️Endereço   
   * Criar endereço para pessoa
   * Listar endereços das pessoas
   * Listar endereços da pessoa
   * Buscar endereço da pessoa
   * Informar endereço principal da pessoa

## 🧑🏽‍💻URL
http://localhost:8080/pessoa/

## 🛠️ Rests da API

#### 🧑🏽Pessoa Controller
| Rest  | URL             |Função |
|-------|-----------------| ------- |
| POST  | /cadastrarPessoa      | Criar pessoa |
| PUT   | /editarPessoa/{id}   | Editar pessoa |
| GET   | /buscarPessoa/{id}| Buscar pessoa |
| GET   | /listarPessoas    | Listar pessoas |


#### 🏙️Endereço Controller

|Rest | URL                         |Função |
|------ |-----------------------------| ------- |
|POST   | /cadastrarEndereco | Criar endereço para pessoa |
|GET   | /listarEnderecos | Listar endereços das pessoas|
|GET   | /listarEnderecosPessoa/{id} | Listar endereços da pessoa |
|GET   | /buscarEndereco/{id} | Buscar endereço da pessoa |

## Respostas Qualidade de Código

1.Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

R: A documentação, o levantamento de requisitos e realizar testes durante todo o ciclo de vida do software. com esses critérios o software funcionara adequadamente com seus objetivos e a maneira com que o usuário entenda a utilização dos recursos. Uma avaliação como essa é fundamental para evitar problemas bastante prejudiciais para a empresa. Um software sem garantia de qualidade pode prejudicar a experiência dos usuários e comprometer o resultado final.


2.Em qual etapa da implementação você considera a qualidade de software?

R: No teste. Ao realizar a implementação, o software será testado para verificar se está mesmo atendendo as necessidades do cliente. Isso porque o objetivo é executar e validar os requisitos dos clientes. Um software de qualidade é fácil de usar, é de fácil manutenção e mantém a integridade dos dados para evitar possíveis falhas.
