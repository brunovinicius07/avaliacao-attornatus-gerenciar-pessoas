package com.attornatus.gerenciarpessoas.controllers;

import com.attornatus.gerenciarpessoas.dtos.EnderecoDto;
import com.attornatus.gerenciarpessoas.entities.Endereco;
import com.attornatus.gerenciarpessoas.entities.Pessoa;
import com.attornatus.gerenciarpessoas.repositories.EnderecoRepository;
import com.attornatus.gerenciarpessoas.repositories.PessoaRepository;
import com.attornatus.gerenciarpessoas.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pesssoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody @Valid EnderecoDto enderecoDto){
        return new ResponseEntity<Endereco>(enderecoService.cadastrarEndereco(enderecoDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarEndereco(@PathVariable(value = "id") Long id){
        Optional<Endereco> endereco = enderecoService.buscarEndereco(id);
        if (!endereco.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(endereco.get());
    }

}
