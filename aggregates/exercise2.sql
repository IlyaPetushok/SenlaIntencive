insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance)
values (33,'SPA 1', 12, 35, 3200, 250);
Select count(*) From cd.facilities where guestcost >=10;