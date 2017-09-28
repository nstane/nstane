select * from dba_objects;

select * from session_roles;

select * from DBA_TAB_PRIVS;

select * from DBA_ROLE_PRIVS;

select * from ALL_TABLES;

select * from ALL_ALL_TABLES;
 
 select * from USER_OBJECTS;
 
 select * from HELP;
 
 select level from dual;

select trunc(sysdate,'mm') from dual; 

select to_char(sysdate,'mm-dd-yyyy') from dual;

select TO_DATE(sysdate,'mm-dd-yyyy') from dual;

select level , to_char(add_months(trunc(sysdate,'yyyy'),level-1),'mon') from dual connect by level <=12;

---USER_SYS_PRIVS, USER_TAB_PRIVS, USER_ROLE_PRIVS 
select * from USER_ROLE_PRIVS;
select * from USER_SYS_PRIVS;

create user nstane identified by system;
grant connect to nstane;