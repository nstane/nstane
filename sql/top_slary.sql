CREATE TABLE emp_tbl(ID NUMBER(10), NAME VARCHAR2(20), salary NUMBER(20));

CREATE TABLE customers(customerid NUMBER(30),customername VARCHAR (30), contactname VARCHAR(10), address VARCHAR(200), 
city VARCHAR(30), postalcode VARCHAR(15), country VARCHAR(30));
COMMIT;

SELECT ID ,
NAME ,
salary  FROM emp_tbl;

DECLARE

BEGIN 
FOR lcntr IN 1..20
LOOP
  INSERT INTO emp_tbl VALUES(1006,'Name6',19060);
END LOOP;
END;

TRUNCATE TABLE  emp_tbl;

SELECT MAX(salary) FROM emp_tbl;
SELECT MIN(salary) FROM emp_tbl;
SELECT salary FROM emp_tbl WHERE salary > 19060 ORDER BY salary DESC;

-- Find nth hieghtst salary
SELECT salary FROM (SELECT salary FROM (SELECT salary FROM emp_tbl ORDER BY salary DESC) WHERE ROWNUM <=3 ORDER BY 1)
WHERE ROWNUM <=1;

--update EMP_TBL set  salary = 1234 where id 

--Where clause
SELECT ID ,
NAME ,
salary  FROM emp_tbl WHERE (ID BETWEEN 1000 AND 1005) AND salary > 19060 AND NAME LIKE 'Name%' AND NAME <> 'Name6';

-- Group by and order by
SELECT COUNT(*) FROM emp_tbl GROUP BY NAME ORDER BY NAME DESC;

--Upate multiple columns
UPDATE emp_tbl SET NAME = 'TAG', salary = 1;

--Too many index will reduce insert delete and update performance because we modify data it has to recalculate index.
-- like LIKE 'a%o'	Finds any values that starts with "a" and ends with "o" LIKE 'a_%_%'	Finds any values that starts with "a" and are at least 3 characters in length
--LIKE '_r%'	Finds any values that have "r" in the second position
-- Wirld card  LIKE '[!a-c]%' or [!abc]%

--Joins : 


-- having weith group by  customer having order more than 1
--SELECT * FROM Customers where customerid in (select customerId from Orders group by customerId having count(customerId) > 1);


CREATE SEQUENCE seq_person
MINVALUE 1001
START WITH 1001
INCREMENT BY 1
CACHE 10;

CREATE DATABASE testdb;

CREATE TABLE orders (
    ID INT NOT NULL,
    ordernumber INT NOT NULL,
    orderdate DATE DEFAULT getdate()
);
CREATE TABLE orders (
    orderid INT NOT NULL,
    ordernumber INT NOT NULL,
    personid INT,
    PRIMARY KEY (orderid),
    CONSTRAINT fk_personorder FOREIGN KEY (personid)
    REFERENCES persons(personid)
);
CREATE TABLE persons (
    ID INT NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255),
    age INT,
    CONSTRAINT uc_person UNIQUE (ID,lastname),
    CONSTRAINT pk_person PRIMARY KEY (ID,lastname)
);
SELECT seq_person.NEXTVAL FROM dual;

-- PLSQL
DECLARE 
    message  VARCHAR2(30):= 'That''s tutorialspoint.com!';  
BEGIN 
   dbms_output.put_line(message); 
END; 
/ 

 