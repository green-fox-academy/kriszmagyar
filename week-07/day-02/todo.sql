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

insert into users
	(name) values
    ('Krisz'), ('Zsoti'), ('Geri'), ('Mate');

select * from users;

insert into tasks
	(title, user_id) values
    ('Walk the dog', 1),
    ('Write homework', 1),
    ('Copy homework of Krisz', 4),
    ('Praise the gods', 4),
    ('Be cool', 2),
    ('Walk the dog again', 1);

select * from tasks;

update tasks
set title = 'Copy the homework of Krisz'
where title like 'Copy homework%';

update tasks
set is_completed = 1
where user_id = 4
and title like '%homework%'
limit 1;

delete from tasks
where id = 6;

select name, title from users join tasks
on users.id = tasks.user_id
where users.name = 'Krisz'
order by tasks.title
limit 1;

select name, count(tasks.id) as NumbOfTasks from users left join tasks
on users.id = tasks.user_id
where tasks.is_completed = 0
group by users.name
having name in ('Krisz', 'Mate')
order by NumbOfTasks asc;



























