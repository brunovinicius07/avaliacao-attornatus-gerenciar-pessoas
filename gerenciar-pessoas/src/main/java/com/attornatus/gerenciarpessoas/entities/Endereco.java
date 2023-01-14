package com.attornatus.gerenciarpessoas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String logradouro;

    private int cep;

    private String numero;

    private String cidade;

    @ManyToOne
    private Pessoa pessoa;

    public Endereco(String logradouro, int cep, String numero, String cidade, Pessoa pessoa) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }
}
