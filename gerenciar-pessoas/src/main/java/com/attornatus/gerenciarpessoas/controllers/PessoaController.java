package com.attornatus.gerenciarpessoas.controllers;

import com.attornatus.gerenciarpessoas.dtos.PessoaDto;
import com.attornatus.gerenciarpessoas.entities.Pessoa;
import com.attornatus.gerenciarpessoas.repositories.PessoaRepository;
import com.attornatus.gerenciarpessoas.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pesssoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid PessoaDto pessoaDto){
        return new ResponseEntity<Pessoa>(pessoaService.cadastrarPessoa(pessoaDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPessoa(@PathVariable(value = "id") Long id){
        Optional<Pessoa> pessoa = pessoaService.buscarPessoa(id);
        if (!pessoa.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoa.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable(value = "id") Long id, @RequestBody @Valid PessoaDto pessoaDto){
        return new ResponseEntity<Pessoa>(pessoaService.editarPessoa(pessoaDto, id), HttpStatus.OK);
    }

}
