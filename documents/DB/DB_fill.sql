/*Users_type insertion*/
INSERT INTO Users_type 
VALUES ( 1, 'Admin' );

INSERT INTO Users_type 
VALUES ( 2, 'HR' );

INSERT INTO Users_type 
VALUES ( 3, 'Interviewer' );

INSERT INTO Users_type 
VALUES ( 4, 'Candidate' );
/*End Users_type insertion*/

/*Users insertion*/
INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	1, 
	'adm@mail.ru',
	'1111',
	'Administrator',
	'Adminov',
	'Adminovich',
	1
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	2, 
	'hr1@mail.ru',
	'hr1',
	'Morj',
	'Tulenev',
	'Lamantinovich',
	2
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	3, 
	'hr2@ukr.net',
	'hr2',
	'Tulen',
	'Lamantinov',
	'Morjevich',
	2
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	4, 
	'inter1@nm.ru',
	'i1',
	'Lamantin',
	'Morjev',
	'Tulenevich',
	3
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	5, 
	'inter2@pop3.ru',
	'i2',
	'Ogurec',
	'Koroviev',
	'Anatolievich',
	3
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	6, 
	'inter3@mail.ru',
	'i3',
	'Svetlana',
	'Krizovnikova',
	'Semenovna',
	3
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	7, 
	'inter4@mail.ru',
	'i4',
	'Ilia',
	'Bananov',
	'Victorovich',
	3
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	8, 
	'user1@prolife.net',
	'user1',
	'Evgenii',
	'Gvozdev',
	'Nikolaevich',
	4
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	9, 
	'user2@rambler.ru',
	'user2',
	'Marfa',
	'Skritnaya',
	'Ivanovna',
	4
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	10, 
	'user3@remixer.com',
	'user3',
	'Afanasii',
	'Bredov',
	'Stepanovich',
	4
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	11, 
	'user4@saintly.com',
	'user4',
	'Avdotiya',
	'Mankova',
	'Gavrilovna',
	4
);

INSERT INTO Users 
(user_id, email, password, first_name, surname, last_name, user_type_id)
VALUES 
( 
	12, 
	'user5@mail.ru',
	'user5',
	'Metrophan',
	'Kazanov',
	'Motrosovich',
	4
);
/*End Users insertion*/

/*start insert for interwiew*/

INSERT INTO Interview VALUES(
    1,
		to_date('2013/05/03 08:00:00', 'yyyy/mm/dd hh24:mi:ss'),
		to_date('2013/05/03 20:00:00', 'yyyy/mm/dd hh24:mi:ss'),
		4
);

INSERT INTO Interview VALUES(
    2,
		to_date('2013/05/03 08:00:00', 'yyyy/mm/dd hh24:mi:ss'),
		to_date('2013/05/03 20:00:00', 'yyyy/mm/dd hh24:mi:ss'),
		4
);

/*end insert for interwie*/

/*insert for FORM form_id = 4*/

INSERT INTO Form VALUES(
		4,
		11,
		'Одесский национальный политехнический университет',
		'Программная инженерия',
		'2014',
		'email@mail.ru',
		'0639825462',
		'0974865162',
		'+,?',
		'+, администрирование БД',
    '-,+,+,-,',
		'С++ средний, java средний, PL/SQL низкий',		
		'-,+-,+,+,+,+,-,-, других нет',
		'ну была курсовая по предмету на тему и какой-то студенческий проект',
		'чтение 3, письмо 3, устная речь 1',
		'Прочитал на заборе',
		'Ну я очень умный, целеустремленный и жажду приключений',
		'Ходил на курсы вязания и программирования на android',
		0,
		1,
		0
);

INSERT INTO Form VALUES(
		5,
		12,
		'Одесский национальный политехнический университет',
		'Программная инженерия',
		'2012',
		'email2000@mail.ru',
		'0523654556',
		'0753658598',
		'+,?',
		'+, администрирование БД',
    '-,+,+,-,',
		'С++ средний, java средний, PL/SQL низкий',		
		'-,+-,+,+,+,+,-,-, других нет',
		'сайт для интернет магазина',
		'чтение 2, письмо 2, устная речь 2',
		'В интернете',
		'Пунктуален, энергичен, очень красив и обаятелен',
		'Ходил в универ на все пары',
		0,
		2,
		0
);

/*end of insert for FORM*/

COMMIT;