create database os_systems;

\connect os_systems;

create table os (
  id bigint primary key generated always as identity,
  name character varying(255) not null,

  CONSTRAINT os_name_uniq UNIQUE (name)
);

insert into os (name) values ('FreeBSD'), ('Debian'), ('UNIX'), ('xv6');
