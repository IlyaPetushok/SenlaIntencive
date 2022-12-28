insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (11,'Massage Room 4', 5, 25, 8000, 200);
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (12,'TMassage Room 5', 35, 80, 4000, 3000);
Select * From cd.facilities Where facid in('1','5');