DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigint, title VARCHAR(255), price FLOAT, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Celery', 50.32), ('Parsley', 30.11), ('Fennel', 10), ('Coriander', 46.7);