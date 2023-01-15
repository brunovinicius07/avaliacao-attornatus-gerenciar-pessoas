package com.attornatus.gerenciarpessoas.dtos;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PessoaDto{
    private String nome;
    private Date dataNascimento;
    private Long enderecoId;
}

