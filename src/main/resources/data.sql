DROP TABLE IF EXISTS student;
create table student
(
    id integer not null,
    name varchar(255) not null,
    dob DATETIME not null,
    primary key(id)
);

insert into student
values(10001,'Stud1', sysdate());

insert into student
values(10002,'Ravi', sysdate());

/*
insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10001,'USD','INR',75,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10002,'EUR','INR',85,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10003,'AUD','INR',25,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10001,'C','F',33.8,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10002,'F','C',-17.22,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10003,'miles','km',1.60934,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10001,'km','miles',0.621371,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10002,'lb','kg',0.453592,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10003,'kg','lb',2.204620823516057,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10001,'gallon','liter',3.78541,0);

insert into conversion_table(id,data_from,data_to,conversion_multiple,port)
values(10002,'liter','gallon',0.264172,0);

 */