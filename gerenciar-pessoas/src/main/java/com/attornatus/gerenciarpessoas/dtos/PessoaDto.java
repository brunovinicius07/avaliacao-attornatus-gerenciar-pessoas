package com.attornatus.gerenciarpessoas.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto{
    @NotBlank
    private String nome;

    private Date dataNascimento;
}

