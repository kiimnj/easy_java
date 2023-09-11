use madang;
/* 8) 주문하지 않은 고객의 이름(서브쿼리 사용) */
select name from customer where custid not in (select distinct custid from orders);
/*9) 주문 금액의 총액과 주문의 평균 금액 */
select sum(saleprice) as 주문총액, avg(saleprice) as 주문평균금액 from orders;
/* 10) 고객의 이름과 고객별 구매액 */
select name, sum(saleprice) as 고객별구매총액 
from customer inner join orders on customer.custid = orders.custid
group by name 
order by 고객별구매총액 desc;

select name, saleprice
from customer inner join orders on customer.custid = orders.custid
order by name;
/* 11) 고객의 이름과 고객이 구매한 도서 목록 */
select name, bookname
from customer inner join orders on customer.custid = orders.custid
			inner join book on orders.bookid = book.bookid
order by name;
/* 12) 도서의 가격(book 테이블)과 판매가격(orders테이블)의 차이가 가장 많은 주문 ==>>> */
select max(price - saleprice) as 최대할인
from book join orders on book.bookid = orders.bookid;

/* 13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름 */
select name, avg(saleprice) as 구매액평균 from customer c join orders o on c.custid = o.custid 
group by name 
having 구매액평균 > (select avg(saleprice) as 도서판매평균 from orders);

/* 합집합  Union */
select name 
from customer
where address like '대한민국%'
union
select name
from customer 
where custid in (select distinct custid from orders);
/* 합집합  Union all */
select name, 1  /* Error Code: 1222. The used SELECT statements have a different number of columns */
from customer
where address like '대한민국%';
select name, 1
from customer
where address like '대한민국%'
union all
select name , address
from customer 
where custid in (select distinct custid from orders)
order by name;
/* exists . 상관 서브 쿼리 */
select name , address
from customer c 
where not exists (select * from orders o where c.custid = o.custid);

