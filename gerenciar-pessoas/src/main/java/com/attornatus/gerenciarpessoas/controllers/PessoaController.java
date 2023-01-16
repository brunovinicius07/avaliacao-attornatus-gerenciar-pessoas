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

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pesssoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @PostMapping(value = "/cadastrarPessoa")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid PessoaDto pessoaDto){
        return new ResponseEntity<Pessoa>(pessoaService.cadastrarPessoa(pessoaDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscarPessoa/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable(value = "id") Long id){
            return new ResponseEntity<Pessoa>(pessoaService.buscarPessoaPorId(id), HttpStatus.OK);
        }

    @PutMapping(value = "/editarPessoa/{id}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable(value = "id") Long id, @RequestBody @Valid PessoaDto pessoaDto){
        return new ResponseEntity<Pessoa>(pessoaService.editarPessoa(pessoaDto, id), HttpStatus.OK);
    }

    @GetMapping("/listarPessoas")
    public ResponseEntity<List<Pessoa>> listarPessoa() {
        return new ResponseEntity<List<Pessoa>>(pessoaService.buscarPessoas(), HttpStatus.OK);
    }
}
