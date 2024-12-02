package com.integrado.pizza.Repository;

import com.integrado.pizza.Model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    // Interface de repositório para Endereco, herda operações CRUD do JpaRepository.
}
