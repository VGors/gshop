DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigint, title VARCHAR(255), price FLOAT, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Celery', 50.32);
INSERT INTO products (title, price) VALUES ('Parsley', 30.11);
INSERT INTO products (title, price) VALUES ('Fennel', 10);
INSERT INTO products (title, price) VALUES ('Coriander', 46.7);