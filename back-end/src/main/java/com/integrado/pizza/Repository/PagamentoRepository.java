package com.integrado.pizza.Repository;

import com.integrado.pizza.Model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    // Interface de repositório para Pagamento, herda operações CRUD do JpaRepository.
}
