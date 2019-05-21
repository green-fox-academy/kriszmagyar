create database todo;
show databases;
use todo;

create table users (
	id int auto_increment primary key,
    name varchar(30) not null
);

create table tasks (
	id int auto_increment primary key,
    title varchar(30) not null,
    description text,
    is_completed boolean default false,
    user_id int,
    foreign key (user_id) references users(id)
);

show tables;
describe users;
describe tasks;









































