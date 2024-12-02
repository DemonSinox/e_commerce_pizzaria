package com.integrado.pizza.DTOs;

public record EnderecoRequestDTO(String descricaoLocal, String numero, String bairro, String cidade, String estado, String cep, String complemento) {
}
