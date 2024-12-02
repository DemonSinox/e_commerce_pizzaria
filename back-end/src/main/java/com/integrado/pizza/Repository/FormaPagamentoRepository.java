package com.integrado.pizza.Repository;

import com.integrado.pizza.Model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
    // Interface de repositório para FormaPagamento, herda operações CRUD do JpaRepository.
}
