delete
from car;
delete
from body;
delete
from kpp;
delete
from engine;

insert into body (nameBody)
values ('седан');
insert into body (nameBody)
values ('хэчбэк');
insert into body (nameBody)
values ('универсал');

insert into engine(nameEngine)
values ('бензин');
insert into engine(nameEngine)
values ('дизель');
insert into engine(nameEngine)
values ('гибрид');

insert into kpp (nameKpp)
values ('автомат');
insert into kpp (nameKpp)
values ('механическая');

-- insert into car(nameCar, body_id, engine_id, kpp_id) values ('TOYOTA-ONE', 2, 3, 1);

create table customer
(
  id               serial primary key,
  nameCustomer     varchar(200),
  passwordCustomer varchar(200)
);

insert into customer (nameCustomer, passwordCustomer)
values ('root', 'root');


create table finishcar
(
  id      serial primary key,
  done    boolean,
  user_id integer references customer (id),
  car_id  integer references car (id)
);

insert into finishcar(done, user_id, car_id) VALUES (true, 1, 57);


--create table item
create table item(
                  id serial primary key,
                  nameCar varchar(200),
                  body varchar(200),
                  engine varchar(200),
                  transmission varchar(200),
                  done boolean,
                  customer_id integer references customer(id)
                 );

insert into item(nameCar, body, engine, transmission, done, customer_id) VALUES ('Toto', 'Хэчбек', 'механика', 'автомат', false, 1 );