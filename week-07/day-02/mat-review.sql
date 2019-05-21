show databases;
create database if not exists mat_review ;
use mat_review;

create table customers (
	id int auto_increment primary key,
	name varchar(30) not null,
    age smallint unsigned,
    gender enum('F', 'M')
);

show tables;

create table meals (
	id int auto_increment primary key,
    name varchar(30) not null,
    price int not null
);

create table orders (
	id int auto_increment primary key,
    date timestamp,
    customer_id int,
    meal_id int,
    foreign key (customer_id) references customers(id),
    foreign key (meal_id) references meals(id)
);

show tables;

insert into customers values (
	null, 'Suvi', 26, 'M'
);
insert into customers (name, age, gender) values (
	'Barna', 25, 'M'
);
insert into customers (name, age, gender) values
	('Aelx', 23, 'M'),
    ('Tojas', 31, 'M'),
    ('Andrea', 18, 'F');
    
select * from customers;

insert into meals (name, price) values
	('hamburger', 1000),
    ('gyros', 500),
    ('pencakes', 250),
    ('salad', 1600),
    ('choclate cake', 900),
    ('muffin', 750);
    
select * from meals;

insert into orders (date, customer_id, meal_id) values
	(now(), 1, 2),
    (now(), 1, 1),
    (now(), 2, 3),
    (now(), 2, 4),
    (now(), 3, 5);
    
select name from customers
where age <= 26;

select name from customers
where age between 23 and 26;

select count(*) from orders
where customer_id = 1;
    
select count(*) from orders, customers
where orders.customer_id = customers.id
and customers.name = 'Suvi';    
    
select gender, count(*) from customers
group by gender;    

select date from meals join orders
on orders.meal_id = meals.id
where meals.name = 'gyros';

set sql_safe_updates = 0;
update customers set age = 50
where name = 'Suvi';

alter table customers
change age customer_age tinyint unsigned;

describe customers;










