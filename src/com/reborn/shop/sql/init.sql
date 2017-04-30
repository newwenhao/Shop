drop database if EXISTS  itat_shop;
create database itat_shop;
GRANT ALL ON itat_shop.* to 'itat'@'localhost' IDENTITY  by 'itat123';
use itat_shop;
create table t_user(
  id int(11) primary key auto_increment,
  username varchar(100),
  password varchar(100),
  nickname varchar(100),
  type int(5)
);

create table t_address(
  id int(11) primary key auto_increment,
  name varchar(255),
  phone varchar(100),
  postcode varchar(100),
  user_id int(11),

  CONSTRAINT FOREIGN KEY (user_id) references t_user (id)
);

create table t_orders(
  id int(11) primary key auto_increment,
  buy_date datetime ,
  pay_date datetime,
  confirm_date datetime,
  status int(5),
  user_id int(11),
  address_id int(11),
  CONSTRAINT FOREIGN KEY (user_id) references t_user (id),
  CONSTRAINT FOREIGN KEY (address_id) references t_address(id)
);
create table t_category(
  id int(11) PRIMARY  key auto_increment,
  name varchar(100)
);
create table t_goods(
  id int(11) primary key auto_increment,
  name varchar(100),
  price double,
  introduce text,
  image varchar(100),
  stocks int(10),
  c_id int(10),
  CONSTRAINT FOREIGN KEY (c_id) references t_category (id)
);
create table t_goods_orders(
  id int(11) primary key auto_increment,
  goods_id int(10),
  orders_id int(10),
  CONSTRAINT FOREIGN KEY (goods_id) references t_goods (id),
  CONSTRAINT FOREIGN KEY (orders_id) references t_goods (id)

)