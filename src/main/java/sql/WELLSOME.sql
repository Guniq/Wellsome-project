--- MySQL ---

---------- admin ---------
create table w_admin(
    id varchar(20) not null,
    pw varchar(20) not null,
    name varchar(20) not null,
    email varchar(30) not null
);

insert into w_admin values('test', 'test', '이건희', 'test@gmail.com');
select * from w_admin;
commit;

------------- category --------------
create table category(
    num int primary key auto_increment,
    code varchar(10) not null,
    name varchar(20) not null
);
drop table category;
select * from category;


-------------- product ---------------
create table product(
    pNum int primary key auto_increment,
    pName varchar(50) not null,
    pCategory_fk varchar(30) not null,
    pImage varchar(50),
    price int(10) default 0,
    pQty int(5) default 0,
    pSpec varchar(20),
    pContent varchar(300),
    pPoint int(8) default 0,
    pInputDate timestamp default now()
);
drop table product;

select * from product;

-------------- board---------------
create table board(
	bnum int primary key auto_increment,
    btitle varchar(100),
    bname varchar(20),
    bcontent varchar(500),
    bdate timestamp
);
drop table board;
select * from board;

-------------- user ---------------
create table user(
    no int primary key auto_increment,
    id varchar(20) not null,
    pw varchar(20) not null,
    name varchar(20) not null,
    email varchar(30),
    tel varchar(20) not null,
    zipcode varchar(10),
    roadAddr varchar(200),
    detailAddr varchar(200),
    unique key(id)
);

drop table user;

select * from user;

