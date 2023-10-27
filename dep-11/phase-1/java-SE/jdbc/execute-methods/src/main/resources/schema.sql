/*INSERT INTO Customer (name,address) VALUES ('kavindu','bingiriya'),
                                           ('aruna','kadigamuwa'),
                                           ('pasindu','ratnapura');
SELECT * FROM Customer;
DELETE FROM Customer WHERE address='kadigamuwa';
SELECT COUNT(*) FROM Customer;
SELECT * FROM Customer;

CREATE TABLE IF NOT EXISTS Customer (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name  VARCHAR(50) NOT NULL,
  address VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS Item (
    code VARCHAR(20) PRIMARY KEY,
    description  VARCHAR(50) NOT NULL,
    qty INT NOT NULL,
    unit_price DECIMAL(8,2) NOT NULL
                                );
*/

SET GLOBAL log_bin_trust_function_creators = 1;
CREATE FUNCTION addTwoNums(num1 INT, num2 INT) RETURNS INT
BEGIN
    RETURN num1 + num2;
END;

CREATE PROCEDURE showCustomer(adr VARCHAR(20))
BEGIN
    SELECT * FROM Customer  WHERE address LIKE CONCAT('%',adr,'%');
END;