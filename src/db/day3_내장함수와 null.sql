use madang;

/* 4장 고급 1. 내장함수 */
select bookid, replace(bookname,'야구', '농구') bookname, publisher, price from book;

select substr(name, 1, 1) 성 , count(*) 인원
from customer
group by 성; /* group by substr(name, 1, 1) */

select orderid 주문번호, orderdate 주문일, adddate(orderdate, interval 10 day) 매출확정일
from orders ;

/* null */
create table mybook (
bookid int,
price int);

insert into mybook values (1,10000);
insert into mybook values (2,20000);
insert into mybook values (3, null);

select * from mybook;

select sum(price), avg(price), count(*), count(price)
from mybook;

select price + 100 from mybook where bookid = 3;

select sum(price), avg(price), count(*), count(price)
from mybook
where bookid > 3;

select price from mybook where price is not null;
select price from mybook where price = "";

select name, ifnull(phone,"연락처없음") 전화번호  from customer;

/* 3. 행번호 출력 */
set @seq:=0;
select (@seq:= @seq+1) no , custid, name, phone 
from customer
where @seq < 2;

/* 쿼리 실행 계획 */
select custid, count(*) from orders group by custid ;

select custid, count(*) from orders group by custid order by custid desc;

select custid, count(*) from orders where custid > 1 group by custid order by custid desc;


