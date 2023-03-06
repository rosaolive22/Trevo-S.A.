CREATE DATABASE Trevo;
/*Modificado 16/02/2023*/
CREATE TABLE company(cnpj CHAR(14) PRIMARY KEY,
		name VARCHAR(30)NOT NULL,
		business_branch TEXT NOT NULL,
		founding_yeans iNT NOT NULL
);
SELECT * FROM company;

CREATE TABLE catalog(cod SERIAL PRIMARY KEY,
		id_product INTEGER,
        culture VARCHAR(30)NOT NULL,
		num_cnpj VARCHAR(14)
);

CREATE TABLE product(id_product SERIAL PRIMARY KEY,
		name VARCHAR(30)NOT NULL,
		size VARCHAR(30) NOT NULL,
		status BOOLEAN NOT NULL,
		date_register DATE,
		id_catalog INTEGER,
        cod_description INTEGER,		
		cod_description INTEGER NOT NULL, 
		culture VARCHAR(30)NOT NULL
);
DROP TABLE product;
SELECT * FROM product;
ALTER TABLE product ADD FOREIGN KEY (id_sale) REFERENCES sale(id);
ALTER TABLE product ADD FOREIGN KEY(id_catalog) REFERENCES catalog(cod);

CREATE TABLE cultures(cod_catalog INTEGER,
		id_product INTEGER,		
		PRIMARY KEY (cod_catalog, id_product )
);
CREATE TABLE image(cod VARCHAR(100) PRIMARY KEY,
		id_product INTEGER,
		img VARCHAR(255)NOT NULL
);
CREATE TABLE technical_description(
		cod SERIAL PRIMARY KEY,	
		indicated_technical TEXT NOT NULL
);
CREATE TABLE sale(id SERIAL PRIMARY KEY,
		information VARCHAR(255)NOT NULL,
        id_product INTEGER
);
CREATE TABLE customer(cod SERIAL PRIMARY KEY,
		name VARCHAR(100) NOT NULL,
		phone INTEGER NOT NULL,
		e_mail VARCHAR (50) NOT NULL,	
		country CHAR (50) NOT NULL,
		id_register INTEGER,
        id_product INTEGER
);
ALTER TABLE catalog ADD FOREIGN KEY(id_product)REFERENCES product(id_product);
ALTER TABLE catalog ADD FOREIGN KEY(id_product)REFERENCES product(id_product);
ALTER TABLE catalog ADD FOREIGN KEY(num_cnpj)REFERENCES company(cnpj);
ALTER TABLE sale ADD FOREIGN KEY (id_product) REFERENCES product(id_product);
ALTER TABLE image ADD FOREIGN KEY (id_product) REFERENCES product(id_product);
ALTER TABLE customer ADD FOREIGN KEY (id_register) REFERENCES sale(id);
ALTER TABLE customer ADD FOREIGN KEY(id_product) REFERENCES product(id_product);
