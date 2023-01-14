package com.attornatus.gerenciarpessoas.services;

import com.attornatus.gerenciarpessoas.dtos.PessoaDto;
import com.attornatus.gerenciarpessoas.entities.Pessoa;
import com.attornatus.gerenciarpessoas.repositories.EnderecoRepository;
import com.attornatus.gerenciarpessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Pessoa cadastrarPessoa(PessoaDto pessoaDto){
        Pessoa pessoa = pessoaRepository.save(converteObjetoDto(pessoaDto,enderecoRepository));
        return pessoa;
    }

    public Pessoa converteObjetoDto(PessoaDto pessoaDto, EnderecoRepository enderecoRepository){
        return  new Pessoa( pessoaDto.getNome(), pessoaDto.getDataNascimento());
    }
}
