use madang;

select o.custid, (select name from customer c1 where o.custid = c1.custid) name , sum(saleprice)
from orders o 
group by o.custid ;  /* 1.25 cost */

select c.custid, name, sum(saleprice)
from customer c join orders o on c.custid=o.custid
group by c.custid , name;  /* 4.75 cost */

alter table orders add bname varchar(40);
select * from orders;

set SQL_SAFE_UPDATES = 0;
update orders o
set bname = (select bookname from book b where o.bookid = b.bookid);
set SQL_SAFE_UPDATES = 1;

select name, sum(saleprice)
from orders o join customer c on o.custid = c.custid
where o.custid <= 2
group by name;  /* cost 2.41 */

select name, sum(saleprice) 
from (select custid,name from customer
	  where custid <= 2) cs join orders o on cs.custid = o.custid and o.custid <= 2
group by name;

/* 연습문제 1) 스칼라 서브쿼리 */
select o.custid, (select address from customer cs where cs.custid=o.custid) addr,
                sum(saleprice) total
from orders o
group by o.custid ;
/* 연습문제 2) 인라인 뷰 */
select cs.name, s 
from (select custid, avg(saleprice) s 
      from orders
      group by custid) od, customer cs
where cs.custid = od.custid;
/* 연습문제 3) 중첩 서브쿼리 (상관서브쿼리)*/
/* 고객번호가 3 이하이고 주문이 하나라도 있는 고객의 주문 총액 */
select sum(saleprice) total
from orders od
where exists (select *
				from customer cs
                where custid <=3 and cs.custid = od.custid);
                
select custid, sum(saleprice)
from orders 
where custid <= 3
group by custid;


/* view  생성 */
create view Vorders
as
select orderid, o.custid, name, o.bookid, bookname, saleprice, orderdate
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid;

select * from vorders;
select orderid, bookname, saleprice
from vorders
where name ='김연아';

create view vbook
as 
select * 
from book where bookname like '%축구%';

select * from vbook;

select * from customer;
update customer set address = '미국' where custid = 4;

create view vcustomer
as
select * from customer where address like '대한민국%';

select * from vcustomer;
update vcustomer set phone = '000-0000' where custid=4;

create view v1customer
as
select * from customer;

select * from v1customer;
update v1customer set phone = '000-0000' where custid=4;

select * from information_schema.views where table_schema = 'madang' and table_name like 'v%';

create view v_sum 
as 
select custid, sum(saleprice)
from orders
group by custid;

select * from v_sum;

/* 연습문제 */
/* 1) 판매가격이 20,000 원 이상인 도서의 도서번호, 도서이름, 고객이름, 출판사, 판매가격을 보여주는 뷰 생성 */
create view v_highorders
as
select b.bookid, bookname, name, publisher, saleprice
from book b, orders o, customer c
where b.bookid = o.bookid and o.custid = c.custid
and saleprice >=20000;
/* 2) 생성된 뷰를 이용한 조회 */
select * from v_highorders;
/* 3) 판매가격 속성 삭제 */
alter view v_highorders
as 
select b.bookid, bookname, name, publisher
from book b, orders o, customer c
where b.bookid = o.bookid and o.custid = c.custid
and saleprice >=20000;

select * from v_highorders;



