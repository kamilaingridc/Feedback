create table tbinstrutores(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    edv varchar(100) not null,
    curso varchar(100) not null,
    disciplina varchar(100) not null,
    trilha varchar(100) not null,
    faculdade varchar(100) not null,
    turma varchar(100) not null,
    primary key(id)
);