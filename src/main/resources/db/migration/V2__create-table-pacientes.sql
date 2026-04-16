create table paciente(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(11) not null,
    cpf varchar(11) not null unique,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    cidade varchar(20) not null,
    uf varchar(20) not null,
    complemento varchar(100),
    numero char(2),

    primary key(id)
);