# E-commerce de Pizzaria

Este projeto é um sistema de e-commerce para uma pizzaria, desenvolvido com **Java**, **Spring Boot**, **MySQL** e **API RESTful**. O objetivo é criar uma plataforma para realizar pedidos de pizzas, gerenciar clientes, endereços, pagamentos e auditoria de preços.

## Funcionalidades

- **Cadastro de Clientes**: Cadastro de novos clientes com informações como nome, email, telefone e CPF.
- **Gestão de Endereços**: Cada cliente pode ter múltiplos endereços cadastrados.
- **Cadastro de Produtos**: Cadastro de produtos como pizzas, bebidas, etc., com nome, descrição e preço.
- **Realização de Pedidos**: Clientes podem realizar pedidos, associando-os a um endereço de entrega e pagando por eles.
- **Gestão de Pagamentos**: Integração de formas de pagamento (ex: Cartão de Crédito, Boleto).
- **Auditoria de Preços**: Histórico de alterações de preços dos produtos.
- **API RESTful**: Comunicação via API para permitir interação com o front-end ou outros sistemas.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Framework para desenvolvimento da aplicação)
- **Spring Data JPA** (ORM para integração com o banco de dados MySQL)
- **MySQL** (Banco de dados relacional)
- **Postman** (Para testes da API)

## Ferramentas Utilizadas

- **XAMPP**: Para rodar o MySQL localmente.
- **DBeaver**: Para gerenciar o banco de dados MySQL.
- **IntelliJ IDEA**: IDE para desenvolvimento Java e Spring Boot.

## Estrutura do Projeto

O projeto é dividido em três camadas principais:

1. **Modelo**: Representação das tabelas no banco de dados.
2. **Repositório**: Interfaces para interação com o banco de dados (utilizando JPA).
3. **Serviço**: Contém a lógica de negócios.
4. **Controlador**: Expõe a API RESTful para interação com o cliente.

## Como Executar o Projeto

### Pré-requisitos

Antes de executar o projeto, é necessário:

1. Ter o **Java 17** ou superior instalado.
2. Ter o **MySQL** instalado e configurado via **XAMPP**.
3. Ter o **Postman** ou qualquer outro cliente HTTP para testar a API.

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/ecommerce-pizzaria.git
