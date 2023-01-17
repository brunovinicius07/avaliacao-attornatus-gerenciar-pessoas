package com.attornatus.gerenciarpessoas.dtos;
import lombok.*;

@Data
public class EnderecoDto {
    private String logradouro;
    private int cep;
    private String numero;
    private String cidade;
    private long pessoaId;
    boolean enderecoPrincipal;
}
