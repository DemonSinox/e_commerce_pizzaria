-- triger de autitoria de preços 

DELIMITER //

CREATE TRIGGER AtualizarAuditoriaPrecos
AFTER UPDATE ON Produtos
FOR EACH ROW
BEGIN
    IF OLD.preco != NEW.preco THEN
        INSERT INTO AuditoriaPrecos (id_produto, preco_antigo, preco_novo, data_alteracao)
        VALUES (NEW.id_produto, OLD.preco, NEW.preco, NOW());
    END IF;
END //

DELIMITER ;