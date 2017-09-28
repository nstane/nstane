CREATE PACKAGE emp_sal AS 
   PROCEDURE find_sal(c_id emp_tbl.id%type); 
END emp_sal; 
/

CREATE OR REPLACE PACKAGE BODY emp_sal AS  
   
   PROCEDURE find_sal(c_id emp_tbl.id%TYPE) IS 
   c_sal emp_tbl.salary%TYPE; 
   BEGIN 
      SELECT salary INTO c_sal 
      FROM emp_tbl 
      WHERE id = c_id; 
      dbms_output.put_line('Salary: '|| c_sal); 
   END find_sal; 
END emp_sal; 
/


--Call

DECLARE 
   code emp_tbl.id%type := 10001; 
BEGIN 
   emp_sal.find_sal(code); 
END; 
/