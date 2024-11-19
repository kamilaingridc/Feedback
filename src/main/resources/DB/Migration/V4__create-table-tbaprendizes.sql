
    create table tbaprendizes (
        id integer not null auto_increment,
        ativo bit not null,
        curso enum ('ADM','DS','MANUFATURA','MECATRONICA'),
        edv varchar(255),
        email varchar(255),
        ferias bit not null,
        faculdade varchar(255),
        trilha varchar(255),
        turma varchar(255),
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;
