create table categories
(
    id    bigserial primary key,
    title varchar(255)
);
insert into categories (title)
values ('Food'),
       ('Furniture'),
       ('Chandlery');

