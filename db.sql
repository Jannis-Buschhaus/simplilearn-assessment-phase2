create user 'remoteUser'@'10.88.0.4' identified by 'my_password';
grant all privileges on *.* to 'remoteUser'@'10.88.0.4' with grant option;

-- Create and use database to work on
create database funfit_db;
use funfit_db;

-- Create tables for batches and participants
create table batch(batchId int primary key auto_increment, typeOfBatch enum('morning', 'evening'), time varchar(10));
create table participants(partId int primary key auto_increment, fname varchar(30), lname varchar(30), age int, phoneNumber varchar(10), batchId int, foreign key(batchId) references batch(batchId) on delete set null);

-- Create first set of batches
insert into batch values(null, 'morning', '8am');
insert into batch values(null, 'morning', '9am');
insert into batch values(null, 'evening', '6pm');

-- Create first set of participants
insert into participants values(null, 'Jannis', 'Buschhaus', 29, '0123456789', 1);
insert into participants values(null, 'John', 'Doe', 29, '0123456789', 1);
insert into participants values(null, 'Jane', 'Done', 66, '0123456789', 2);
insert into participants values(null, 'Gus', 'Fring', 43, '0987654321', 3);
