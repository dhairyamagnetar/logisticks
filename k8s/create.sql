use logisticks;

GRANT ALL ON *.* TO 'root'@'%';
FLUSH PRIVILEGES;

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

create table tobedeliveredby(
    orderId INT NOT NULL,
    agentPhoneNumber varchar(20) NOT NULL,
    CONSTRAINT PK_agent PRIMARY KEY (orderId)
);

alter table tobedeliveredby
add constraint FK_tobedeliveredby_agent
foreign key (agentPhoneNumber) references agent(phoneNumber);

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

insert into location(district, city, state) values ('East Singhbhum', 'Jamshedpur', 'Jharkhand'), ('Muzaffarpur', 'Muzaffarpur', 'Bihar'), ('Kolkata', 'Kolkata', 'West Bengal');

insert into rate values (1, 2, 8), (1, 3, 7), (2, 1, 8), (3, 1, 7), (2, 3, 10), (3, 2, 10);