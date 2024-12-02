package com.integrado.pizza.Controller;

import com.integrado.pizza.DTOs.PagamentoRequestDTO;
import com.integrado.pizza.DTOs.PagamentoResponseDTO;
import com.integrado.pizza.Model.Pagamento;
import com.integrado.pizza.Model.Pedidos;
import com.integrado.pizza.Model.FormaPagamento;
import com.integrado.pizza.Repository.PagamentoRepository;
import com.integrado.pizza.Repository.PedidosRepository;
import com.integrado.pizza.Repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @GetMapping // Mapeia requisições GET para /api/pagamentos.
    public ResponseEntity<List<PagamentoResponseDTO>> findAll() {
        List<Pagamento> pagamentos = this.pagamentoRepository.findAll(); // Busca todos os pagamentos no banco de dados.
        List<PagamentoResponseDTO> pagamentoDTOs = pagamentos.stream()
                .map(pagamento -> new PagamentoResponseDTO(
                        pagamento.getId_pagamento(),
                        pagamento.getId_pedido().getId_pedido(),
                        pagamento.getId_forma_pagamento().getId_forma_pagamento(),
                        pagamento.getValor_total(),
                        pagamento.getData_pagamento()))
                .collect(Collectors.toList()); // Converte a lista de pagamentos para uma lista de PagamentoResponseDTO.
        return ResponseEntity.ok(pagamentoDTOs); // Retorna a lista de pagamentos com status OK (200).
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /api/pagamentos/{id}.
    public ResponseEntity<PagamentoResponseDTO> findById(@PathVariable Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com id: " + id)); // Busca um pagamento pelo ID.
        PagamentoResponseDTO pagamentoDTO = new PagamentoResponseDTO(
                pagamento.getId_pagamento(),
                pagamento.getId_pedido().getId_pedido(),
                pagamento.getId_forma_pagamento().getId_forma_pagamento(),
                pagamento.getValor_total(),
                pagamento.getData_pagamento()); // Converte o pagamento para PagamentoResponseDTO.
        return ResponseEntity.ok(pagamentoDTO); // Retorna o pagamento encontrado com status OK (200).
    }

    @PostMapping // Mapeia requisições POST para /api/pagamentos.
    public PagamentoResponseDTO createPagamento(@RequestBody PagamentoRequestDTO dto) {
        Pagamento pagamento = new Pagamento();
        Pedidos pedido = pedidosRepository.findById(dto.idPedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com id: " + dto.idPedido()));
        FormaPagamento formaPagamento = formaPagamentoRepository.findById(dto.idFormaPagamento())
                .orElseThrow(() -> new IllegalArgumentException("Forma de pagamento não encontrada com id: " + dto.idFormaPagamento()));

        pagamento.setId_pedido(pedido);
        pagamento.setId_forma_pagamento(formaPagamento);
        pagamento.setValor_total(dto.valorTotal());
        pagamento.setData_pagamento(dto.dataPagamento());

        Pagamento savedPagamento = pagamentoRepository.save(pagamento); // Cria um novo pagamento e salva no banco de dados.
        return new PagamentoResponseDTO(
                savedPagamento.getId_pagamento(),
                savedPagamento.getId_pedido().getId_pedido(),
                savedPagamento.getId_forma_pagamento().getId_forma_pagamento(),
                savedPagamento.getValor_total(),
                savedPagamento.getData_pagamento()); // Converte o pagamento salvo para PagamentoResponseDTO e retorna.
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /api/pagamentos/{id}.
    public ResponseEntity<PagamentoResponseDTO> updatePagamento(@PathVariable Long id, @RequestBody PagamentoRequestDTO dto) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com id: " + id)); // Busca o pagamento pelo ID.

        Pedidos pedido = pedidosRepository.findById(dto.idPedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com id: " + dto.idPedido()));
        FormaPagamento formaPagamento = formaPagamentoRepository.findById(dto.idFormaPagamento())
                .orElseThrow(() -> new IllegalArgumentException("Forma de pagamento não encontrada com id: " + dto.idFormaPagamento()));

        pagamento.setId_pedido(pedido);
        pagamento.setId_forma_pagamento(formaPagamento);
        pagamento.setValor_total(dto.valorTotal());
        pagamento.setData_pagamento(dto.dataPagamento());

        Pagamento updatedPagamento = pagamentoRepository.save(pagamento); // Salva as alterações no pagamento.
        return ResponseEntity.ok(new PagamentoResponseDTO(
                updatedPagamento.getId_pagamento(),
                updatedPagamento.getId_pedido().getId_pedido(),
                updatedPagamento.getId_forma_pagamento().getId_forma_pagamento(),
                updatedPagamento.getValor_total(),
                updatedPagamento.getData_pagamento())); // Converte o pagamento atualizado para PagamentoResponseDTO e retorna.
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /api/pagamentos/{id}.
    public ResponseEntity<Void> deletePagamento(@PathVariable Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com id: " + id)); // Busca o pagamento pelo ID.

        pagamentoRepository.delete(pagamento); // Exclui o pagamento do banco de dados.
        return ResponseEntity.noContent().build(); // Retorna status No Content (204).
    }
}
