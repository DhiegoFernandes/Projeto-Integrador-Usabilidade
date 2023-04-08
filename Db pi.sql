drop database PiPizzaria;
create database PiPizzaria;
use PiPizzaria;

CREATE TABLE Produto (
id INTEGER PRIMARY KEY not null auto_increment,
nome VARCHAR(50),
preco DECIMAL(5,2),
descricao VARCHAR(100),
categoria VARCHAR(20)
);

CREATE TABLE mesa (
idMesa INTEGER PRIMARY KEY
);

CREATE TABLE pedido (
idPedido INTEGER PRIMARY KEY auto_increment,
status VARCHAR(10) default "Aberto",
precoTotal DECIMAL(7,2),
idMesa INTEGER,
FOREIGN KEY(idMesa) REFERENCES mesa (idMesa)
);

CREATE TABLE Carrinho (
id INTEGER,
idPedido INTEGER,
preco DECIMAL(5,2),
FOREIGN KEY(id) REFERENCES Produto (id),
FOREIGN KEY(idPedido) REFERENCES pedido (idPedido)
);

select * from produto;
insert into Produto values (default,"Shiitake Fresco",72,"Queijo Mussarela,Shiitake","Pizza"),
(default,"Quatro Queijos",55,"Queijo Mussarela,Queijo ParmesÃ£o,Queijo Provolone, Queijo Gorgonzola","Pizza"),
(default,"Frango com Catupiry",40,"Frango desfiado, Queijo Catupiry","Pizza");

insert into mesa values (1);
insert into pedido values (default, default, default, 1);
insert into carrinho select 1,1,preco from produto where produto.id = 2;
					   #codpruto/codpedido                         #produto

select * from carrinho;
select * from pedido;
select * from mesa;
select * from produto;
describe carrinho;




DELIMITER //
create trigger atualizacaoPreco after insert on carrinho
for each row begin
	update pedido set precoTotal = (select sum(carrinho.preco) from carrinho where carrinho.idPedido = pedido.idPedido);
end//

select carrinho.idPedido,produto.nome from carrinho join produto on produto.id = carrinho.id where carrinho.idPedido = 1;