
delete  from car;
delete  from body;
delete  from kpp;
delete  from engine;

insert into body (nameBody) values ('седан');
insert into body (nameBody) values ('хэчбэк');
insert into body (nameBody) values ('универсал');

insert into engine(nameEngine) values ('бензин');
insert into engine(nameEngine) values ('дизель');
insert into engine(nameEngine) values ('гибрид');

insert into kpp (nameKpp) values ('автомат');
insert into kpp (nameKpp) values ('механическая');

-- insert into car(nameCar, body_id, engine_id, kpp_id) values ('TOYOTA-ONE', 2, 3, 1);

create table customer (
    id serial primary key,
    nameCustomer varchar(200),
    passwordCustomer varchar(200)
);

insert into customer (nameCustomer, passwordCustomer) values ('root','root');


create table finishcar(
    id serial primary key,
    user_id integer references customer(id),
    car_id integer references car(id)
);

insert into finishcar(user_id, car_id) VALUES (1,57);
