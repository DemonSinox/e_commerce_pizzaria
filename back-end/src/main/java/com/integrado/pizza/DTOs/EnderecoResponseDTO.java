package com.integrado.pizza.DTOs;

public record EnderecoResponseDTO(Long id, String descricaoLocal, String numero, String bairro, String cidade, String estado, String cep, String complemento) {
}
