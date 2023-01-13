package com.attornatus.gerenciarpessoas.repositories;

import com.attornatus.gerenciarpessoas.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PesssoaRepository extends JpaRepository<Pessoa, Long> {
}
