CREATE DATABASE crudEventos
use crudEventos
 
CREATE TABLE evento
(
codigo      INT         NOT NULL, 
nome    VARCHAR(100)    NOT NULL, 
data     VARCHAR(100)    NOT NULL,
hora    VARCHAR(100)    NOT NULL, 
rua     VARCHAR(100)    NOT NULL, 
numero  INT             NOT NULL, 
uf      VARCHAR(100)    NOT NULL, 
PRIMARY KEY(codigo)
)

CREATE TABLE ingresso
(
codigo          INT             NOT NULL,
codigoEvento    INT             NOT NULL,
tipo        VARCHAR(50)     NOT NULL,
preco       DECIMAL(7,2)    NOT NULL,
PRIMARY KEY(codigo),
FOREIGN KEY(codigoEvento) REFERENCES evento(codigo)
)

CREATE TABLE caravana
(
codigo      INT             NOT NULL,
nome        VARCHAR(50)		NOT NULL,     
capacidade	INT				NOT NULL,				
preco		DECIMAL(7,2)	NOT NULL,	
uf			VARCHAR(10)		NOT NULL,	
PRIMARY KEY(codigo)
)

CREATE TABLE compra
(
codigo              INT                 NOT NULL,
nome            VARCHAR(100)        NOT NULL,
email           VARCHAR(100)        NOT NULL,
codigoEvento		INT				NOT NULL,
codigoCaravana      INT				NOT NULL,
PRIMARY KEY(codigo),
FOREIGN KEY(codigoEvento)   REFERENCES evento(codigo),
FOREIGN KEY(codigoCaravana) REFERENCES caravana(codigo)
)

CREATE TABLE programacao
(
codigo int not null,
codigoEvento int not null,
horario varchar(100) not null,
nome varchar(100) not null
primary key(codigo),
foreign key(codigoEvento) references evento(codigo)
)
