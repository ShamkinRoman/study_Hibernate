--create table body
create table body (
    id serial primary key,
    nameBody varchar(200)
);

--create table engine
create table engine(
    id serial primary key,
    nameEngine varchar(200)
);

--create table kpp
create table kpp (
    id serial primary key,
    nameKpp varchar(200)
);

--create table car
create table car(
    id serial primary key,
    nameCar varchar(200),
    body_id integer references body(id),
    engine_id integer references engine(id),
    kpp_id integer references kpp(id)
);

--fill tables body, engine, kpp, car

insert into body (nameBody) values ('sedan');
insert into body (nameBody) values ('hachback');

insert into engine(nameEngine) values ('V-1 111 cm');
insert into engine(nameEngine) values ('V-2 222 cm');
insert into engine(nameEngine) values ('V-3 333 cm');

insert into kpp (nameKpp) values ('automatic');
insert into kpp (nameKpp) values ('mechanical');

insert into car(nameCar, body_id, engine_id, kpp_id) values ('TOYOTA-ONE', 2, 3, 1);