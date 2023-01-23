-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: src/main/liquibase/changelog-master.xml
-- Ran at: 16.01.2023, 02:24
-- Against: postgres@jdbc:postgresql://localhost:5432/VapeShop
-- Liquibase version: 4.18.0
-- *********************************************************************

SET SEARCH_PATH TO public, "$user","public";

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = 'DESKTOP-K0NESJE (172.23.128.1)', LOCKGRANTED = NOW() WHERE ID = 1 AND LOCKED = FALSE;

SET SEARCH_PATH TO public, "$user","public";

SET SEARCH_PATH TO public, "$user","public";

-- Changeset homework-2::category-for-item::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

Create table category(
	id_category integer primary key generated always as identity,
	name character varying(30) not null
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('category-for-item', 'Ilya Petushok', 'homework-2', NOW(), 1, '8:9181117be49288099aefd9a948d00f90', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::item-home::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

Create table item (
	id_item integer primary key generated always as identity,
	photo text not null default('path_on_default_photo'),
	name character varying(40) not null,
	id_category integer references category(id_category) on delete cascade not null,
	price numeric(6,2) not null,
	quantity integer not null
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('item-home', 'Ilya Petushok', 'homework-2', NOW(), 2, '8:35fced6a139622bd42ca382b53a0a538', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::liquide-item-category::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table liquide (
	liquide_id_item integer not null,
	flavour character varying(40) not null,
	fortress integer not null default(0),
	type_nicotine character varying(15) 
	check (type_nicotine in ('солевой','обычный','без никотина')),
	volume integer not null,
	foreign key (liquide_id_item) references item(id_item)
 	on delete cascade
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('liquide-item-category', 'Ilya Petushok', 'homework-2', NOW(), 3, '8:6300c8f9e99166042cc47107284d8e46', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::vaporizer-item-category::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table vaporizer (
	vaporizer_id_item integer not null unique,
	resistance numeric(4,2) not null,
	type_vaporizer character varying(15) 
	check (type_vaporizer in ('испаритель','койлы','картриджы')),
	foreign key (vaporizer_id_item) references item(id_item)
	on delete cascade
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('vaporizer-item-category', 'Ilya Petushok', 'homework-2', NOW(), 4, '8:d2192210d18fa5188cdc8481430f72ad', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::vape-item-category::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table vape(
	vape_id integer not null unique,
	power_vape integer not null,
	battery integer not null,
	type_vape character varying(30),
	foreign key (vape_id) references item(id_item) on delete cascade
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('vape-item-category', 'Ilya Petushok', 'homework-2', NOW(), 5, '8:690ff586c3202d3eb5f56ca121c5accc', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::role-for-users::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table role(
	id_role integer generated always as identity,
	name_role character varying(40) not null,
	Primary key(id_role)
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('role-for-users', 'Ilya Petushok', 'homework-2', NOW(), 6, '8:a1c1706d46ed61026c1584bf028e13a5', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::privileges-for-user::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table privileges(
	id_privelege integer generated always as identity,
	name_privelege character varying(40) not null,
	Primary key(id_privelege)
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('privileges-for-user', 'Ilya Petushok', 'homework-2', NOW(), 7, '8:e435ce799214a06e8bc7a003f6e87f64', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::relation-role-and-privileges::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table role_privileges(
	rp_id_role integer references role(id_role),
	rp_id_privileges integer references privileges(id_privelege)
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('relation-role-and-privileges', 'Ilya Petushok', 'homework-2', NOW(), 8, '8:edc984d073b6b266e51c79660de24c96', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::user-home::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table users(
	id_user integer primary key generated always as identity,
	surname character varying(30) not null,
	name character varying(30) not null,
	patronymic character varying(30) not null,
	login character varying(30) not null unique,
	password character varying(30) not null,
	mail character varying(30) not null unique,
	user_id_role integer references role(id_role) on delete cascade
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('user-home', 'Ilya Petushok', 'homework-2', NOW(), 9, '8:45d351858dc1f8b196d405ab8fd36aca', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::rating-for-item::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table rating(
	id_rating integer primary key generated always as identity,
	comment text default('Комментарий отсутствует'),
	quantity_stars integer not null,
	rating_id_item integer references item(id_item),
	rating_id_user integer references users(id_user)
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('rating-for-item', 'Ilya Petushok', 'homework-2', NOW(), 10, '8:e1ea520ec34d45cec16d37209770e9d3', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::order-home::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table orders(
	id_order integer primary key generated always as identity,
	data_order timestamp not null,
	order_id_user integer references users(id_user),
	status_order character varying(15) 
	check (status_order in ('принят','отправлен','прибыл')),
	total_price numeric(6,2) not null									
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('order-home', 'Ilya Petushok', 'homework-2', NOW(), 11, '8:bfbba088203d25d13c5bbdfb9eee2f1e', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::relation-order-item::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

create table order_item(
	ot_id_order integer references orders(id_order),
	ot_id_item integer references item(id_item)
);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('relation-order-item', 'Ilya Petushok', 'homework-2', NOW(), 12, '8:bb9f289ad08c66981e2283fa9efc688f', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::insert-data-vapeshop::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

Insert Into category (name) values ('Жидкости'),('Испарители,Картриджы,Койлы'),('Вейпы и подики');

Insert Into item(photo,name,id_category,price,quantity) values ('path\photo1','Мишки 3в1',1,21.5,14);

Insert Into item(photo,name,id_category,price,quantity) values ('path\photo2','Испаритель Charon Buttlestar',2,9,30);

Insert Into item(photo,name,id_category,price,quantity) values ('path\photo3','IJoy Captain 226',3,159.99,3);

Insert Into liquide(liquide_id_item,flavour,fortress,type_nicotine,volume) values (1,'Кофе 3в1',50,'солевой',30);

Insert Into vaporizer(vaporizer_id_item,resistance,type_vaporizer) values (2,0.6,'испаритель');

Insert Into vape(vape_id,power_vape,battery,type_vape) Values (3,225,20000,'Вейп');

Insert Into role(name_role) values ('user');

Insert Into privileges(name_privelege) values('Просмотр');

Insert Into role_privileges(rp_id_role,rp_id_privileges) values (1,1);

Insert Into users(surname,name,patronymic,login,password,mail,user_id_role) 
values ('Петушок','Илья','Александрович','login','password','mail@mail.com',1);

Insert Into rating(comment,quantity_stars,rating_id_item,rating_id_user) 
values ('Очень вкусная жижа,отлично передаёт вкус кофе и не сильно сладкая',5,1,1);

Insert Into rating(comment,quantity_stars,rating_id_item,rating_id_user) 
values ('Неплохой подик очень удобный и хорошо лежит в руке.Но немного протекает картридж',4,3,1)

Insert Into orders(data_order,order_id_user,status_order,total_price) values ('2023-11-01 18:20:59',1,'принят',168.99);

Insert Into order_item(ot_id_order,ot_id_item) values (1,2);

Insert Into order_item(ot_id_order,ot_id_item) values (1,3);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('insert-data-vapeshop', 'Ilya Petushok', 'homework-2', NOW(), 13, '8:13ce0809e00f7c910d8d76ce19577afb', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Changeset homework-2::create_index_for_vapeshop::Ilya Petushok
SET SEARCH_PATH TO public, "$user","public";

Create index on item(id_category);

Create index on vaporizer(vaporizer_id_item);

Create index on vape(vape_id);

Create index on liquide(liquide_id_item);

Create index on rating(rating_id_item);

Create index on rating(rating_id_user);

Create index on users(user_id_role);

Create index on role_privileges(rp_id_role);

Create index on role_privileges(rp_id_privileges);

Create index on orders(order_id_user);

Create index on order_item(ot_id_order);

Create index on order_item(ot_id_item);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('create_index_for_vapeshop', 'Ilya Petushok', 'homework-2', NOW(), 14, '8:2e3b62a29a734357a5498fd04eb265f5', 'sqlFile', '', 'EXECUTED', NULL, NULL, '4.18.0', '3825045893');

-- Release Database Lock
SET SEARCH_PATH TO public, "$user","public";

UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

SET SEARCH_PATH TO public, "$user","public";

