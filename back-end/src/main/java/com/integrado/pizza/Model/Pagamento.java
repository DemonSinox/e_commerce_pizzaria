package com.integrado.pizza.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedidos id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento", nullable = false)
    private FormaPagamento id_forma_pagamento;

    @Column(name = "valor_total",nullable = false)
    private Double valor_total;

    @Column(name = "data_pagamento", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime data_pagamento;

    public LocalDateTime getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDateTime data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public FormaPagamento getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(FormaPagamento id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public Pedidos getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedidos id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Long getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(Long id_pagamento) {
        this.id_pagamento = id_pagamento;
    }
}