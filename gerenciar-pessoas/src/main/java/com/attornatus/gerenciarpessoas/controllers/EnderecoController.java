package com.attornatus.gerenciarpessoas.controllers;


import com.attornatus.gerenciarpessoas.dtos.EnderecoDto;
import com.attornatus.gerenciarpessoas.entities.Endereco;
import com.attornatus.gerenciarpessoas.repositories.EnderecoRepository;
import com.attornatus.gerenciarpessoas.repositories.PessoaRepository;
import com.attornatus.gerenciarpessoas.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pesssoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(value = ("/cadastrarEndereco"))
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody @Valid EnderecoDto enderecoDto){
        return new ResponseEntity<Endereco>(enderecoService.cadastrarEndereco(enderecoDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscarEndereco/{id}")
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable(value = "id") Long id){
        return new ResponseEntity<Endereco>(enderecoService.buscarEnderecoPorId(id),HttpStatus.OK);
    }

    @GetMapping(value = "/listarEnderecos")
    public ResponseEntity<List<Endereco>>listarTodosEnderecos(){
      return new ResponseEntity<List<Endereco>>(enderecoService.buscarTodosEnderecos(), HttpStatus.OK);
    }

    @GetMapping(value = "/listarEnderecosPessoa/{id}")
    public ResponseEntity<List<Endereco>>listarEnderecoPessoa(@PathVariable(value = "id") Long id){
        return new ResponseEntity<List<Endereco>>(enderecoService.buscarEnderecosPessoa(id), HttpStatus.OK);
    }

}
