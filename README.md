#  Desafio Attornatus - Gerenciar Pessoas

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
