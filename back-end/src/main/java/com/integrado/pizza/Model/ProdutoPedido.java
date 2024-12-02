package com.integrado.pizza.Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto_pedido")
@IdClass(ProdutoPedidoId.class) // Define a classe da chave primária composta.
public class ProdutoPedido implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produtos produto;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedidos pedido;

    @Column(nullable = false)
    private int quantidade;

    // Getters e Setters
    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
