delimiter //

create procedure CalcularTotalDoPedido ( 
	in p_id_pedido int,
	out p_total decimal (10,2)
)
BEGIN
    SELECT 
        SUM(PP.quantidade * P.preco)
    INTO 
        p_total
    FROM 
        PedidoProduto PP
    LEFT JOIN 
        Produtos P ON PP.id_produto = P.id_produto
    LEFT JOIN 
        Pedidos PD ON PP.id_pedido = PD.id_pedido
    WHERE 
        PP.id_pedido = p_id_pedido
        AND PD.status != 'Cancelado';
END //
delimiter
