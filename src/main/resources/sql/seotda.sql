create table card (
code varchar2(3) primary key,

month int,
shape char(1),
path varchar2(50)
)

drop table card;

select * from card

/*
 * 1월
 */
insert into card
(code, month, shape)
values
('1g', 1, 'g');

insert into card
(code, month, shape)
values
('1d', 1, 'd');

/*
 * 2월
 */
insert into card
(code, month, shape)
values
('2y', 2, 'y');

insert into card
(code, month, shape)
values
('2d', 2, 'd');

/*
 * 3월
 */
insert into card
(code, month, shape)
values
('3g', 3, 'g');

insert into card
(code, month, shape)
values
('3d', 3, 'd');
/*
 * 4월
 */
insert into card
(code, month, shape)
values
('4y', 4, 'y');

insert into card
(code, month, shape)
values
('4d', 4, 'd');

/*
 * 5월
 */
insert into card
(code, month, shape)
values
('5y', 5, 'y');

insert into card
(code, month, shape)
values
('5d', 5, 'd');

/*
 * 6월
 */
insert into card
(code, month, shape)
values
('6y', 6, 'y');

insert into card
(code, month, shape)
values
('6d', 6, 'd');

/*
 * 7월
 */
insert into card
(code, month, shape)
values
('7y', 7, 'y');

insert into card
(code, month, shape)
values
('7d', 7, 'd');

/*
 * 8월
 */
insert into card
(code, month, shape)
values
('8g', 8, 'g');

insert into card
(code, month, shape)
values
('8y', 8, 'y');

/*
 * 9월
 */
insert into card
(code, month, shape)
values
('9y', 9, 'y');

insert into card
(code, month, shape)
values
('9d', 9, 'd');

/*
 * 10월
 */
insert into card
(code, month, shape)
values
('10y', 10, 'y');

insert into card
(code, month, shape)
values
('10d', 10, 'd');

----------------------------------------------------------------
select rownum rn, inner.*
  from (select c.*
    	  from card c
    	 order by c.month asc
   	   ) inner 
 	     