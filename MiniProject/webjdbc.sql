--sql문 정리
select * from 테이블명;
select 컬럼명 from 테이블명;
-- 조건식 : 컬럼명 = 값 / 컬럼명 > 값
select 컬럼명 from 테이블명 where 조건식;
select 컬럼명 from 테이블명 where 조건식 order by 기준컬럼명 정렬방식;
-- 테이블에 있는 모든 컬럼에 값을 넣을것이다.
insert into 테이블명 values(값1, 값2, 값3);
--특정컬럼에 값을 넣는 경우 --> 인덱스번호, 글번호 : 자동으로 넣는 경우
insert into 테이블명(컬럼명1, 컬럼명2, 컬럼명3) values(값1, 값2, 값3);
--값 수정
update 테이블명 set 컬럼명=값;
update 테이블명 set 컬럼명=값 where 조건식;
update 테이블명 set 컬럼명1=값1, 컬럼명2=값2, where 조건식;

--delete drop
delete from 테이블명;
--한줄 삭제, 원하는거만 삭제
delete from 테이블명 where 조건식;

-- 테이블 만들기
create table 테이블명(
컬럼명 데이터타입(길이) not null,
constraint ooooooo_pk primary key(컬럼명)
);

create table member_web(
id varchar2(100) not null,
pw varchar2(100) not null,
nick varchar2(100) not null,
constraint web_id_pk primary key(id)
);






