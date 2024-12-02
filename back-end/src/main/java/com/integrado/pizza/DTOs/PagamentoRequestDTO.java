package com.integrado.pizza.DTOs;

import com.integrado.pizza.Model.StatusPagamento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PagamentoRequestDTO(Long idPedido, Long idFormaPagamento, Double valorTotal, StatusPagamento status, LocalDateTime dataPagamento) { }