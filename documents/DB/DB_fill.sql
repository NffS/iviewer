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

COMMIT;