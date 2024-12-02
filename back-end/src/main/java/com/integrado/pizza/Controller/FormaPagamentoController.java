package com.integrado.pizza.Controller;

import com.integrado.pizza.DTOs.FormaPagamentoRequestDTO;
import com.integrado.pizza.DTOs.FormaPagamentoResponseDTO;
import com.integrado.pizza.Model.FormaPagamento;
import com.integrado.pizza.Repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository repository;

    @GetMapping // Mapeia requisições GET para /api/formas-pagamento.
    public ResponseEntity<List<FormaPagamentoResponseDTO>> findAll() {
        List<FormaPagamento> formasPagamento = this.repository.findAll(); // Busca todas as formas de pagamento no banco de dados.
        List<FormaPagamentoResponseDTO> formaPagamentoDTOs = formasPagamento.stream()
                .map(formaPagamento -> new FormaPagamentoResponseDTO(
                        formaPagamento.getId_forma_pagamento(),
                        formaPagamento.getDescricao()))
                .collect(Collectors.toList()); // Converte a lista de formas de pagamento para uma lista de FormaPagamentoResponseDTO.
        return ResponseEntity.ok(formaPagamentoDTOs); // Retorna a lista de formas de pagamento com status OK (200).
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /api/formas-pagamento/{id}.
    public ResponseEntity<FormaPagamentoResponseDTO> findById(@PathVariable Long id) {
        FormaPagamento formaPagamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Forma de pagamento não encontrada com id: " + id)); // Busca uma forma de pagamento pelo ID.
        FormaPagamentoResponseDTO formaPagamentoDTO = new FormaPagamentoResponseDTO(
                formaPagamento.getId_forma_pagamento(),
                formaPagamento.getDescricao()); // Converte a forma de pagamento para FormaPagamentoResponseDTO.
        return ResponseEntity.ok(formaPagamentoDTO); // Retorna a forma de pagamento encontrada com status OK (200).
    }

    @PostMapping // Mapeia requisições POST para /api/formas-pagamento.
    public FormaPagamentoResponseDTO createFormaPagamento(@RequestBody FormaPagamentoRequestDTO dto) {
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setDescricao(dto.descricao());

        FormaPagamento savedFormaPagamento = repository.save(formaPagamento); // Cria uma nova forma de pagamento e salva no banco de dados.
        return new FormaPagamentoResponseDTO(
                savedFormaPagamento.getId_forma_pagamento(),
                savedFormaPagamento.getDescricao()); // Converte a forma de pagamento salva para FormaPagamentoResponseDTO e retorna.
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /api/formas-pagamento/{id}.
    public ResponseEntity<FormaPagamentoResponseDTO> updateFormaPagamento(@PathVariable Long id, @RequestBody FormaPagamentoRequestDTO dto) {
        FormaPagamento formaPagamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Forma de pagamento não encontrada com id: " + id)); // Busca a forma de pagamento pelo ID.

        formaPagamento.setDescricao(dto.descricao());

        FormaPagamento updatedFormaPagamento = repository.save(formaPagamento); // Salva as alterações na forma de pagamento.
        return ResponseEntity.ok(new FormaPagamentoResponseDTO(
                updatedFormaPagamento.getId_forma_pagamento(),
                updatedFormaPagamento.getDescricao())); // Converte a forma de pagamento atualizada para FormaPagamentoResponseDTO e retorna.
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /api/formas-pagamento/{id}.
    public ResponseEntity<Void> deleteFormaPagamento(@PathVariable Long id) {
        FormaPagamento formaPagamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Forma de pagamento não encontrada com id: " + id)); // Busca a forma de pagamento pelo ID.

        repository.delete(formaPagamento); // Exclui a forma de pagamento do banco de dados.
        return ResponseEntity.noContent().build(); // Retorna status No Content (204).
    }
}
