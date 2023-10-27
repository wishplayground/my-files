CREATE TABLE IF NOT EXISTS Customers(
                                        id VARCHAR(15) PRIMARY KEY ,
                                        name VARCHAR(100) NOT NULL ,
                                        address VARCHAR(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS item(
                                   item_code VARCHAR(15) PRIMARY KEY ,
                                   description VARCHAR(100) NOT NULL ,
                                   qty_stock INT NOT NULL,
                                   unit_price DECIMAL(8,2)
);

CREATE TABLE IF NOT EXISTS "Order"(
                                      id VARCHAR(20) PRIMARY KEY,
                                      date DATE DEFAULT CURRENT_DATE NOT NULL,
                                      customer_id VARCHAR(15) NOT NULL ,
                                      CONSTRAINT fk_customerid FOREIGN KEY (customer_id) REFERENCES Customers (id)
);


CREATE TABLE IF NOT EXISTS Order_item(
                                         order_id VARCHAR(15) NOT NULL ,
                                         item_code VARCHAR(15) NOT NULL ,
                                         CONSTRAINT pk_id_code PRIMARY KEY (order_id,item_code),
                                         qty INT NOT NULL ,
                                         unit_price DECIMAL(8,2) NOT NULL ,
                                         CONSTRAINT fk_id FOREIGN KEY (order_id) REFERENCES "Order" (id),
                                         CONSTRAINT fk_code FOREIGN KEY (item_code) REFERENCES item (item_code)
);

-- ALTER TABLE item ALTER COLUMN unit_price SET DATA TYPE DECIMAL(10,2);
