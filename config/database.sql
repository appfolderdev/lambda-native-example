create schema if not exists vdi;

create table if not exists vdi.users
(
    id_user       bigserial,
    email         varchar(255),
    full_name     varchar(255)
);

INSERT INTO vdi.users (id_user, email, full_name)
VALUES (1, 'jonas@arlequim.com.br', 'Joao da Silva');
