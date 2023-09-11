use madang;
insert into book
values (11, '스포츠의학','한솔의학서적',90000);
select * from book;
insert into book
values (12, '스포츠의학','한솔의학서적',90000);
select * from book;
insert into book
values (13, '스포츠의학','한솔의학서적',90000);
select * from book;
insert into book (bookid, bookname, publisher)
values (14, '스포츠의학','한솔의학서적');
select * from book;

insert into book
SELECT * FROM madang.imported_book;

/* DML Update */
select * from customer;

update customer
set address = '대한민국 서울';  /* Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.*/

set SQL_SAFE_UPDATES = 1; /* enable safe mode */
update customer
set address = '대한민국 부산'; 
set SQL_SAFE_UPDATES = 0; /* disable safe mode */

update book
set publisher = (select publisher from book where bookid = 21) /* Error Code: 1093. You can't specify target table 'book' for update in FROM clause */
where bookid = 14;

update book
set publisher = (select publisher from imported_book where bookid = 21) /* Error Code: 1093. You can't specify target table 'book' for update in FROM clause */
where bookid = 14;
select * from book;

/* DML - DELETE */
delete from book where bookid = 11;
select * from book;
delete from book;

delete from book where bookid = 3; /* Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`madang`.`orders`, CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`))*/

/* 심화연습문제 */
/* 1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름 */
select name , publisher 
from customer c join orders o on c.custid = o.custid 
   join book b on o.bookid = b.bookid;

select name , publisher 
from customer c join orders o on c.custid = o.custid 
   join book b on o.bookid = b.bookid
where name not like '박지성' and publisher in (select distinct publisher from book where bookid in 
(select bookid from orders where custid = (select custid from customer where name like '박지성')));

/* 2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름 */
select name , count(distinct publisher) as 출판사수
from customer c join orders o on c.custid = o.custid 
   join book b on o.bookid = b.bookid
   group by name
   having 출판사수 >= 2;
   
/* 3) 전체 고객의 30% 이상이 구매한 도서 (고객수 = 5 , 30% 는 1.5명 )*/
select bookname , count(distinct c.custid) as 구매자수
from customer c join orders o on c.custid = o.custid 
   join book b on o.bookid = b.bookid
   group by bookname
   having 구매자수 >= (select count(*) * 0.3 from customer);
   
   
   