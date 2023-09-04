SELECT * FROM sample.person;

SELECT * FROM madang.book; -- madang 더블클릭시 FROM book

select bookname, publisher from book; 
select bookname, publisher from book where price >= 10000;

select phone from customer where name = '김연아';

select bookname, price from book; 
select price, bookname from book; 

SELECT * FROM book;
select distinct publisher from book;
select * from book where price < 20000;
select * from book where price between 10000 and 20000;

select * from book where publisher in ('굿스포츠', '대한미디어');
select * from book where publisher = '굿스포츠' or publisher = '대한미디어';
select * from book where publisher not in ('굿스포츠', '대한미디어');
select * from book where publisher != '굿스포츠' and publisher != '대한미디어';
select * from book where publisher <> '굿스포츠' and publisher <> '대한미디어';

select * from book where bookname like '%축구%'; -- _는 글자수까지 지정
select * from book where bookname like '%축구%' and price >= 20000;
select * from book order by bookname;
select * from book order by bookname desc;
select * from book order by publisher, bookname;
select * from book order by price, bookname;
select * from book order by price desc, publisher;

select * from orders;
select sum(saleprice) as 총매출액 from orders;

select sum(saleprice) as 총매출액 from orders where custid = 2; -- join 후 김연아로 검색 가능
select sum(saleprice) as 총매출액, 
	avg(saleprice) as 평균, 
	min(saleprice) as 최소, 
	max(saleprice) as 최대 from orders;
        
select count(*) from orders;

select * from customer;
select count(*) from customer; -- 5, row 수
select count(phone) from customer; -- 4, 집계함수는 null제외, where절 사용 x

select custid, count(*) from orders group by custid ; -- 1where 2group 3집계
select custid, count(*) as 도서수량, sum(saleprice) as 총액 from orders group by custid;
select custid, count(*) as 도서수량, sum(saleprice) as 총액 
	from orders 
	group by custid 
	having 도서수량 >=3;-- where절로 쓰면 에러 - 실행 순서
    
select custid, count(*) as 도서수량 
	from orders 
	where saleprice >= 8000 
	group by custid
	having 도서수량 >=2; -- 41235째줄 순으로 실행