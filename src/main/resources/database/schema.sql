drop database if exists smartbutler;

create database if not exists smartbutler character set = utf8mb4;

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

drop table if exists users;
create table if not exists user (
	user_id bigint not null auto_increment COMMENT '회원 고유 번호',
    name varchar(30) not null COMMENT '회원명',
    phone char(13) not null COMMENT '휴대폰 번호',
    email varchar(100) not null unique COMMENT '이메일 주소',
    status smallint not null default 1 COMMENT '회원 유형',
    pw text not null COMMENT '비밀번호',
    role varchar(20) not null COMMENT '권한',
    primary key(user_id)
);

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

drop table if exists company_kind;
create table if not exists company_kind (
	kind_id bigint not null auto_increment COMMENT '업무 고유 번호',
    kind_name varchar(100) not null COMMENT '담당 업무명',
    primary key(kind_id)
);

drop table if exists company;
create table if not exists company (
	company_id bigint not null auto_increment COMMENT '업체 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    kind_id bigint not null COMMENT '업무 고유 번호',
    company_name varchar(100) not null COMMENT '업체명',
    manager varchar(30) not null COMMENT '담당자명',
    phone char(13) not null COMMENT '전화번호',
    from_date date not null COMMENT '계약 시작일',
    to_date date not null COMMENT '계약 종료일',
    cost bigint not null COMMENT '계약 비용',
    pw text not null COMMENT '비밀번호',
    role text not null COMMENT '권한',
    foreign key(build_id) references build(build_id) on delete cascade,
    foreign key(kind_id) references company_kind(kind_id) on update cascade,
    primary key(company_id)
);

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

drop table if exists cost;
create table if not exists cost (
	cost_id bigint not null auto_increment COMMENT '관리비 고유 번호',
    build_id bigint not null COMMENT '건물 고유 번호',
    date date not null COMMENT '관리비 일자',
    send smallint not null COMMENT '전송 여부',
    foreign key(build_id) references build(build_id) on delete cascade,
    primary key(cost_id, build_id)
);

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

drop table if exists item_kind;
create table if not exists item_kind (
	kind_type varchar(20) not null COMMENT '시설 종류 코드',
    kind_name varchar(100) not null COMMENT '시설 종류 이름',
    primary key(kind_type)
);

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

drop table if exists image_category;
create table if not exists image_category (
	coded char(20) not null COMMENT '이미지 코드',
    code_name char(50) not null COMMENT '분류 이름',
    primary key(coded)
);

insert into image_category values("b", "건물"),
("j","작업"),
("c","민원");


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

drop table if exists admin;
create table if not exists admin (
	admin_id bigint not null auto_increment COMMENT '관리자 고유 번호',
    username varchar(255) not null COMMENT '관리자 아이디',
    password varchar(255) not null COMMENT '비밀번호',
    role varchar(255) not null COMMENT '관리자 권한',
    primary key(admin_id)
);
