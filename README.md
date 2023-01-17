#  Desafio Attornatus - Gerenciar Pessoas

## 🖥️ Tecnologias Utilizadas

* Spring Boot
* Java 17
* Intellij
* Postman
*  H2

## ⚙️Funcionalidades

**Pessoa**
   * Criar Pessoa
   * Editar Pessoa
   * Consultar Pessoa
   * Listar Pessoas
   
**Endereço**   
   * Criar Endereço Para Pessoa
   * Listar Endereços
   * Listar Endereços da Pessoa
   * Buscar Endereço


## 🛠️Métodos

### 🧑🏽Pessoa Controller
| Rest  | URL             |Função |
|-------|-----------------| ------- |
| POST  | /cadastrarPessoa      | Criar pessoa |
| PUT   | /editarPessoa/{id}   | Editar pessoa |
| GET   | /buscarPessoa/{id}| Buscar pessoa |
| GET   | /listarPessoas    | Listar pessoas |


### 🏙️Endereço Controller

|Rest | URL                         |Função |
|------ |-----------------------------| ------- |
|POST   | /cadastrarEndereco | Criar endereço para pessoa |
|GET   | /listarEnderecos | Listar endereços das pessoas|
|GET   | /listarEnderecosPessoa/{id} | Listar endereços da pessoa |
|GET   | /buscarEndereco/{id} | Buscar endereço da pessoa |
