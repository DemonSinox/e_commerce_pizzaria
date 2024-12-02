package com.integrado.pizza.Model;

import java.io.Serializable;
import java.util.Objects;

public class ProdutoPedidoId implements Serializable {
    private Long produto;
    private Long pedido;

    // Getters, Setters, equals() e hashCode()
    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoPedidoId that = (ProdutoPedidoId) o;
        return Objects.equals(produto, that.produto) &&
                Objects.equals(pedido, that.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, pedido);
    }
}
