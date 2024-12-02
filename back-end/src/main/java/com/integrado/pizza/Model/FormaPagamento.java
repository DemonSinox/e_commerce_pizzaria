package com.integrado.pizza.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_forma_pagamento;

    @Column(nullable = false, length = 50)
    private String descricao;

    public Long getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(Long id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
