package com.attornatus.gerenciarpessoas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "endereco")
@Entity
public class Endereco implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String logradouro;

    private int cep;

    private String numero;

    private String cidade;

    @JsonBackReference
    @ManyToOne
    private Pessoa pessoa;

    @NotNull
    private Boolean enderecoPrincipal;

    public Endereco(String logradouro, int cep, String numero, String cidade, Pessoa pessoa, Boolean enderecoPrincipal) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.pessoa = pessoa;
        this.enderecoPrincipal = enderecoPrincipal;
    }
}
