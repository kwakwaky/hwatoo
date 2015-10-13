
create table board (
	num 		int primary key,
	name 		varchar2(20) not null,
	password 	varchar2(20) not null,
	subject 	varchar2(20) not null,
	content 	clob,
	regdate 	date not null
)

create sequence board_num_seq start with 1;
drop sequence board_num_seq;

insert into board
(num, name, password, subject, content, regdate)
values
(
	board_num_seq.nextval,
	'김구',
	'1234',
	'테스트1',
	'It is a test.',
	sysdate
)

select * from board

select 	outer.rn,
  		outer.num,
  		outer.name,
  		outer.password,
  		outer.subject,
  		outer.content,
  		outer.regdate
  from (select rownum rn, inner.*
    	    from (select m.*
    	     	    from board m
    	   	 	   order by m.num desc
   		 	     ) inner 
 	     ) outer
   where outer.rn >= 1
     and outer.rn <= 5
     
insert into board
   	(num, name, password, subject, content, regdate)
   	values
   	(
   	board_num_seq.nextval,
   	'김구',
   	'1234',
   	'테스트2',
   	'테스트 입니다.',
   	sysdate
   	)
   	
update board
   set password = 'qwer',
   	   subject = '변경된 제목',
   	   content = '변경된 내용'
 where num = 4
