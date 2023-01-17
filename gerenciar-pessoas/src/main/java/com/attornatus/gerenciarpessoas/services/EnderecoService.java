package com.attornatus.gerenciarpessoas.services;

import com.attornatus.gerenciarpessoas.dtos.EnderecoDto;
import com.attornatus.gerenciarpessoas.entities.Endereco;
import com.attornatus.gerenciarpessoas.entities.Pessoa;
import com.attornatus.gerenciarpessoas.repositories.EnderecoRepository;
import com.attornatus.gerenciarpessoas.repositories.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EnderecoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco cadastrarEndereco(EnderecoDto enderecoDto){
        verificaEnderecoPrincipal(enderecoDto);
        Endereco endereco = enderecoRepository.save(converteObjetoDto(enderecoDto, pessoaRepository));
        return endereco;
    }

    public Endereco converteObjetoDto(EnderecoDto enderecoDto, PessoaRepository pessoaRepository){
        Optional<Pessoa> pessoa = pessoaRepository.findById(enderecoDto.getPessoaId());
        return new Endereco(enderecoDto.getLogradouro(),
                            enderecoDto.getCep(),
                            enderecoDto.getNumero(),
                            enderecoDto.getCidade(),
                            pessoa.get(),
                            enderecoDto.isEnderecoPrincipal());
    }

    public Endereco buscarEnderecoPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        if(endereco == null){
            throw new RuntimeException("Endereco não encontrado");
        }
        return endereco;
    }

    public List<Endereco> buscarTodosEnderecos(){
        return enderecoRepository.findAll();
    }

    public List<Endereco> buscarEnderecosPessoa(Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            return enderecoRepository.findAll()
                    .stream()
                    .filter(e -> e.getPessoa().getId() == id)
                    .collect(Collectors.toList());
        }else{
            return null;
        }
    }
    public void verificaEnderecoPrincipal(EnderecoDto enderecoDto){
        Endereco enderecoAntesDeSalvar = converteObjetoDto(enderecoDto, pessoaRepository);
        if(enderecoAntesDeSalvar.getEnderecoPrincipal().equals(true)){
            List<Endereco> listaDeEnderecos = buscarEnderecosPessoa(enderecoAntesDeSalvar.getPessoa().getId());
            for (Endereco enderecosDaPesoa : listaDeEnderecos){
                if (enderecosDaPesoa.getEnderecoPrincipal().equals(true)) {
                    enderecosDaPesoa.setEnderecoPrincipal(false);
                }
            }
        }
    }
}