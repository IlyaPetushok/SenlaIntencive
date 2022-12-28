insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (21,'Massage Room 7', 5, 0, 400, 200);
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (22,'Squash Court 8', 0, 200, 2500, 5000);
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) values ('Tracy', 'Burton', '5 Dragons Way, Winchester', 10384, '(822) 354-9973', null, '2012-07-25');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) values ('Dare', 'Nancy', '3 Tunisia Drive, Boston', 45678, '(811) 433-2547', null, '2012-07-15');
select surname from cd.members union select name from cd.facilities;