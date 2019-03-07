INSERT INTO category (category_name,category_code) VALUES ('phone','145236');
INSERT INTO category (category_name,category_code) VALUES ('book','748412');
INSERT INTO category (category_name,category_code) VALUES ('car','101023');
INSERT INTO category (category_name,category_code) VALUES ('other','856321');

INSERT INTO product (product_name,product_code,product_price,product_state,category_fk)
VALUES ('iphone 8','547412',1000,TRUE ,1);
INSERT INTO product (product_name,product_code,product_price,product_state,category_fk)
VALUES ('galexy s9','741569',800,TRUE ,1);
INSERT INTO product (product_name,product_code,product_price,product_state,category_fk)
VALUES ('lord of the rings','414150',25,TRUE ,2);
INSERT INTO product (product_name,product_code,product_price,product_state,category_fk)
VALUES ('song of ice and fire','106983',60,TRUE ,2);
INSERT INTO product (product_name,product_code,product_price,product_state,category_fk)
VALUES ('bmw x6','693030',26000,TRUE ,3);
INSERT INTO product (product_name,product_code,product_price,product_state,category_fk)
VALUES ('ford mostang','417181',59000,TRUE ,3);
INSERT INTO product (product_name,product_code,product_price,product_state,category_fk)
VALUES ('hephone bit','410010',200,TRUE ,4);