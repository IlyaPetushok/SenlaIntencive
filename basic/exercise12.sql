insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) values ('Guest', 'Guest', '10 Dragons Way, Winchester', 12384, '(822) 353-9973', 1, '2001-01-25');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) values ('Dares', 'Nany', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', 2, '2016-03-15');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) values ('Petushok', 'Ilya', 'Pushkina Dom, Kalatushkina', 99999, '(33) 103-2527', 2, '2020-03-15');
Select firstname,surname,joindate from cd.members order by joindate desc limit 1;