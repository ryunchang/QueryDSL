create sequence hibernate_sequence;


create table IF NOT EXISTS tb_product
(
    id          bigint          not null,
    name        varchar(255)    not null,
    price       int             not null,
    category    varchar(255)    not null
);


