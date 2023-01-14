package com.attornatus.gerenciarpessoas.services;

import com.attornatus.gerenciarpessoas.dtos.EnderecoDto;
import com.attornatus.gerenciarpessoas.entities.Endereco;
import com.attornatus.gerenciarpessoas.entities.Pessoa;
import com.attornatus.gerenciarpessoas.repositories.EnderecoRepository;
import com.attornatus.gerenciarpessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EnderecoService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastrarEndereco(EnderecoDto enderecoDto){
        Endereco endereco = enderecoRepository.save(converteObjetoDto(enderecoDto, pessoaRepository));
        return endereco;
    }

    public Endereco converteObjetoDto(EnderecoDto enderecoDto, PessoaRepository pessoaRepository){
        Optional<Pessoa> pessoa = pessoaRepository.findById(enderecoDto.getPessoaId());
        return new Endereco(enderecoDto.getLogradouro(),
                            enderecoDto.getCep(),
                            enderecoDto.getNumero(),
                            enderecoDto.getCidade(),
                            pessoa.get());

    }

}
