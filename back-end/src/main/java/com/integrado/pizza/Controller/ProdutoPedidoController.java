package com.integrado.pizza.Controller;

import com.integrado.pizza.Model.ProdutoPedido;
import com.integrado.pizza.Model.ProdutoPedidoId;
import com.integrado.pizza.Repository.ProdutoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que essa classe é um controlador REST.
@RequestMapping("/api/produto-pedido") // Define a URL base para acessar este controlador.
public class ProdutoPedidoController {

    @Autowired // Injeta a dependência do repositório de ProdutoPedido.
    private ProdutoPedidoRepository repository;

    @GetMapping // Mapeia requisições GET para /api/produto-pedido.
    public ResponseEntity<List<ProdutoPedido>> findAll() {
        List<ProdutoPedido> produtoPedidos = this.repository.findAll(); // Busca todos os ProdutoPedido no banco de dados.
        return ResponseEntity.ok(produtoPedidos); // Retorna a lista de ProdutoPedido com status OK (200).
    }

    @GetMapping("/{produtoId}/{pedidoId}") // Mapeia requisições GET para /api/produto-pedido/{produtoId}/{pedidoId}.
    public ResponseEntity<ProdutoPedido> findById(@PathVariable Long produtoId, @PathVariable Long pedidoId) {
        ProdutoPedidoId id = new ProdutoPedidoId();
        id.setProduto(produtoId);
        id.setPedido(pedidoId);

        ProdutoPedido produtoPedido = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Relacionamento Produto-Pedido não encontrado com ids: " + produtoId + " e " + pedidoId)); // Busca um ProdutoPedido pela chave composta.
        return ResponseEntity.ok(produtoPedido); // Retorna o ProdutoPedido encontrado com status OK (200).
    }

    @PostMapping // Mapeia requisições POST para /api/produto-pedido.
    public ProdutoPedido createProdutoPedido(@RequestBody ProdutoPedido produtoPedido) {
        return repository.save(produtoPedido); // Cria um novo ProdutoPedido e salva no banco de dados.
    }

    @PutMapping("/{produtoId}/{pedidoId}") // Mapeia requisições PUT para /api/produto-pedido/{produtoId}/{pedidoId}.
    public ResponseEntity<ProdutoPedido> updateProdutoPedido(@PathVariable Long produtoId, @PathVariable Long pedidoId, @RequestBody ProdutoPedido produtoPedidoDetails) {
        ProdutoPedidoId id = new ProdutoPedidoId();
        id.setProduto(produtoId);
        id.setPedido(pedidoId);

        ProdutoPedido produtoPedido = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Relacionamento Produto-Pedido não encontrado com ids: " + produtoId + " e " + pedidoId)); // Busca o ProdutoPedido pela chave composta.

        produtoPedido.setQuantidade(produtoPedidoDetails.getQuantidade()); // Atualiza a quantidade.

        ProdutoPedido updatedProdutoPedido = repository.save(produtoPedido); // Salva as alterações no ProdutoPedido.
        return ResponseEntity.ok(updatedProdutoPedido); // Retorna o ProdutoPedido atualizado com status OK (200).
    }

    @DeleteMapping("/{produtoId}/{pedidoId}") // Mapeia requisições DELETE para /api/produto-pedido/{produtoId}/{pedidoId}.
    public ResponseEntity<Void> deleteProdutoPedido(@PathVariable Long produtoId, @PathVariable Long pedidoId) {
        ProdutoPedidoId id = new ProdutoPedidoId();
        id.setProduto(produtoId);
        id.setPedido(pedidoId);

        ProdutoPedido produtoPedido = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Relacionamento Produto-Pedido não encontrado com ids: " + produtoId + " e " + pedidoId)); // Busca o ProdutoPedido pela chave composta.

        repository.delete(produtoPedido); // Exclui o ProdutoPedido do banco de dados.
        return ResponseEntity.noContent().build(); // Retorna status No Content (204).
    }
}
