insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Tim', 'Rowman', '10 Drive', 18978, '(233) 413-2527', 31, '2011-12-15');
Select distinct count(*) over(), firstname, surname
from cd.members order by joindate;