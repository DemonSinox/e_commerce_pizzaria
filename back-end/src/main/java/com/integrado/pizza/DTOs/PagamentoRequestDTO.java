package com.integrado.pizza.DTOs;
import java.time.LocalDateTime;

public record PagamentoRequestDTO(Long idPedido, Long idFormaPagamento, Double valorTotal, LocalDateTime dataPagamento) { }