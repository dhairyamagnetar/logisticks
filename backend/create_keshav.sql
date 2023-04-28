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

create table orders(
     id INT AUTO_INCREMENT,
     deliveryRate DOUBLE(10,2) NOT NULL,
     weight DOUBLE(10,2) NOT NULL,
     isFragile INT NOT NULL,
     isExpressDelivery INT NOT NULL,
     CONSTRAINT PK_orders PRIMARY KEY (id)
);

create table orderStatus (
    orderId INT NOT NULL AUTO_INCREMENT,
    currentLocationId INT,
    status INT,
    CONSTRAINT PK_orderId PRIMARY KEY (orderId)
);

create table sentBy (
    orderId INT NOT NULL,
    senderPhoneNumber VARCHAR(20) NOT NULL,
    orderTime DATETIME,
    CONSTRAINT PK_orderId PRIMARY KEY (orderId)
);

create table toBeReceivedBy (
    orderId INT NOT NULL,
    receiverPhoneNumber VARCHAR(20) NOT NULL,
    timeOfReceipt DATETIME,
    receptionOTP INT,
    CONSTRAINT PK_toBeReceivedBy_orderId PRIMARY KEY (orderId)
);

create table rate(
    fromLocationId INT NOT NULL,
    toLocationId INT NOT NULL,
    baseRate DOUBLE (10,2),
    CONSTRAINT PK_rate PRIMARY KEY (fromLocationId, toLocationId)
);

create table agent(
    phoneNumber varchar(20) NOT NULL,
    name varchar(100) NOT NULL,
    addressId int NOT NULL,
    isAdmin int NOT NULL,
    passwordHash varchar(512) NOT NULL,
    locationId int NOT NULL,
    vehicleNumber varchar(20) NOT NULL,
    salary int,
    CONSTRAINT PK_User PRIMARY KEY (phoneNumber)
);

create table tobeDeliveredBy(
    orderId int primary key,
    agentphoneNumber varchar(20)
);

alter table rate
add constraint FK_rate_fromLocationId
foreign key (fromLocationId) references location(id);

alter table rate
add constraint FK_rate_toLocationId
foreign key (toLocationId) references location(id);

alter table toBeReceivedBy
add constraint FK_toBeReceivedBy_orderId
foreign key (orderId) references orders(id);

alter table toBeReceivedBy
add constraint FK_toBeReceivedBy_receiverPhoneNumber
foreign key (receiverPhoneNumber) references user(phoneNumber);

alter table address
add constraint FK_AddressLocation
foreign key(locationId) references location(id);

alter table user
add constraint FK_UserAddress
foreign key(addressId) references address(id);

alter table orderStatus
add constraint FK_orderStatus_orderId
foreign key (orderId) references orders(id);

alter table orderStatus
add constraint FK_orderStatus_currentLocationId
foreign key (currentLocationId) references location(id);

alter table sentBy
add constraint FK_sentBy_orderId
foreign key (orderId) references orders(id);

alter table sentBy
add constraint FK_sentBy_senderPhoneNumber
foreign key (senderPhoneNumber) references user(phoneNumber);

alter table agent
add constraint FK_AgentAddress
foreign key(addressId) references address(id);

alter table agent
add constraint FK_AgentLocation
foreign key(locationId) references location(id);

alter table tobeDeliveredBy
add constraint FK_tobeDeliveredBy_orderId
foreign key(orderId) references orders(id);

alter table tobeDeliveredBy
add constraint FK_tobeDeliveredBy_PhoneNumber
foreign key(agentphoneNumber) references agent(phoneNumber);

--insert into location values(4,"Muzzafarpur","Patna","Bihar");
--
--insert into location(district, city, state) values ('East Singhbhum', 'Jamshedpur', 'Jharkhand'), ('Muzaffarpur', 'Muzaffarpur', 'Bihar'), ('
--Kolkata', 'Kolkata', 'West Bengal');
--
--insert into orders values(1,20.0,30.0,1,1);
--
--insert into orders values(2,30.0,40.0,0,0);
--
--insert into orders values(3,40.0,50.0,1,0);
--
--insert into orders values(4,50.0,60.0,0,1);
--
--insert into address values(1,"215","Electronic City",4);
--
--insert into address values(2,"122","Beliaghata",1);
--
--insert into address values(3,"119","Majestic",3);
--
--insert into user values("9876543210","Keshav",1,1,"password1");
--
--insert into user values("0123456789","Sunny",1,1,"password1");
--
--insert into user values("2468135790","Aditya",2,0,"password2");
--
--
--
--insert into sentBy values(2,"1234567890","2003-08-12");


