create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       float,
    category_id bigint references categories (id)
);
insert into products (title, price, category_id)
values ('Celery', 50.32, 1),
       ('Parsley', 30.11, 1),
       ('Fennel', 10, 1),
       ('Pork', 27.8, 1),
       ('Bread', 9, 1),
       ('Lamb', 44.1, 1),
       ('Eggs', 53, 1),
       ('Plastic shelf', 18.5, 2),
       ('Wooden chair', 100.8, 2),
       ('Cupboard', 784, 2),
       ('Wooden table', 223.12, 2),
       ('Matches', 0.99, 3),
       ('Turkey', 88.6, 1),
       ('Pillow', 101.3, 2),
       ('Truffle', 100, 1),
       ('Chicken', 50.7, 1),
       ('Beef', 76.2, 1),
       ('Milk', 24.1, 1),
       ('Wooden bed', 1000, 2),
       ('Coriander', 46.7, 1);