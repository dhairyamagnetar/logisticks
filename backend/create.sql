create database logisticks;
use logisticks;

create table user(
    phoneNumber varchar(20) NOT NULL,
    name varchar(100) NOT NULL,
    addressId int NOT NULL,
    isAdmin int NOT NULL,
    passwordHash varchar(512) NOT NULL,
    CONSTRAINT PK_User PRIMARY KEY (phoneNumber)
);

create table address(
    id int NOT NULL AUTO_INCREMENT,
    houseNumber varchar(255),
    locality varchar(255),
    locationId int NOT NULL,
    CONSTRAINT PK_Address PRIMARY KEY (id)
);

create table location(
    id int NOT NULL AUTO_INCREMENT,
    district varchar(100) NOT NULL,
    city varchar(100) NOT NULL,
    state varchar(100) NOT NULL,
    CONSTRAINT PK_Location PRIMARY KEY (id)
);

alter table address
add constraint FK_AddressLocation
foreign key(locationId) references location(id);

alter table user
add constraint FK_UserAddress
foreign key(addressId) references address(id);

insert into location(district, city, state) values ('East Singhbhum', 'Jamshedpur', 'Jharkhand'), ('Muzaffarpur', 'Muzaffarpur', 'Bihar'), ('
Kolkata', 'Kolkata', 'West Bengal');
