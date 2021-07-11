DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigint, title VARCHAR(255), price FLOAT, PRIMARY KEY (id));
INSERT INTO products (id, title, price) VALUES (1, 'Celery', 50.32), (2, 'Parsley', 30.11), (3, 'Fennel', 10), (4, 'Coriander', 46.7);