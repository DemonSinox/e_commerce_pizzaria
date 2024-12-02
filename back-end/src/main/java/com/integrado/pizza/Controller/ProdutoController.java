package com.integrado.pizza.Controller;

import com.integrado.pizza.DTOs.ProdutoRequestDTO;
import com.integrado.pizza.DTOs.ProdutoResponseDTO;
import com.integrado.pizza.Model.Produtos;
import com.integrado.pizza.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping // Mapeia requisições GET para /api/produtos.
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {
        List<Produtos> produtos = this.repository.findAll(); // Busca todos os produtos no banco de dados.
        List<ProdutoResponseDTO> produtoDTOs = produtos.stream()
                .map(produto -> new ProdutoResponseDTO(
                        produto.getId_produto(),
                        produto.getNome(),
                        produto.getPreco()))
                .collect(Collectors.toList()); // Converte a lista de produtos para uma lista de ProdutoResponseDTO.
        return ResponseEntity.ok(produtoDTOs); // Retorna a lista de produtos com status OK (200).
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /api/produtos/{id}.
    public ResponseEntity<ProdutoResponseDTO> findById(@PathVariable Long id) {
        Produtos produto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com id: " + id)); // Busca um produto pelo ID.
        ProdutoResponseDTO produtoDTO = new ProdutoResponseDTO(
                produto.getId_produto(),
                produto.getNome(),
                produto.getPreco()); // Converte o produto para ProdutoResponseDTO.
        return ResponseEntity.ok(produtoDTO); // Retorna o produto encontrado com status OK (200).
    }

    @PostMapping // Mapeia requisições POST para /api/produtos.
    public ProdutoResponseDTO createProduto(@RequestBody ProdutoRequestDTO dto) {
        Produtos produto = new Produtos();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());

        Produtos savedProduto = repository.save(produto); // Cria um novo produto e salva no banco de dados.
        return new ProdutoResponseDTO(
                savedProduto.getId_produto(),
                savedProduto.getNome(),
                savedProduto.getPreco()); // Converte o produto salvo para ProdutoResponseDTO e retorna.
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /api/produtos/{id}.
    public ResponseEntity<ProdutoResponseDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO dto) {
        Produtos produto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com id: " + id)); // Busca o produto pelo ID.

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());

        Produtos updatedProduto = repository.save(produto); // Salva as alterações no produto.
        return ResponseEntity.ok(new ProdutoResponseDTO(
                updatedProduto.getId_produto(),
                updatedProduto.getNome(),
                updatedProduto.getPreco())); // Converte o produto atualizado para ProdutoResponseDTO e retorna.
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /api/produtos/{id}.
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        Produtos produto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com id: " + id)); // Busca o produto pelo ID.

        repository.delete(produto); // Exclui o produto do banco de dados.
        return ResponseEntity.noContent().build(); // Retorna status No Content (204).
    }
}
