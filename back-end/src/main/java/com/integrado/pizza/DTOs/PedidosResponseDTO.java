package com.integrado.pizza.DTOs;

import java.time.LocalDateTime;

public record PedidosResponseDTO(Long idPedido, LocalDateTime dataPedido, Long idCliente, Long idEnderecoEntrega) {
}
