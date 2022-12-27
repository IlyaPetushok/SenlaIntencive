insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Charles', 'Owen', '112 Drive', 18978, '(233) 413-2527', 17, '2011-12-15');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Jack', 'Smith', 'Olga Solomova', 22518, '(333) 103-527', 21, '2008-09-21');
Select row_number() over (order by joindate), firstname, surname
from cd.members order by joindate;