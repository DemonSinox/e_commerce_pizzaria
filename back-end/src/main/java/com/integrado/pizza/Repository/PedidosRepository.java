package com.integrado.pizza.Repository;

import com.integrado.pizza.Model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    // Interface de repositório para Pedidos, herda operações CRUD do JpaRepository.
}
