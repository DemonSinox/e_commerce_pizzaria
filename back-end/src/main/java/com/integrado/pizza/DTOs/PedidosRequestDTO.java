package com.integrado.pizza.DTOs;

import java.time.LocalDateTime;

public record PedidosRequestDTO( LocalDateTime dataPedido, Long idCliente, Long idEnderecoEntrega) { }