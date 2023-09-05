select * from orders;
select * from book;
select * from customer;

-- (1)
select bookname from book where bookid = 1;
-- (2)
select bookname from book where price >= 20000;
-- (3)
select sum(saleprice) as 총구매액 from orders where custid = 1;
-- (4)
select count(*) as 도서의수 from orders where custid = 1;

-- (1)
select count(*) as 도서의총개수 from book;
-- (2)
select count(distinct publisher) as 출판사의총개수 from book;
-- (3)
select name, address from customer;
-- (4)
select orderid from orders where orderdate between 20140704 and 20140707;


use madang;
select *
	from customer, orders
    where customer.custid = orders.custid
    order by orderdate;

select name, saleprice
	from customer, orders
    where customer.custid = orders.custid;
    
select name, sum(saleprice) as 총판매액
	from customer, orders
    where customer.custid = orders.custid
    group by name
    having 총판매액 >= 30000;
    
select name, bookname
	from customer, orders, book
    where customer.custid = orders.custid 
		and orders.bookid = book.bookid;
        
select name, bookname
	from customer, orders, book
    where customer.custid = orders.custid 
		and orders.bookid = book.bookid
        and price = 20000;
select name, bookname
	from orders
    inner join customer on customer.custid = orders.custid 
    inner join book on book.bookid = orders.bookid;
    
-- 차집합
select name, saleprice
	from orders
    left join customer on customer.custid = orders.custid
--    from customer
--    right join orders on customer.custid = orders.custid
    where orders.custid is null;
    
-- (5)
select count(distinct publisher) as 출판사수
	from orders
    inner join customer on customer.custid = orders.custid
	inner join book on book.bookid = orders.bookid
    where customer.name = '박지성';
    -- where name like '박지성'
    -- group by name;
    
-- (6)
select bookname, (price - saleprice) as 가격차
	from orders
    inner join customer on customer.custid = orders.custid
	inner join book on book.bookid = orders.bookid
    where customer.name = '박지성'; -- name like '박지성'

-- (7)
select distinct bookname as 구매안한책
from book
where bookid not in
		(select bookid 
		from orders
		where custid in
            (select custid 
			from customer 
			where name like '박지성'));
    

-- 서브쿼리 1-1 가장 비싼 도서 가격
select max(price) from book;
-- 1-2 가격 35000 도서명
select bookname, price 
	from book
	where price = (select max(price) from book);
    
-- 중첩 쿼리 2-1 평균 판매 금액 이하의 주문 내역
select avg(saleprice) from orders; 
select *
	from orders
	where saleprice <= 11800;
-- 합치면
select *
	from orders
	where saleprice <= (select avg(saleprice) from orders); -- 비교연산자는 단일 행,열
    
-- 3-1 대한민국에 거주하는 고객에게 판매한 도서의 총판매액
select custid, name, address
	from customer
    where address like '대한민국%';
select sum(saleprice) from orders where custid in (2,3,5);
-- 합치면
select sum(saleprice) from orders where custid in 
	(select custid -- 다중열 불가
		from customer
		where address like '대한민국%');
        
-- 4-1 All Some Any
select *
	from orders
    where saleprice > All (select saleprice from orders where custid = 3); -- =max, Any=min
select *
	from orders
    where saleprice > (select max(saleprice) from orders where custid = 3); 
    
-- 상관서브쿼리
select publisher, avg(price) 
	from book 
	group by publisher; -- 출판사별 평균 가격
select *
	from book b1
    -- where price > (select avg(price) from book group by publisher); -- 비교연산자는 단일 행,열
    where price > 
		(select avg(price) 
		from book b2 
		where b1.publisher = b2.publisher);
    

SELECT * FROM madang.sales;

select *
	from sales s1
    where saleprice > 
		(select avg(saleprice) 
		from sales s2 
		where s1.name = s2.name);
        
	
	
