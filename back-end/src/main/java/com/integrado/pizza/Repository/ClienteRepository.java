package com.integrado.pizza.Repository;

import com.integrado.pizza.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}
