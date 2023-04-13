create database logisticks;
use logisticks;
-- create table Order(id INT,deliveryrate double(5,2),weight double(5,2),isfragile bool,isexpressdelivery bool);
create table OrderStatus(orderId int,currentLocationId int,status int);

create table SentBy(orderId int,senderphoneNumber varchar(10),orderTime varchar(20));

create table ToBeReceivedBy(orderId int,receiverPhoneNumber varchar(10),timeofReceipt varchar(10),ReceptionOTP varchar(6));

create table ToBeDeliveredBy(orderId int,agentPhoneNumber varchar(10));

create table User(phoneNumber varchar(10),name varchar(20),addressId int,isAdmin bool);

create table Agent(locationId int,addressId int,name varchar(20),vehicleNumber varchar(8),phoneNumber varchar(10),isAdmin bool,salary int);

create table Address(id int,houseNumber varchar(10),locality varchar(15),locationId int);

create table Location(id int,district varchar(15),city varchar(15),state varchar(15));

create table Rate(fromLocationId int,toLocationId int,baseRate double(7,2));

ALTER TABLE Orders ADD FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);