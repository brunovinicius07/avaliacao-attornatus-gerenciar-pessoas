package com.attornatus.gerenciarpessoas.services;

import com.attornatus.gerenciarpessoas.dtos.PessoaDto;
import com.attornatus.gerenciarpessoas.entities.Endereco;
import com.attornatus.gerenciarpessoas.entities.Pessoa;
import com.attornatus.gerenciarpessoas.repositories.EnderecoRepository;
import com.attornatus.gerenciarpessoas.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            //criar exception
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
       return pessoa;
    }

    public List<Pessoa> buscarPessoas() {
       return pessoaRepository.findAll();
    }
}
