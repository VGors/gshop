create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       float
);
insert into products (title, price)
values ('Celery', 50.32),
       ('Parsley', 30.11),
       ('Fennel', 10),
       ('Pork', 27.8),
       ('Bread', 9),
       ('Lamb', 44.1),
       ('Eggs', 53),
       ('Plastic shelf', 18.5),
       ('Wooden chair', 100.8),
       ('Cupboard', 784),
       ('Wooden table', 223.12),
       ('Matches', 0.99),
       ('Turkey', 88.6),
       ('Pillow', 101.3),
       ('Truffle', 100),
       ('Chicken', 50.7),
       ('Beef', 76.2),
       ('Milk', 24.1),
       ('Wooden bed', 1000),
       ('Coriander', 46.7);