insert into image_category values("b", "건물"),
("j","작업"),
("c","민원");

insert into admin(admin_id, username, password, role) values(null, 'admin', '{noop}1111', 'ADMIN');

insert into users(user_name, phone, email, pw, status, role)
values('홍길동', '010-0000-0000', 'mail@mail.com', '{noop}1111', '2', 'USER');

insert into users(user_name, phone, email, pw, status, role)
values('홍박사', '010-1111-1111', 'mail1@mail.com', '{noop}1111','1', 'USER');

insert into users(user_name, phone, email, pw, status, role)
values('빅보검', '010-2222-2222', 'mail2@mail.com', '{noop}1111', '1', 'USER');

insert into build(build_name, address, floor, room, area, com_date)
values('신촌점', '서울 서대문구 연세로 8-1', '5', '50', '100000', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('서울역점', '서울 용산구 한강대로 405', '10', '150', '80000', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('홍대입구점', '서울 마포구 양화로 지하 160', '8', '40', '120000', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('인사동점', '서울 종로구 율곡로 지하 62', '3', '15', '70000', '2020-01-01');

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

insert into cost(build_id, cost_date, electricity, repair, upkeep, consignment, send) values
(1, '2024-01-01', 1000000, 2000000, 3000000, 2000000, 1),
(1, '2024-02-01', 2000000, 3000000, 4000000, 7000000, 1),
(1, '2023-02-01', 2000000, 3000000, 4000000, 7000000, 1),
(1, '2024-04-01', 3000000, 3201230, 1231230, 7972910, 1),
(1, '2024-03-01', 2000000, 3000000, 4000000, 7000000, 1),
(3, '2024-01-01', 4000000, 5000000, 6000000, 1000000, 1),
(4, '2024-01-01', 5000000, 6000000, 7000000, 2000000, 1);

insert into cost(build_id, cost_date, electricity, repair, upkeep, consignment, send, resident_cnt) values
(2, '2024-01-01', 3000000, 4000000, 5000000, 8000000, 2, 80);

insert into resident(resident_id, resident_num, build_id, user_id, entered, from_date, to_date, deposit, monthly)
value('1', '101', '1','1','2','2024-01-01','2024-12-31','100000000','10000000');

insert into company_kind(kind_type, kind_name) values('1', '청소');
insert into company_kind(kind_type, kind_name) values('2', '전기');
insert into company_kind(kind_type, kind_name) values('3', '경비');
insert into company_kind(kind_type, kind_name) values('4', '공조');
insert into company_kind(kind_type, kind_name) values('5', '인터넷');
insert into company_kind(kind_type, kind_name) values('6', '엘리베이터');
insert into company_kind(kind_type, kind_name) values('7', '수도');
insert into company_kind(kind_type, kind_name) values('8', '소방');

insert into company(company_id, build_id, kind_type, company_name, manager, phone, from_date, to_date, cost, pw, role) values('10001', '1', '1', '아담청소', '김대리', '010-1111-2222', '2023-04-01', '2026-03-31', '1500000', '{noop}1111', 'WORKER');
insert into company(company_id, build_id, kind_type, company_name, manager, phone, from_date, to_date, cost, pw, role) values('10002', '2', '2', '쌍용전기', '송과장', '010-2222-3333', '2023-04-01', '2026-03-31', '1500000', '{noop}1111', 'WORKER');
insert into company(company_id, build_id, kind_type, company_name, manager, phone, from_date, to_date, cost, pw, role) values('10003', '3', '3', '에이스가드', '정대리', '010-3333-4444', '2023-04-01', '2026-03-31', '1500000', '{noop}1111', 'WORKER');
insert into company(company_id, build_id, kind_type, company_name, manager, phone, from_date, to_date, cost, pw, role) values('10004', '4', '4', '한국공조', '박차장', '010-4444-5555', '2023-04-01', '2026-03-31', '1500000', '{noop}1111', 'WORKER');
insert into company(company_id, build_id, kind_type, company_name, manager, phone, from_date, to_date, cost, pw, role) values('10005', '1', '5', '유플러스', '이대리', '010-5555-6666', '2019-09-22', '2024-09-21', '1900000', '{noop}1111', 'WORKER');
insert into company(company_id, build_id, kind_type, company_name, manager, phone, from_date, to_date, cost, pw, role) values('10006', '2', '6', '오티스', '윤과장', '010-6666-7777', '2019-09-22', '2024-09-21', '1900000', '{noop}1111', 'WORKER');
insert into company(company_id, build_id, kind_type, company_name, manager, phone, from_date, to_date, cost, pw, role) values('10007', '3', '7', '우주환경', '김과장', '010-7777-8888', '2019-09-22', '2024-09-21', '1900000', '{noop}1111', 'WORKER');
insert into company(company_id, build_id, kind_type, company_name, manager, phone, from_date, to_date, cost, pw, role) values('10008', '4', '8', '대영소방', '정과장', '010-8888-9999', '2019-09-22', '2024-09-21', '1900000', '{noop}1111', 'WORKER');

insert into claim(claim_id, build_id, user_id, title, claim_kind, content, ask_date, fin_date, status) values
(null, 1, 1, "엘리베이터 문이 잘 안닫힙니다.", "엘리베이터", "닫힘 버튼을 눌러도 문이 안 닫히는 경우가 종종 있습니다.", "2022-10-24", "2022-10-31", 2),
(null, 1, 2, "엘리베이터 운행 중 정지", "엘리베이터", "운행 도중 중간에 멈추는 일이 발생합니다.", "2022-11-12", "2022-11-19", 2),
(null, 1, 3, "난방기가 따뜻하지가 않아요.", "공조", "난방 성능이 예전보다 떨어진 것 같습니다.", "2022-12-27", "2022-12-28", 2),
(null, 2, 1, "난방기가 안켜져요.", "공조", "난방기가 작동하지 않습니다.", "2023-01-18", "2023-01-20", 2),
(null, 2, 2, "수도꼭지에서 물이 샙니다.", "수도", "수도꼭지에서 물이 한방울씩 샙니다.", "2023-06-10", "2023-06-15", 2),
(null, 2, 3, "에어컨 냉방 성능 저하", "공조", "에어컨을 세게 틀어도 시원해지는데 너무 오래 걸립니다.", "2023-07-15", "2023-07-17", 2),
(null, 3, 1, "물 세기가 약해졌어요", "수도", "물을 최대로 틀어도 나오는게 졸졸졸 나옵니다.", "2023-09-28", "2023-10-02", 2),
(null, 3, 2, "인터넷이 자꾸 끊깁니다.", "인터넷", "특정 시간대에 인터넷이 끊기는 현상이 있습니다.", "2023-10-12", "2023-10-16", 2),
(null, 3, 3, "바닥이 너무 미끄러워요", "청소", "바닥이 너무 미끄러운데 조치 부탁드립니다.", "2023-12-09", null, 1),
(null, 4, 1, "인터넷 속도가 느립니다.", "인터넷", "인터넷 속도가 이전보다 많이 느려졌습니다.", "2024-01-05", null, 1),
(null, 4, 2, "건물 내 악취좀 해결해주세요.", "청소", "며칠 동안 건물 내부에서 악취가 납니다.", "2024-02-01", null, 1);