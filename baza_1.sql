drop database hotel;
create database hotel;
use hotel;
create table if not exists worker(
	id int auto_increment,
	login varchar(50) not null ,
	password varchar(50) not null,
	forename varchar(50),
	surname varchar(50),
	is_admin boolean default false,
	primary key (id))
;
create table if not exists client(
	id int auto_increment,
	forename varchar(50) not null,
	surname varchar(50) not null,
	pesel varchar(11),
	postal_code varchar(6),
	street varchar(50),
	city varchar(50),
	phone_number varchar(15),
	email_address varchar(50),
	primary key (id)
);
create table if not exists room(
	id int auto_increment,
	cost double,
	room_floor int,
	number_of_double_beds int,
	number_of_single_beds int,
	size double,
	primary key (id)
);
create table if not exists reservation(
	id int auto_increment,
	start_date date not null,
	end_date date,
	client_id int not null,
	room_id int not null,
	worker_id int not null,
	total_cost double,
	days int,
	primary key (id),
    foreign key (client_id) references client(id),
    foreign key (room_id) references room(id),
    foreign key (worker_id) references worker(id)
	);
create table if not exists issue(
	id int auto_increment,
	created_date date not null,
	issue_message varchar(500),
	client_id int not null,
	worker_id int not null,
	primary key (id),
    foreign key (worker_id) references worker(id))
;
