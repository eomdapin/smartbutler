drop database if exists smartbutler;

create database if not exists smartbutler character set = utf8mb4;

use smartbutler;

# 건물 정보
drop table if exists build;
create table if not exists build (
	build_id bigint not null auto_increment COMMENT '건물 고유 번호',
    build_name varchar(100) not null COMMENT '건물명',
    address varchar(200) not null COMMENT '주소',
    floor int not null COMMENT '층수',
    room int not null COMMENT '칸수',
    area bigint not null COMMENT '면적',
    com_date date not null COMMENT '준공일',
    primary key(build_id)
);

# 회원
# status = 회원 유형
# 1 = 일반 회원, 2 = 입주 회원
drop table if exists users;
create table if not exists users (
	user_id bigint not null auto_increment COMMENT '회원 고유 번호',
    user_name varchar(30) not null COMMENT '회원명',
    phone char(13) not null unique COMMENT '휴대폰 번호',
    email varchar(100) not null unique COMMENT '이메일 주소',
    status smallint not null default 1 COMMENT '회원 유형',
    pw text not null COMMENT '비밀번호',
    role text not null COMMENT '권한',
    primary key(user_id)
);

# 입주 현황
# status = 입실 여부
# 1 = 입실, 2 = 공실
drop table if exists resident;
create table if not exists resident (
	resident_id bigint not null auto_increment COMMENT '입주 고유 번호',
    resident_num int not null COMMENT '방 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    user_id bigint COMMENT '회원 고유 번호',
    entered smallint not null default(1) COMMENT '입실 여부',
    from_date date COMMENT '계약 시작일',
    to_date date COMMENT '계약 종료일',
    deposit bigint COMMENT '보증금',
    monthly bigint COMMENT '월세',
    foreign key(build_id) references build(build_id),
    foreign key(user_id) references users(user_id),
    primary key(resident_id)
);

# 민원
# status = 민원 상태
# 1 = 신청, 2 = 완료
drop table if exists claim;
create table if not exists claim (
	claim_id bigint not null auto_increment COMMENT '민원 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    user_id bigint not null COMMENT '회원 고유 번호',
    title varchar(200) not null COMMENT '제목',
    claim_kind char(100) not null COMMENT '민원 종류',
    content text not null COMMENT '내용',
    ask_date date not null COMMENT '요청 날짜',
    fin_date date COMMENT '완료 날짜',
    status smallint not null default 1 COMMENT '민원 상태',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(user_id) references users(user_id) on delete cascade,
    primary key(claim_id)
);

# 담당 업무
drop table if exists company_kind;
create table if not exists company_kind (
	kind_type bigint not null auto_increment COMMENT '업무 고유 번호',
    kind_name varchar(100) not null COMMENT '담당 업무명',
    primary key(kind_type)
);

# 계약 업체
drop table if exists company;
create table if not exists company (
	company_id bigint not null auto_increment COMMENT '업체 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    kind_type bigint not null COMMENT '담당 업무 코드',
    company_name varchar(100) not null COMMENT '업체명',
    manager varchar(30) not null COMMENT '담당자명',
    phone char(13) not null COMMENT '전화번호',
    from_date date not null COMMENT '계약 시작일',
    to_date date not null COMMENT '계약 종료일',
    cost bigint not null COMMENT '계약 비용',
    pw text not null COMMENT '비밀번호',
    role text not null COMMENT '권한',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(kind_type) references company_kind(kind_type) on update cascade,
    primary key(company_id)
);

# 견적
# confirm = 승인 여부
# 1 = 신청, 2 = 승인, 3 = 반려
drop table if exists estimate;
create table if not exists estimate (
    estimate_id bigint not null auto_increment COMMENT '견적 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    user_id bigint not null COMMENT '회원 고유 번호',
    reg_date varchar(30) not null COMMENT '견적 등록 시간',
    deposit bigint not null COMMENT '보증금',
    period varchar(50) not null COMMENT '계약기간',
    to_date date not null COMMENT '입실 일자',
    confirm smallint not null COMMENT '승인 여부',
    content text COMMENT '비고',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(user_id) references users(user_id) on delete cascade,
    primary key(estimate_id)
);

# 관리비
# send = 전송 여부
# 1 = 미전송, 2 = 전송
drop table if exists cost;
create table if not exists cost (
	cost_id bigint not null auto_increment COMMENT '관리비 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    cost_date date not null COMMENT '관리비 일자',
	electricity bigint not null COMMENT '전기료',
    repair bigint not null COMMENT '수리비',
    upkeep bigint not null COMMENT '유지관리비',
    consignment bigint not null COMMENT '전문위탁비',
    send smallint not null COMMENT '전송 여부',
    resident_cnt int null COMMENT '전송 당시 입주 세대 수',
    foreign key(build_id) references build(build_id) on delete cascade,
    primary key(cost_id)
);

# 시설 종류
drop table if exists item_kind;
create table if not exists item_kind (
	kind_type varchar(20) not null COMMENT '시설 종류 코드',
    kind_name varchar(100) not null COMMENT '시설 종류 이름',
    primary key(kind_type)
);

# 시설
# status = 상태
# 1 = 정상, 2 = 수리, 3 = 폐기
drop table if exists item;
create table if not exists item (
	item_id bigint not null auto_increment COMMENT '시설 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    kind_type varchar(20) not null COMMENT '시설 종류 코드',
    item_name varchar(100) not null COMMENT '시설명',
    location varchar(50) not null COMMENT '시설 위치',
    from_date date not null COMMENT '사용 시작일',
    status smallint not null COMMENT '상태',
    check_date date not null COMMENT '점검 날짜',
    check_cycle varchar(30) not null COMMENT '점검 주기',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(kind_type) references item_kind(kind_type) on update cascade,
    primary key(item_id)
);

# 작업
# status = 처리 상태
# 1 = 신청, 2 = 완료
drop table if exists job;
create table if not exists job (
	job_id bigint not null auto_increment COMMENT '작업 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
	company_id bigint not null COMMENT '업체 고유 번호',
    item_id bigint not null COMMENT '시설 고유 번호',
    title varchar(200) not null COMMENT '제목',
    content text not null COMMENT '요청 내용',
    report_content text COMMENT '보고 내용',
    ask_date date not null COMMENT '요청 날짜',
    fin_date date COMMENT '완료 날짜',
    status smallint not null COMMENT '처리 상태',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(item_id) references item(item_id),
    foreign key(company_id) references company(company_id),
    primary key(job_id)
);

# 이미지 종류
drop table if exists image_category;
create table if not exists image_category (
	coded char(20) not null COMMENT '이미지 코드',
    code_name char(50) not null COMMENT '분류 이름',
    primary key(coded)
);

# 이미지 코드 입력
insert into image_category values("b", "건물"),
("j","작업"),
("c","민원");

# 이미지
drop table if exists image;
create table if not exists image (
	image_id bigint not null auto_increment COMMENT '이미지 고유 번호',
    coded char(20) not null COMMENT '이미지 코드',
    out_id bigint not null COMMENT '외부 고유 번호',
    name text not null COMMENT '이미지명',
    real_name text not null COMMENT '실제 이미지명',
    src text not null COMMENT '이미지 경로',
    real_src text not null COMMENT '실제 이미지 경로',
    foreign key(coded) references image_category(coded),
    primary key(image_id)
);

# 관리자
drop table if exists admin;
create table if not exists admin (
	admin_id bigint not null auto_increment COMMENT '관리자 고유 번호',
    username varchar(255) not null COMMENT '관리자 아이디',
    password varchar(255) not null COMMENT '비밀번호',
    role varchar(255) not null COMMENT '관리자 권한',
    primary key(admin_id)
);

#######################################################
insert into admin values(null, 'admin', '{noop}1111', 'ADMIN');

#######################################################
insert into users(user_name, phone, email, pw, status, role)
values('홍길동', '010-0000-0000', 'mail@mail.com', '{noop}1111', '2', 'USER');

insert into users(user_name, phone, email, pw, status, role)
values('홍박사', '010-1111-1111', 'mail1@mail.com', '{noop}1111','1', 'USER');

insert into users(user_name, phone, email, pw, status, role)
values('빅보검', '010-2222-2222', 'mail2@mail.com', '{noop}1111', '1', 'USER');

###########################################################################
insert into build(build_name, address, floor, room, area, com_date)
values('신촌점', '서울 서대문구 연세로 8-1', '5', '50', '100000', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('서울역점', '서울 용산구 한강대로 405', '10', '150', '80000', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('홍대입구점', '서울 마포구 양화로 지하 160', '8', '40', '120000', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('인사동점', '서울 종로구 율곡로 지하 62', '3', '15', '70000', '2020-01-01');

#########################################################################
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

#########################################################################
insert into item(item_id, build_id, kind_type, item_name, location, from_date, status, check_date, check_cycle)
values('1', '1', 'E1', '엘레베이터 1호기', '5층', '2020-01-01', '1', '2020-12-31', '3개월');
insert into item(item_id, build_id, kind_type, item_name, location, from_date, status, check_date, check_cycle)
values('2', '2', 'E2', '엘레베이터 2호기', '10층', '2020-01-01', '1', '2020-12-31', '3개월');
insert into item(item_id, build_id, kind_type, item_name, location, from_date, status, check_date, check_cycle)
values('3', '3', 'E3', '엘레베이터 3호기', '8층', '2020-01-01', '1', '2020-12-31', '3개월');

######################################################################
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

#######################################################
insert into resident value(null, '101', '1','1','2','2024-01-01','2024-12-31','100000000','10000000');

## 담당업무 
#######################################################
insert into company_kind(kind_type, kind_name) values('1', '청소');
insert into company_kind(kind_type, kind_name) values('2', '전기');
insert into company_kind(kind_type, kind_name) values('3', '경비');
insert into company_kind(kind_type, kind_name) values('4', '공조');
insert into company_kind(kind_type, kind_name) values('5', '인터넷');
insert into company_kind(kind_type, kind_name) values('6', '엘리베이터');
insert into company_kind(kind_type, kind_name) values('7', '수도');
insert into company_kind(kind_type, kind_name) values('8', '소방');

## 계약업체
#######################################################
insert into company values('10001', '1', '1', '아담청소', '김대리', '010-1111-2222', '2023-04-01', '2026-03-31', '1500000', '{noop}1111', 'WORKER');
insert into company values('10002', '2', '2', '쌍용전기', '송과장', '010-2222-3333', '2023-04-01', '2026-03-31', '1500000', '{noop}1111', 'WORKER');
insert into company values('10003', '3', '3', '에이스가드', '정대리', '010-3333-4444', '2023-04-01', '2026-03-31', '1500000', '{noop}1111', 'WORKER');
insert into company values('10004', '4', '4', '한국공조', '박차장', '010-4444-5555', '2023-04-01', '2026-03-31', '1500000', '{noop}1111', 'WORKER');
insert into company values('10005', '1', '5', '유플러스', '이대리', '010-5555-6666', '2019-09-22', '2024-09-21', '1900000', '{noop}1111', 'WORKER');
insert into company values('10006', '2', '6', '오티스', '윤과장', '010-6666-7777', '2019-09-22', '2024-09-21', '1900000', '{noop}1111', 'WORKER');
insert into company values('10007', '3', '7', '우주환경', '김과장', '010-7777-8888', '2019-09-22', '2024-09-21', '1900000', '{noop}1111', 'WORKER');
insert into company values('10008', '4', '8', '대영소방', '정과장', '010-8888-9999', '2019-09-22', '2024-09-21', '1900000', '{noop}1111', 'WORKER');

select * from users;
select * from build;
select * from item;
select * from item_kind;
select * from estimate;
select * from image;
select * from image_category;
select * from cost;
select * from admin;
select * from company;
select * from company_kind;
select * from resident;
select * from resident where entered = 1;
select * from resident where entered = 2;