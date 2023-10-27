# CREATE TABLE user(
#     username VARCHAR(20) PRIMARY KEY ,
#     password VARCHAR(250) NOT NULL
# );
SET GLOBAL log_bin_trust_function_creators = 1;
CREATE FUNCTION addTwoNums(num1 INT, num2 INT) RETURNS INT
BEGIN
    RETURN num1 + num2;
END;
