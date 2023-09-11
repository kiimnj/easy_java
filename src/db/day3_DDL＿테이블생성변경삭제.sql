create table newbook (
  bookid INTEGER, 
  bookname VARCHAR(20),
  publisher VARCHAR(20),
  price INTEGER
);

drop table newbook;

create table newbook (
  bookid INTEGER, 
  bookname VARCHAR(20),
  publisher VARCHAR(20),
  price INTEGER,
  primary key (bookid)
);

create table newbook (
  bookid INTEGER primary key not null auto_increment, 
  bookname VARCHAR(20),
  publisher VARCHAR(20),
  price INTEGER
);

insert into newbook (bookid, bookname, publisher, price) values (1,"a","b",10000);
insert into newbook (bookname, publisher, price) values ("a","b",10000);
select * from newbook;

create table newbook (
  bookname VARCHAR(20),
  publisher VARCHAR(20),
  price INTEGER,
  primary key (bookname, publisher)
);


create table newbook (
  bookname VARCHAR(20) not null,
  publisher VARCHAR(20) unique,
  price INTEGER default 10000 check(price>1000),
  primary key (bookname, publisher)
);

insert into newbook (bookname, publisher) values ("a","b");
select * from newbook;
insert into newbook (bookname, publisher,price) values ("a","b", 10); /* Error Code: 3819. Check constraint 'newbook_chk_1' is violated. */
insert into newbook (publisher,price) values ("b1", 1100); /* Error Code: 1364. Field 'bookname' doesn't have a default value */
insert into newbook (bookname, publisher,price) values ("a1","b", 1100); /* Error Code: 1062. Duplicate entry 'b' for key 'newbook.publisher' */

alter table newbook add bookid int;
alter table newbook modify bookid int not null;
update newbook set bookid = 0 where bookname = 'a';
alter table newbook drop primary key;
alter table newbook add primary key (bookid);
select * from newbook;
drop table newbook;

/* new customer 생성*/
create table newCustomer (
	custid int primary key auto_increment,
    name varchar(40),
    address varchar(40),
    phone varchar(30)
);

insert into newCustomer (name,address,phone) values ("홍길동", null, null);
insert into newCustomer (name,address,phone) values ("김연아", null, null);
select * from newCustomer;
delete from newCustomer where custid = 3;
drop table newCustomer;/* Error Code: 3730. Cannot drop table 'newcustomer' referenced by a foreign key constraint 'neworders_ibfk_1' on table 'neworders'.*/


/* new orders 생성*/
create table newOrders (/* Error Code: 1830. Column 'custid' cannot be NOT NULL: needed in a foreign key constraint 'neworders_ibfk_1' SET NULL */
	orderid int auto_increment,
    custid int,
    bookid int not null,
    saleprice int,
    orderdate date,
    primary key(orderid),
    foreign key(custid) references newCustomer(custid) on delete set null
    );
    
drop table newOrders;
    
insert into newOrders (custid, bookid, saleprice, orderdate) values (1, 1, 10000, '20230906');
insert into newOrders (custid, bookid, saleprice, orderdate) values (2, 1, 20000, '20230906');
insert into newOrders (custid, bookid, saleprice, orderdate) values (3, 1, 30000, '20230906');
select * from newOrders;