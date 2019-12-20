create user bfrs
identified by p4ssw0rd
default tablespace users
temporary tablespace temp
quota 10m on users;

grant connect to bfrs;
grant resource to bfrs;
grant create session to bfrs;
grant create table to bfrs;
grant create view to bfrs;

