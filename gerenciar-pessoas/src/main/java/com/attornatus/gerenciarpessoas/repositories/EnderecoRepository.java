package com.attornatus.gerenciarpessoas.repositories;

import com.attornatus.gerenciarpessoas.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
