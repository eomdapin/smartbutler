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
    name varchar(30) not null COMMENT '회원명',
    phone char(13) not null COMMENT '휴대폰 번호',
    email varchar(100) not null unique COMMENT '이메일 주소',
    status smallint not null default 1 COMMENT '회원 유형',
    pw text not null COMMENT '비밀번호',
    role varchar(30) not null COMMENT '권한',
    primary key(user_id)
);

# 입주 현황
# status = 입실 여부
# 1 = 입실, 2 = 공실
drop table if exists resident;
create table if not exists resident (
	resident_id bigint not null COMMENT '방 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    user_id bigint not null COMMENT '회원 고유 번호',
    status smallint not null COMMENT '입실 여부',
    from_date date not null COMMENT '계약 시작일',
    to_date date not null COMMENT '계약 종료일',
    deposit bigint not null COMMENT '보증금',
    monthly bigint not null COMMENT '월세',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(user_id) references user(user_id) on delete cascade,
    primary key(resident_id, build_id, user_id)
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
    foreign key(user_id) references user(user_id) on delete cascade,
    primary key(claim_id)
);

# 담당 업무
drop table if exists company_kind;
create table if not exists company_kind (
	kind_type char(20) not null COMMENT '담당 업무 코드',
    kind_name char(100) not null COMMENT '담당 업무명',
    primary key(kind_type)
);

# 계약 업체
drop table if exists company;
create table if not exists company (
	company_id bigint not null auto_increment COMMENT '업체 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    kind_type char(20) not null COMMENT '담당 업무 코드',
    company_name varchar(100) not null COMMENT '업체명',
    manager varchar(30) not null COMMENT '담당자명',
    phone char(13) not null COMMENT '전화번호',
    from_date date not null COMMENT '계약 시작일',
    to_date date not null COMMENT '계약 종료일',
    cost bigint not null COMMENT '계약 비용',
    pw text not null COMMENT '비밀번호',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(kind_type) references company_kind(kind_type) on update cascade,
    primary key(company_id, build_id, kind_type)
);

# 견적
# confirm = 승인 여부
# 1 = 신청, 2 = 승인, 3 = 반려
drop table if exists estimate;
create table if not exists estimate (
	estimate_id bigint not null auto_increment COMMENT '견적 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    user_id bigint not null COMMENT '회원 고유 번호',
    room int not null COMMENT '방 번호',
    deposit bigint not null COMMENT '보증금',
    monthly bigint not null COMMENT '월세',
    to_date date not null COMMENT '입실 일자',
    confirm smallint not null COMMENT '승인 여부',
    content text COMMENT '반려 사유',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(user_id) references user(user_id) on delete cascade,
    primary key(estimate_id, build_id, user_id)
);

# 관리비
# send = 전송 여부
# 1 = 미전송, 2 = 전송
drop table if exists cost;
create table if not exists cost (
	cost_id bigint not null auto_increment COMMENT '관리비 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    date date not null COMMENT '관리비 일자',
    send smallint not null COMMENT '전송 여부',
    foreign key(build_id) references build(build_id) on delete cascade,
    primary key(cost_id, build_id)
);

# 관리비 부여 항목
drop table if exists cost_kind;
create table if not exists cost_kind (
	cost_id bigint not null COMMENT '관리비 고유 번호',
    electricity bigint not null COMMENT '전기료',
    repair bigint not null COMMENT '수리비',
    upkeep bigint not null COMMENT '유지관리비',
    consignment bigint not null COMMENT '전문위탁비',
    foreign key(cost_id) references cost(cost_id) on delete cascade,
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
    primary key(item_id, build_id, kind_type)
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
    ask_date date not null COMMENT '요청 날짜',
    content text not null COMMENT '요청 내용',
    fin_date date COMMENT '완료 날짜',
    status smallint not null COMMENT '처리 상태',
    report_content text COMMENT '보고 내용',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(item_id) references item(item_id),
    foreign key(company_id) references company(company_id),
    primary key(job_id, build_id)
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

insert into admin values(null, 'admin', '{noop}1111', 'ADMIN');
select * from admin;

# 작업자
drop table if exists worker;
create table if not exists worker (
	worker_id bigint not null auto_increment COMMENT '작업자 고유 번호',
    username varchar(255) not null COMMENT '작업자 아이디',
    password varchar(255) not null COMMENT '비밀번호',
    role varchar(255) not null COMMENT '작업자 권한',
    primary key(worker_id)
);

insert into worker values(null, 'worker', '{noop}1111', 'WORKER');
select * from worker;

#######################################################
insert into users(name, phone, email, pw, status, role)
values('홍길동', '010-0000-0000', 'mail@mail.com', '1234', '1', 'USER');

insert into users(name, phone, email, pw, status, role)
values('홍박사', '010-1111-1111', 'mail1@mail.com', '1111','1', 'USER');

insert into users(name, phone, email, pw, status, role)
values('빅보검', '010-2222-2222', 'mail2@mail.com', '1111', '1', 'USER');

###########################################################################
insert into build(build_name, address, floor, room, area, com_date)
values('신촌점', '서울 서대문구 연세로 8-1', '5', '10', '100', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('서울역점', '서울 용산구 한강대로 405', '10', '15', '80', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('홍대입구점', '서울 마포구 양화로 지하 160', '8', '5', '120', '2020-01-01');
insert into build(build_name, address, floor, room, area, com_date)
values('인사동점', '서울 종로구 율곡로 지하 62', '3', '5', '70', '2020-01-01');

##########################################################################
insert into item_kind(kind_type, kind_name)
values('E10', '엘레베이터');
insert into item(item_id, build_id, kind_type, item_name, location, from_date, status, check_date, check_cycle)
values('2', '2', 'E10', '엘레베이터 2호기', '8층', '2020-01-01', '1', '2020-12-31', '3');

select * from user;
select * from build;
select * from item;
select * from item_kind;
select * from image;
select * from image_category;

