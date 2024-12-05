package com.integrado.pizza.DTOs;
import java.time.LocalDateTime;

public record PagamentoResponseDTO(Long idPagamento, Long idPedido, Long idFormaPagamento, Double valorTotal, LocalDateTime dataPagamento) {
}
