Create Database cd;
Use cd;
Create table members  
(
	memid int not null auto_increment primary key,
    surname varchar(200) not null,
    firstname varchar(200) not null,
    address varchar(200) not null,
    zipcode int not null,
    telephone  varchar(200) not null,
    recommendedby int,
    joindate timestamp not null,
    foreign key (recommendedby) references cd.members(memid)
);
Create table facilities
(
	facid int not null primary key,
    name varchar(100) not null,
    membercost numeric not null,
    guestcost numeric not null,
    initialoutlay numeric not null,
    monthlymaintenance numeric not null
);

Create table bookings(
	facid int not null,
    memid int not null,
    Constraint fk_facid foreign key (facid) references cd.facilities(facid),
	Constraint fk_memid foreign key (memid) references cd.members(memid)
);
Alter table `cd`.`bookings` 
add column `starttime` timestamp not null after `memid`;
alter table `cd`.`bookings` 
add column `slots` int not null after `starttime`;