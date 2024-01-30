insert into user(name, phone, email, pw, status)
values('홍길동', '010-0000-0000', 'mail@mail.com', '1234', '1');

insert into user(name, phone, email, pw, status)
values('홍박사', '010-1111-1111', 'mail1@mail.com', '1111','1');

insert into user(name, phone, email, pw, status)
values('빅보검', '010-2222-2222', 'mail2@mail.com', '1111', '1');

insert into build(build_name, address, floor, room, area, com_date)
values('신촌점', '서울 서대문구 연세로 8-1', '5', '10', '100', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('서울역점', '서울 용산구 한강대로 405', '10', '15', '80', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('홍대입구점', '서울 마포구 양화로 지하 160', '8', '5', '120', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('인사동점', '서울 종로구 율곡로 지하 62', '3', '5', '70', '2020-01-01');


insert into item_kind(kind_type, kind_name)
values('E1', '일반 엘레베이터');
insert into item_kind(kind_type, kind_name)
values('E2', '화물용 엘레베이터');
insert into item_kind(kind_type, kind_name)
values('E3', '비상용 엘레베이터');
insert into item_kind(kind_type, kind_name)
values('ES', '에스컬레이터');
insert into item_kind(kind_type, kind_name)
values('Toilet', '화장실');
insert into item_kind(kind_type, kind_name)
values('Hydrant', '소화전');


insert into item(item_id, build_id, kind_type, item_name, location, from_date, status, check_date, check_cycle)
values('1', '1', 'E1', '엘레베이터 1호기', '5층', '2020-01-01', '1', '2020-12-31', '3개월');
insert into item(item_id, build_id, kind_type, item_name, location, from_date, status, check_date, check_cycle)
values('2', '2', 'E2', '엘레베이터 2호기', '10층', '2020-01-01', '1', '2020-12-31', '3개월');
insert into item(item_id, build_id, kind_type, item_name, location, from_date, status, check_date, check_cycle)
values('3', '3', 'E3', '엘레베이터 3호기', '8층', '2020-01-01', '1', '2020-12-31', '3개월');
