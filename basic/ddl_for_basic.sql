-- так как в данной группе используются простые запросы
-- и в ней не испол Join то связей тут нету связи будут в главах которых они нужны
Create Database cd;
Use cd;
Create table members  
(
	memid int not null auto_increment,
    surname varchar(200) not null,
    firstname varchar(200) not null,
    address varchar(200) not null,
    zipcode int not null,
    telephone  varchar(200) not null,
    recommendedby int,
    joindate timestamp not null,
    primary key (memid),
    foreign key (recommendedby) references cd.members(memid)
);
Create table facilities
(
	facid int not null,
    name varchar(100) not null,
    membercost numeric not null,
    guestcost numeric not null,
    initialoutlay numeric not null,
    monthlymaintenance numeric not null,
    primary key (facid)
);