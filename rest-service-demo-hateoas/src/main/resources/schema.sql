CREATE DATABASE "rest-demo-hateoas"
WITH
OWNER = postgres
ENCODING = 'UTF8'
CONNECTION LIMIT = -1;


CREATE TABLE category (
  category_pk   SERIAL PRIMARY KEY,
  category_name VARCHAR(225) NOT NULL,
  category_code VARCHAR(20)  NOT NULL UNIQUE
);

CREATE TABLE product (
  product_id    SERIAL PRIMARY KEY,
  product_name  VARCHAR(225)  NOT NULL,
  product_code  VARCHAR(20)   NOT NULL,
  product_price NUMERIC(6, 1) NOT NULL,
  product_state BOOLEAN       NOT NULL,
  category_fk   INT,
  CONSTRAINT cat_fk FOREIGN KEY(category_fk) REFERENCES category (category_pk)
);