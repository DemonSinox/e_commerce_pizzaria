-- procedure para inserir pedidos 

DELIMITER //

CREATE PROCEDURE InserirPedido(
    IN p_id_cliente INT,
    IN p_id_endereco_entrega INT,
    IN p_status ENUM('Pendente', 'Em preparo', 'Finalizado', 'Cancelado')
)
BEGIN
    INSERT INTO Pedidos (id_cliente, id_endereco_entrega, status)
    VALUES (p_id_cliente, p_id_endereco_entrega, p_status);
END //

DELIMITER ;
