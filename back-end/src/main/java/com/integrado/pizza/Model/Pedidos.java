package com.integrado.pizza.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedidos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente id_cliente;

    @Column(name = "data_pedido", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime data_pedido;

    @ManyToOne
    @JoinColumn(name = "id_endereco_entrega", nullable = false)
    private Endereco id_endereco_entrega;

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDateTime getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDateTime data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Endereco getId_endereco_entrega() {
        return id_endereco_entrega;
    }

    public void setId_endereco_entrega(Endereco id_endereco_entrega) {
        this.id_endereco_entrega = id_endereco_entrega;
    }
}

