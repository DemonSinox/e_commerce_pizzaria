DELIMITER //

CREATE or replace PROCEDURE FiltrarPorCategoria(
    IN p_categoria VARCHAR(50)
)
BEGIN
    SELECT 
        p.id_produto, 
        p.nome, 
        p.descricao, 
        p.preco, 
        c.descricao
    FROM 
        Produtos p
    LEFT JOIN 
        Categoria c ON p.id_categoria = c.id_categoria
    WHERE 
        c.descricao = p_categoria
    ORDER BY 
        p.nome ASC;
END //

DELIMITER ;

-- chamada 
CALL FiltrarPorCategoria('Pizza');