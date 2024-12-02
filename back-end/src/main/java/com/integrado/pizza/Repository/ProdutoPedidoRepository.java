package com.integrado.pizza.Repository;

import com.integrado.pizza.Model.ProdutoPedido;
import com.integrado.pizza.Model.ProdutoPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, ProdutoPedidoId> {
    // Interface de repositório para ProdutoPedido, herda operações CRUD do JpaRepository.
}
