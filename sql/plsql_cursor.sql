DECLARE 
   c_id customers.id%type; 
   c_name customerS.No.ame%type; 
   c_addr customers.address%type; 
   CURSOR c_customers is 
      SELECT id, name, address FROM customers; 
BEGIN 
   OPEN c_customers; 
   LOOP 
   FETCH c_customers into c_id, c_name, c_addr; 
      EXIT WHEN c_customers%notfound; 
      dbms_output.put_line(c_id || ' ' || c_name || ' ' || c_addr); 
   END LOOP; 
   CLOSE c_customers; 
END; 
/

----records

DECLARE 
   customer_rec customers%rowtype; 
BEGIN 
   SELECT * into customer_rec 
   FROM customers 
   WHERE id = 5;  
   dbms_output.put_line('Customer ID: ' || customer_rec.id); 
   dbms_output.put_line('Customer Name: ' || customer_rec.name); 
   dbms_output.put_line('Customer Address: ' || customer_rec.address); 
   dbms_output.put_line('Customer Salary: ' || customer_rec.salary); 
END; 
/


DECLARE 
   CURSOR customer_cur is 
      SELECT id, name, address  
      FROM customers; 
   customer_rec customer_cur%rowtype; 
BEGIN 
   OPEN customer_cur; 
   LOOP 
      FETCH customer_cur into customer_rec; 
      EXIT WHEN customer_cur%notfound; 
      DBMS_OUTPUT.put_line(customer_rec.id || ' ' || customer_rec.name); 
   END LOOP; 
END; 
/


DECLARE 
   type books is record 
      (title varchar(50), 
      author varchar(50), 
      subject varchar(100), 
      book_id number); 
   book1 books; 
   book2 books; 
BEGIN 
   -- Book 1 specification 
   book1.title  := 'C Programming'; 
   book1.author := 'Nuha Ali ';  
   book1.subject := 'C Programming Tutorial'; 
   book1.book_id := 6495407;  
   -- Book 2 specification 
   book2.title := 'Telecom Billing'; 
   book2.author := 'Zara Ali'; 
   book2.subject := 'Telecom Billing Tutorial'; 
   book2.book_id := 6495700;  
  
  -- Print book 1 record 
   dbms_output.put_line('Book 1 title : '|| book1.title); 
   dbms_output.put_line('Book 1 author : '|| book1.author); 
   dbms_output.put_line('Book 1 subject : '|| book1.subject); 
   dbms_output.put_line('Book 1 book_id : ' || book1.book_id); 
   
   -- Print book 2 record 
   dbms_output.put_line('Book 2 title : '|| book2.title); 
   dbms_output.put_line('Book 2 author : '|| book2.author); 
   dbms_output.put_line('Book 2 subject : '|| book2.subject); 
   dbms_output.put_line('Book 2 book_id : '|| book2.book_id); 
END; 
/

DECLARE 
   type books is record 
      (title  varchar(50), 
      author  varchar(50), 
      subject varchar(100), 
      book_id   number); 
   book1 books; 
   book2 books;  
PROCEDURE printbook (book books) IS 
BEGIN 
   dbms_output.put_line ('Book  title :  ' || book.title); 
   dbms_output.put_line('Book  author : ' || book.author); 
   dbms_output.put_line( 'Book  subject : ' || book.subject); 
   dbms_output.put_line( 'Book book_id : ' || book.book_id); 
END; 
   
BEGIN 
   -- Book 1 specification 
   book1.title  := 'C Programming'; 
   book1.author := 'Nuha Ali ';  
   book1.subject := 'C Programming Tutorial'; 
   book1.book_id := 6495407;
   
   -- Book 2 specification 
   book2.title := 'Telecom Billing'; 
   book2.author := 'Zara Ali'; 
   book2.subject := 'Telecom Billing Tutorial'; 
   book2.book_id := 6495700;  
   
   -- Use procedure to print book info 
   printbook(book1); 
   printbook(book2); 
END; 
/