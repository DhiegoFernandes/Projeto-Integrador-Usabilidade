DROP database IF EXISTS digitalmenu;
create database digitalmenu;
use digitalmenu;

CREATE TABLE USUARIO (
    IDUSUARIO INT AUTO_INCREMENT PRIMARY KEY,
    USUARIO VARCHAR(30) NOT NULL,
    SENHA VARCHAR(30) NOT NULL,
    TIPOACESSO enum('administrador','atendente') NOT NULL,
    STATUS enum('ATIVADO','DESATIVADO') NOT NULL DEFAULT 'ATIVADO'
);
CREATE TABLE MESA (
    IDMESA INT PRIMARY KEY,
    STATUS enum('ATIVADO','DESATIVADO') NOT NULL DEFAULT 'ATIVADO'
);
CREATE TABLE PEDIDO (
    IDPEDIDO INT AUTO_INCREMENT PRIMARY KEY,
    ID_MESA INT NOT NULL,
    TOTAL DECIMAL(7,2) NOT NULL DEFAULT 0.0, 
    DATA DATETIME NOT NULL DEFAULT NOW(),
    STATUS ENUM('ABERTO','ENCERRADO','CANCELADO') NOT NULL DEFAULT 'ABERTO'
);
CREATE TABLE PRODUTO (
    IDPRODUTO INT AUTO_INCREMENT PRIMARY KEY,
    NOME VARCHAR(30) UNIQUE NOT NULL,
    PRECO DECIMAL(7,2) NOT NULL,
    DESCRICAO VARCHAR(200),
    ID_CATEGORIA INT NOT NULL,
    STATUS enum('ATIVADO','DESATIVADO') NOT NULL DEFAULT 'ATIVADO'
);
CREATE TABLE ITEM ( 
    ID_PEDIDO INT NOT NULL,
    ID_PRODUTO INT NOT NULL,
    QTDE INT NOT NULL,
    SUBTOTAL DECIMAL(7,2) NOT NULL DEFAULT 0.0,
    OBSERVACAO VARCHAR(30), 
    STATUS enum('CONFIRMADO','CANCELADO') NOT NULL DEFAULT 'CONFIRMADO',
    HORAPEDIDO TIME NOT NULL DEFAULT (CURTIME())
);
CREATE TABLE CATEGORIA (
    IDCATEGORIA INT AUTO_INCREMENT PRIMARY KEY,
    NOME varchar(30) UNIQUE NOT NULL,
    STATUS enum('ATIVADO','DESATIVADO') NOT NULL DEFAULT 'ATIVADO'
);

ALTER TABLE PEDIDO ADD CONSTRAINT FK_PEDIDO_MESA
    FOREIGN KEY (ID_MESA)
    REFERENCES MESA (IDMESA)
    ON DELETE CASCADE ON UPDATE CASCADE;
 
ALTER TABLE PRODUTO ADD CONSTRAINT FK_PRODUTO_CATEGORIA
    FOREIGN KEY (ID_CATEGORIA)
    REFERENCES CATEGORIA (IDCATEGORIA)
    ON DELETE CASCADE ON UPDATE CASCADE;
 
ALTER TABLE ITEM ADD CONSTRAINT FK_PEDIDO
    FOREIGN KEY (ID_PEDIDO)
    REFERENCES PEDIDO (IDPEDIDO);
 
ALTER TABLE ITEM ADD CONSTRAINT FK_PRODUTO
    FOREIGN KEY (ID_PRODUTO)
    REFERENCES PRODUTO (IDPRODUTO);
    
INSERT INTO categoria (idcategoria, nome) VALUES 
(1, 'Pastel'),
(2, 'Bebida')
;

insert into usuario values(null, 'admin','admin','administrador',default);   
insert into usuario values(null, 'atendente','atendente','atendente',default);

INSERT INTO mesa VALUES (10, default);

INSERT INTO produto (idproduto, nome, preco, descricao, id_categoria, status)
VALUES
(1, 'pastel de carne', 8.00, 'carne moida', 1, default),
(2, 'pastel de queijo', 8.00, 'mussarela', 1, default),
(3, 'pastel de frango', 8.00, 'frango e catupiry', 1, default),
(4, 'pastel de calabresa', 8.00, 'calabresa moida', 1, default),
(5, 'pastel de calabresa com queijo', 10.00, 'calabresa moida e mussarela', 1, default),
(6, 'pastel de carne com queijo', 10.00, 'carne moida e mussarela', 1, default),
(7, 'pastel de camarao', 14.00, 'camarao e catupiry', 1, default),
(8, 'pastel de pizza', 8.00, 'Mussarela, oregano e tomate', 1, default),
(9, 'pastel Especial', 18.00, 'carne moida, calabresa, mussarela, ovo, tomate, palmito e ervilha', 1, default),
(10, 'pastel de vento', 3.00, 'Massa frita crocante', 1, default)
;

INSERT INTO produto (idproduto, nome, preco, descricao, id_categoria, status)
VALUES
(11, 'Coca-Cola', 6.00, 'Lata 350ml', 2, default),
(12, 'Pepsi-Cola', 5.00, 'Lata 350ml', 2, default),
(13, 'Dolly-Cola', 3.50, 'Lata 350ml', 2, default),
(14, 'Conti-Cola', 3.00, 'Lata 350ml', 2, default),
(15, 'Guarana', 6.00, 'Lata 350ml', 2, default),
(16, 'Fanta Uva', 6.00, 'Lata 350ml', 2, default),
(17, 'Fanta Laranja', 6.00, 'Lata 350ml', 2, default),
(18, 'H2OH', 5.00, 'Garrafa 500ml', 2, default),
(19, 'Sprite', 6.00, 'Lata 350ml', 2, default),
(20, 'Sukita Laranja', 3.99, 'Lata 350ml', 2, default)
;

/*
Categoria: arrumar a tela de categoria adicionando campo desativar/ativar
Pedidos: falta terminar
item: juntar com o do wil
*/

select * from item;
select * from pedido;
insert into pedido values (default, 10, default, default, default);
insert into item values (1,       1,      2,   0.50, 'asdsa', default, default); 


