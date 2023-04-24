drop database digitalmenu;
create database digitalmenu;
use digitalmenu;

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
id INTEGER primary key auto_increment,
idPedido INTEGER,
preco DECIMAL(5,2),
#FOREIGN KEY(id) REFERENCES Produto (id),
FOREIGN KEY(idPedido) REFERENCES pedido(idPedido)
);

CREATE TABLE usuario(
idUsuario INTEGER primary key auto_increment,
usuario varchar(50),
acesso varchar(30),
senha varchar(50)
);

select * from produto;
insert into Produto values (default,"Shiitake Fresco",72,"Queijo Mussarela,Shiitake","Pizza"),
(default,"Quatro Queijos",55,"Queijo Mussarela,Queijo ParmesÃ£o,Queijo Provolone, Queijo Gorgonzola","Pizza"),
(default,"Frango com Catupiry",40,"Frango desfiado, Queijo Catupiry","Pizza");

insert into usuario values (1, 'Admin', 'admin', 'Admin');
insert into mesa values (1);
#insert into pedido values (default, default, default, 1);
#insert into carrinho select null,1,preco from produto where produto.id = 3;
					   #codpruto/idpedido                                #produto
                       
#insert into carrinho select null,1,preco from produto where produto.id = 2;

select * from carrinho;
select * from pedido;
select * from mesa;
select * from produto;
select * from usuario;
describe carrinho;
describe pedido;


DELIMITER //
create trigger atualizacaoPreco after insert on carrinho
for each row begin
	update pedido set precoTotal = (select sum(carrinho.preco) from carrinho where carrinho.idPedido = pedido.idPedido);
end//

select carrinho.idPedido,produto.nome from carrinho join produto on produto.id = carrinho.id where carrinho.idPedido = 1;