/* 이상 현상 */
create table summer (
sid int,
class varchar(20),
price int
);

insert into summer values (100, 'JAVA', 20000);
insert into summer values (200, 'JAVASCRIPT', 30000);
insert into summer values (300, 'SPRING', 40000);
insert into summer values (400, 'MYSQL', 20000);

SELECT * from summer;
/* 삭제 이상 - 수강 신청 취소에 강좌 정보까지 함께 삭제됨 */
delete from summer where sid = 200; /* 수강신청 취소 */
select price from summer where class = 'JAVASCRIPT';
insert into summer values (200, 'JAVASCRIPT', 30000);

/* 삽입 이상 */
insert into summer values (null, 'REACT', 50000);

select count(*) from summer ;
/* 수정 이상 */
/* java 수강학생 한명 더 추가하기 */
insert into summer values (500, 'JAVA', 20000);
update summer set price = 25000 where sid = 100 and class ='JAVA';
SELECT * from summer;

create table summerprice (
class varchar(20),
price int);

create table summerenroll (
sid int,
class varchar(20)
);

insert into summerprice values ('JAVA', 20000);
insert into summerprice values ('JAVASCRIPT', 30000);
insert into summerprice values ('SPRING', 40000);
insert into summerprice values ('MYSQL', 20000);
insert into summerprice values ('REACT', 50000);
select * from summerprice;
update summerprice set price = 25000 where class = 'JAVA';

insert into summerenroll values (100, 'JAVA');
insert into summerenroll values (200, 'JAVASCRIPT');
insert into summerenroll values (300, 'SPRING');
insert into summerenroll values (400, 'MYSQL');
insert into summerenroll values (500, 'JAVA');
select count(sid) from summerenroll;

