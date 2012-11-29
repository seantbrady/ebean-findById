# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table my_model (
  id                        bigint not null,
  constraint pk_my_model primary key (id))
;

create table my_model2 (
  id                        bigint not null,
  constraint pk_my_model2 primary key (id))
;

create sequence my_model_seq;

create sequence my_model2_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists my_model;

drop table if exists my_model2;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists my_model_seq;

drop sequence if exists my_model2_seq;

