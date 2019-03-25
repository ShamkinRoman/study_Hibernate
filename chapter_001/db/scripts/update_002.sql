--create table body
create table body (
    id serial primary key,
    nameBody varchar(200),
    UNIQUE (nameBody)
);

--create table engine
create table engine(
    id serial primary key,
    nameEngine varchar(200),
    unique (nameEngine)
);

--create table kpp
create table kpp (
    id serial primary key,
    nameKpp varchar(200),
    UNIQUE (nameKpp)
);

--create table car
create table car(
    id serial primary key,
    nameCar varchar(200),
    body_id integer references body(id),
    engine_id integer references engine(id),
    kpp_id integer references kpp(id)
);
--create table customer
create table customer
(
  id               serial primary key,
  nameCustomer     varchar(200),
  passwordCustomer varchar(200),
  UNIQUE (nameCustomer)
);

create table finishcar
(
  id      serial primary key,
  done    boolean,
  user_id integer references customer (id),
  car_id  integer references car (id),
  linkToFile varchar (2000)
);

--fill tables body, engine, kpp, car

insert into body (nameBody) values ('sedan');
insert into body (nameBody) values ('hatchback');
insert into body (nameBody) values ('estate');

insert into engine(nameEngine) values ('gasoline');
insert into engine(nameEngine) values ('diesel');
insert into engine(nameEngine) values ('hybrid');

insert into kpp (nameKpp) values ('auto');
insert into kpp (nameKpp) values ('mechanical');

insert into customer (nameCustomer, passwordCustomer) values ('root', 'root');
