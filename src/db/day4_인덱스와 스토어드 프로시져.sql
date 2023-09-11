create table nokey (
number int,
name varchar(20)
);

select * from nokey;
insert into nokey values (30, 'a');
insert into nokey values (10, 'b');
insert into nokey values (1, 'c');
insert into nokey values (8, 'd');
insert into nokey values (5, 'e');
insert into nokey values (3, 'f');
insert into nokey values (2, 'g');
insert into nokey values (9, 'h');
insert into nokey values (11, 'i');
insert into nokey values (15, 'j');

set SQL_SAFE_UPDATES = 0;
delete from nokey where number = 11;

alter table nokey modify column number int primary key;
alter table nokey modify column name varchar(20) unique;

show index from nokey;
show index from orders;
show index from customer;
show index from book;

/* 인덱스 생성 */
create index ix_book on book(bookname);

show index from book;
select * from book;
create index ix_book2 on book(publisher, price);

select * from book 
where publisher like '대한%' and price >=30000;

drop index ix_book2 on book;

analyze table orders;

create index ix_customer on customer(name);
show index from customer;
drop index ix_customer on customer;
select name, address from customer where name like '박세리%';

/* insertBook stored procedure 생성 */
use madang;
delimiter $$
create procedure insertbook(
	mybookid int, 
	mybookname varchar(40), 
	mypublisher varchar(40),
    myprice int
    )
    begin
		insert into book 
        values (mybookid, mybookname, mypublisher, myprice);
	end; 
    $$
delimiter ;

select * from book;
call insertbook(15, '스포츠과학', '마당과학서적', 25000);

/* avg 를 반환하는 stored procedure 생성 */

delimiter // 
create procedure averageprice(out averagevalue int)
begin
   select avg(price) into averagevalue
   from book where price is not null;
end; //
delimiter ;
call averageprice(@myavg);
select @myavg;

  select avg(price)
   from book;

select sysdate();
