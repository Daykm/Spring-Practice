create table SiteUser (
	id identity,
	password varchar(255) not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	email varchar(30) not null
);


create table weapon (
    id identity,
    name varchar(255) not null,
);

create table weapon_attributes (
    id identity,
    damage int not null,
    magic_damage int not null,
    weight int not null,
    foreign key (id) references public.weapon
);

create table material (
    id identity,
    name varchar(255),
);

create table weapon_upgrade_requirements (
    id identity,
    quantity int,
    foreign key (id) references public.weapon_attributes,
    foreign key (id) references public.material
);

