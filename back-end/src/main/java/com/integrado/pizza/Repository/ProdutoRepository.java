package com.integrado.pizza.Repository;

import com.integrado.pizza.Model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta interface é um repositório.
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
    // Interface de repositório para Produto, herda operações CRUD do JpaRepository.
}
