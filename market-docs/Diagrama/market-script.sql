/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     18/12/2016 00:51:38                          */
/*==============================================================*/


drop table if exists cart;

drop table if exists customer;

drop table if exists item_cart;

drop table if exists order_buy;

drop table if exists payment;

drop table if exists product;

/*==============================================================*/
/* Table: cart                                                  */
/*==============================================================*/
create table cart
(
   id                   int not null,
   discount             decimal not null,
   total_cart           decimal not null,
   primary key (id)
);

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   id                   int not null,
   name                 varchar(255) not null,
   email                varchar(150) not null,
   birth_date           date not null,
   phone                varchar(20) not null,
   address              varchar(255) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: item_cart                                             */
/*==============================================================*/
create table item_cart
(
   id                   int not null,
   product_id           int not null,
   quantity             int not null,
   total_item           decimal not null,
   cart_id              int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: order_buy                                             */
/*==============================================================*/
create table order_buy
(
   id                   int not null,
   number               varchar(255) not null,
   cart_id              int not null,
   customer_id          int not null,
   payment_id           int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: payment                                               */
/*==============================================================*/
create table payment
(
   id                   int not null,
   name                 varchar(255) not null,
   number               varchar(30) not null,
   month_expiration     varchar(10) not null,
   year_expiration      varchar(10) not null,
   security_code        varchar(10) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   id                   int not null,
   name                 varchar(150) not null,
   description          varchar(200) not null,
   price                decimal not null,
   image                varchar(100) not null,
   primary key (id)
);

alter table item_cart add constraint fk_item_cart_cart foreign key (cart_id)
      references cart (id);

alter table item_cart add constraint fk_item_cart_product foreign key (product_id)
      references product (id);

alter table order_buy add constraint fk_order_buy_cart foreign key (cart_id)
      references cart (id) on delete restrict on update restrict;

alter table order_buy add constraint fk_order_buy_customer foreign key (customer_id)
      references customer (id);

alter table order_buy add constraint fk_order_buy_payment foreign key (payment_id)
      references payment (id);

