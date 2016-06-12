create table SiteUser (
	id identity,
	password varchar(255) not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	email varchar(30) not null
);
