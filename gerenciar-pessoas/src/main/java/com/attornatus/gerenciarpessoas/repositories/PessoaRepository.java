package com.attornatus.gerenciarpessoas.repositories;

import com.attornatus.gerenciarpessoas.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
