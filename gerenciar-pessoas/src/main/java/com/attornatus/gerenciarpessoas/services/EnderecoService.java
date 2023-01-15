package com.attornatus.gerenciarpessoas.services;

import com.attornatus.gerenciarpessoas.dtos.EnderecoDto;
import com.attornatus.gerenciarpessoas.entities.Endereco;
import com.attornatus.gerenciarpessoas.entities.Pessoa;
import com.attornatus.gerenciarpessoas.repositories.EnderecoRepository;
import com.attornatus.gerenciarpessoas.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EnderecoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastrarEndereco(EnderecoDto enderecoDto){
        Endereco endereco = enderecoRepository.save(converteObjetoDto(enderecoDto, pessoaRepository));
        Optional<Pessoa> pessoa = pessoaRepository.findById(endereco.getPessoa().getId());
        if (pessoa.isPresent()){
            List<Endereco> listaDeEndereco = new ArrayList<>();
            listaDeEndereco.add(endereco);
            Pessoa pessoaEncontrada = pessoa.get();
            pessoaEncontrada.setEnderecos(listaDeEndereco);
            pessoaRepository.save(pessoaEncontrada);
        }
        return endereco;
    }

    @Transactional
    public Endereco converteObjetoDto(EnderecoDto enderecoDto, PessoaRepository pessoaRepository){
        Optional<Pessoa> pessoa = pessoaRepository.findById(enderecoDto.getPessoaId());
        return new Endereco(enderecoDto.getLogradouro(),
                            enderecoDto.getCep(),
                            enderecoDto.getNumero(),
                            enderecoDto.getCidade(),
                            pessoa.get());

    }

    public Optional<Endereco> buscarEndereco(Long pessoaId) {
        return enderecoRepository.findById(pessoaId);
    }
}
