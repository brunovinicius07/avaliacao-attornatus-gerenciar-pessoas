package com.attornatus.gerenciarpessoas.services;

import com.attornatus.gerenciarpessoas.dtos.PessoaDto;
import com.attornatus.gerenciarpessoas.entities.Pessoa;
import com.attornatus.gerenciarpessoas.repositories.EnderecoRepository;
import com.attornatus.gerenciarpessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

   @Transactional
    public Pessoa cadastrarPessoa(PessoaDto pessoaDto){
        Pessoa pessoa = pessoaRepository.save(converteObjetoDto(pessoaDto));
        return pessoa;
    }

    @Transactional
    public Pessoa editarPessoa(PessoaDto pessoaDto, Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
        if(pessoa == null){
            throw new RuntimeException("Pessoa não encontrada");
        }
        pessoa.setNome(pessoaDto.getNome());
        pessoa.setDataNascimento(pessoaDto.getDataNascimento());
        pessoaRepository.save(pessoa);
        return pessoa;
    }
    public Pessoa converteObjetoDto(PessoaDto pessoaDto){
            return new Pessoa(pessoaDto.getNome(),
                    pessoaDto.getDataNascimento());
        }

    public Pessoa buscarPessoaPorId(Long pessoaId) {
       Pessoa pessoa = pessoaRepository.findById(pessoaId).orElse(null);
        if(pessoa == null){
            throw new RuntimeException("Pessoa não encontrada");
        }
        return pessoa;
    }

    public List<Pessoa> buscarPessoas() {
       return pessoaRepository.findAll();
    }
}
