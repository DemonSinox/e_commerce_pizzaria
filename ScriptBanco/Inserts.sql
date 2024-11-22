-- Inserts 

--  clientes
INSERT INTO Cliente (nome, email, telefone, cpf) 
VALUES 
    ('Lucas', 'lucas@gmail.com', '99999-1111', '123.456.789-00'),

-- endereços
INSERT INTO Endereco (id_cliente, descricaoLocal, numero, bairro, cidade, estado, cep, complemento) 
VALUES 
    (1, 'Rua das Flores', '123', 'Centro', 'São Paulo', 'SP', '01001-000', 'Apto 12'),

-- categorias
INSERT INTO Categoria (descricao) 
VALUES 
    ('Pizza'), 
    ('Bebida');
    
   
-- inserts das pizzas 
   
INSERT INTO Produtos (nome, descricao, preco, id_categoria) 
VALUES 
    ('Pizza Margherita', 'Tomate, queijo mozzarella, manjericão', 25.00, 1),
    ('Pizza Calabresa', 'Calabresa, cebola, azeitonas', 30.00, 1),
    ('Pizza Quatro Queijos', 'Mozarela, parmesão, gorgonzola, provolone', 35.00, 1),
    ('Pizza Portuguesa', 'Presunto, queijo, ovo, azeitonas, cebola, pimentão', 35.00, 1),
    ('Pizza Frango com Catupiry', 'Frango desfiado, catupiry, milho', 38.00, 1),
    ('Pizza Napolitana', 'Molho de tomate, mussarela, anchovas, manjericão', 30.00, 1),
    ('Pizza Vegetariana', 'Abobrinha, cogumelos, pimentões, cebola, tomate, rúcula', 28.00, 1),
    ('Pizza Havaiana', 'Presunto, abacaxi, queijo', 32.00, 1),
    ('Pizza Pepperoni', 'Pepperoni, queijo mozzarella, molho de tomate', 33.00, 1),
    ('Pizza Mussarela de Búfala', 'Mussarela de búfala, tomate seco, rúcula', 36.00, 1),
    ('Pizza Carbonara', 'Molho branco, bacon, queijo parmesão, ovo', 39.00, 1),
    ('Pizza Frango BBQ', 'Frango grelhado, molho barbecue, cebola roxa, milho', 40.00, 1),
    ('Pizza Rúcula com Parmesão', 'Rúcula, parmesão, tomate seco, molho de azeite', 34.00, 1),
    ('Pizza Mexicana', 'Carne moída, jalapeños, cebola roxa, milho, pimentão', 37.00, 1),
    ('Pizza Cordeiro', 'Corte de cordeiro, molho de hortelã, cebola caramelizada', 45.00, 1),
    ('Pizza Picanha', 'Picanha fatiada, queijo provolone, cebola roxa, pimentão', 48.00, 1),
    ('Pizza Berinjela e Ricota', 'Berinjela grelhada, ricota, molho de tomate, orégano', 31.00, 1),
    ('Pizza Lombo Canadense', 'Lombo canadense, queijo, milho, pimentão', 35.00, 1),
    ('Pizza Camarão e Alho', 'Camarão, alho, queijo mozzarella, molho de tomate', 50.00, 1),
    ('Pizza Toscana', 'Linguiça toscana, cebola, pimentão, queijo mozzarella', 38.00, 1);


 -- inserts de bebidas 
   
INSERT INTO Produtos (nome, descricao, preco, id_categoria) 
VALUES 
    
    ('Coca-Cola', 'Refrigerante tradicional de cola', 5.00, 2),
    ('Pepsi', 'Refrigerante de cola', 4.80, 2),
    ('Guaraná Antarctica', 'Refrigerante de guaraná', 4.50, 2),
    ('Fanta Laranja', 'Refrigerante sabor laranja', 4.50, 2),
    ('Fanta Uva', 'Refrigerante sabor uva', 4.50, 2),
    ('Sprite', 'Refrigerante sabor limão', 4.50, 2),
    ('Tônica', 'Refrigerante de quinino', 5.20, 2),
    ('Sukita', 'Refrigerante sabor laranja', 4.30, 2),
    ('Água Tônica', 'Água gaseificada com quinino', 5.20, 2),
    ('Club Social', 'Refrigerante em embalagem especial', 5.50, 2),
    ('Água Mineral (sem gás)', 'Água mineral natural sem gás', 2.50, 2),
    ('Água com Gás', 'Água mineral gaseificada', 3.00, 2),
    ('Água de Coco', 'Água de coco natural', 6.00, 2),
    ('Suco de Laranja', 'Suco natural de laranja', 7.00, 2),
    ('Suco de Limão', 'Suco natural de limão', 6.50, 2),
    ('Suco de Abacaxi', 'Suco natural de abacaxi', 7.00, 2),
    ('Suco de Manga', 'Suco natural de manga', 7.50, 2),
    ('Suco de Morango', 'Suco natural de morango', 8.00, 2),
    ('Suco de Maracujá', 'Suco natural de maracujá', 7.00, 2),
    ('Suco de Acerola', 'Suco natural de acerola', 7.50, 2),
    ('Suco de Uva', 'Suco natural de uva', 8.00, 2),
    ('Suco de Melancia', 'Suco natural de melancia', 7.50, 2),
    ('Suco de Cenoura com Laranja', 'Suco natural de cenoura com laranja', 8.50, 2),
    ('Red Bull', 'Bebida energética tradicional', 10.00, 2),
    ('Monster', 'Bebida energética potente', 9.50, 2),
    ('Burn', 'Bebida energética intensa', 9.00, 2),
    ('Chá Gelado de Limão', 'Chá gelado com sabor de limão', 6.00, 2),
    ('Chá Gelado de Pêssego', 'Chá gelado com sabor de pêssego', 6.00, 2),
    ('Chá Mate (Gelado ou Quente)', 'Chá mate tradicional', 5.50, 2),
    ('Chá Verde', 'Chá verde refrescante', 6.50, 2),
    ('Chá de Hibisco', 'Chá de hibisco com propriedades antioxidantes', 7.00, 2);
