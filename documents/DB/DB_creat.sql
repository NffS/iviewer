DROP TABLE Users     	CASCADE CONSTRAINTS;
DROP TABLE Users_type   CASCADE CONSTRAINTS;
DROP TABLE HR_mark		CASCADE CONSTRAINTS;
DROP TABLE Tech_mark	CASCADE CONSTRAINTS;
DROP TABLE Interview	CASCADE CONSTRAINTS;
DROP TABLE Form			CASCADE CONSTRAINTS;

CREATE TABLE Users_type
    ( 
		user_type_id    NUMBER(6) NOT NULL PRIMARY KEY,
		type_name    	VARCHAR2(20) NOT NULL
    );

CREATE TABLE Users
    ( 
		user_id    		NUMBER(6) NOT NULL PRIMARY KEY,
		email   		VARCHAR2(20) NOT NULL,
		password 		VARCHAR2(16) NOT NULL,
		first_name  	VARCHAR2(20) NOT NULL,
		surname			VARCHAR2(20) NOT NULL,
		last_name		VARCHAR2(20) NOT NULL,
		foto			VARCHAR2(40),
		user_type_id	NUMBER(6) REFERENCES Users_type (user_type_id)
    );
	
CREATE TABLE Interview
	(
		interview_id	NUMBER(6) NOT NULL PRIMARY KEY,
		start_date		DATE NOT NULL,
		end_date		DATE NOT NULL,
		seats	 		NUMBER(3) NOT NULL
	);
	
CREATE TABLE Form
	(
		form_id		 		NUMBER(6) NOT NULL PRIMARY KEY,
		candidate_id		NUMBER(6) NOT NULL REFERENCES Users (user_id),
		university			VARCHAR2(400),
		faculty 			VARCHAR2(400),
		course	 			NUMBER(1),
		end_year			VARCHAR2(5),
		email2				VARCHAR2(20),
		phone				VARCHAR2(20),
		another_contact		VARCHAR2(200),
		interest_tc 		VARCHAR2(2) NOT NULL,
		interest_nc 		VARCHAR2(2) NOT NULL,
		interest_area_po 	VARCHAR2(2)	NOT NULL,
		interest_area_other VARCHAR2(400),
		job_ar_deep_spec 	VARCHAR2(2) NOT NULL,
		job_ar_varied 		VARCHAR2(2) NOT NULL,
		job_ar_manage 		VARCHAR2(2) NOT NULL,
		job_ar_sales		VARCHAR2(2) NOT NULL,
		job_ar_other 		VARCHAR2(400),
		prog_lang_c 		NUMBER(1) NOT NULL,
		prog_lang_java		NUMBER(1) NOT NULL,
		prog_lang_other 	VARCHAR2(400),
		cs_network_tech 	NUMBER(1) NOT NULL,
		cs_algorithms 		NUMBER(1) NOT NULL,
		cs_oop	 			NUMBER(1) NOT NULL,
		cs_gui 				NUMBER(1) NOT NULL,
		cs_db 				NUMBER(1) NOT NULL,
		cs_web 				NUMBER(1) NOT NULL,
		cs_network_prog 	NUMBER(1) NOT NULL,
		cs_desing 			NUMBER(1) NOT NULL,
		experience			VARCHAR2(2000),
		english_read 		NUMBER(1) NOT NULL,
		english_write		NUMBER(1) NOT NULL,
		english_spoken	 	NUMBER(1) NOT NULL,
		source				VARCHAR2(200) NOT NULL,
		motivation_comment	VARCHAR2(800) NOT NULL,
		comment2			VARCHAR2(2000) NOT NULL,
		status	 			NUMBER(1) NOT NULL,
		interview_id		NUMBER(6) REFERENCES Interview (interview_id),
		visit_status		NUMBER(1)
	);

CREATE TABLE HR_mark
	(
		hr_mark_id 		NUMBER(6) NOT NULL PRIMARY KEY,
		hr_id			NUMBER(6) NOT NULL REFERENCES Users (user_id),
		form_id			NUMBER(6) NOT NULL REFERENCES Form (form_id),
		motivation 		NUMBER(3) NOT NULL,
		english			NUMBER(3) NOT NULL,
		general_mark    VARCHAR2(2000) NOT NULL
	);
	
CREATE TABLE Tech_mark
	(
		tech_mark_id 	NUMBER(6) NOT NULL PRIMARY KEY,
		interviewer_id	NUMBER(6) NOT NULL REFERENCES Users (user_id),
		form_id			NUMBER(6) NOT NULL REFERENCES Form (form_id),
		prog_lang 		NUMBER(3) NOT NULL,
		oop				NUMBER(3) NOT NULL,
		patterns		NUMBER(3) NOT NULL,
		db				NUMBER(3) NOT NULL,
		cs				NUMBER(3) NOT NULL,
		experience		NUMBER(3) NOT NULL,
		other			NUMBER(3) NOT NULL, 
		general_mark    VARCHAR2(2000) NOT NULL
	);

	
COMMIT;



INSERT INTO Users_type 
VALUES ( 1, 'Admin' );

INSERT INTO Users_type 
VALUES ( 2, 'HR' );

INSERT INTO Users_type 
VALUES ( 3, 'Interviewer' );

INSERT INTO Users_type 
VALUES ( 4, 'Candidate' );



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

INSERT INTO Form values
(1, 8, 'ОНПУ', 'ИКС', 4, 2013, 'double@gmail.com', '+380996661633',
 '', '+', '+', '+', '', '+', '+-', '+', '-', '', 4, 2, 'Python - 2; C# - 1',
 4, 4, 4, 2, 2, 3, 4, 1, 'RFID project', 3, 1, 1, 'преподаватели',
 'очень хочу получить опыт работы в компании NetCracker', 'без комментариев',
 0, 1, 0);
 INSERT INTO Form values
(2, 9, 'ОНУ им. Мечникова', 'Прикладная математика', 4, 2015, 'float@gmail.com', 
 '+380994473463', '', '-', '-', '+', '', '+', '-', '-', '-', '', 0, 4, 
 'С++ - 5; C# - 4', 2, 5, 4, 1,	1, 1, 2, 1, 'олимпиады', 3, 3, 3, 'Одесский форум',
 'просто люблю проходить собеседования', 'это комментарий', 0, 1, 0);
 INSERT INTO Form values
(3, 10, 'ОНПУ', 'ИКС', 4, 2013, 'int@gmail.com', '+3805735734',
 '', '+', '+', '+', '', '+', '+', '+', '+', '', 5, 2, 'PHP - 1',
 5, 5, 5, 5, 5, 5, 5, 5, 'Лабораторки в универе сама делала', 5, 5, 5, 'декан',
 'Сама не знаю', 'без комментариев', 0, 1, 0);

INSERT INTO Form VALUES
(
		4,
		11,
		'Одесский национальный политехнический университет',
		'Программная инженерия',
		4,
		'2010',
		'email@mail.ru',
		'0639825462',
		'0974865162',
		'+',
		'+',
		'+', 
		'администрирование БД',
		'-',
		'+',
		'+',
		'-',
		'нет',
		'4',
		'3',
		'C# - 5; JS - 3;',		
		'3',
		'2',
		'3',
		'4',
		'2',
		'4',
		'2',
		'4',
		'ну была курсовая по предмету на тему и какой-то студенческий проект',
		'3',
		'3',
		'1',
		'Прочитал на заборе',
		'Ну я очень умный, целеустремленный и жажду приключений',
		'Ходил на курсы вязания и программирования на android',
		0,
		1,
		0
);

INSERT INTO Form VALUES
(
		5,
		12,
		'Одесский национальный политехнический университет',
		'Программная инженерия',
		4,
		'2012',
		'email2000@mail.ru',
		'0523654556',
		'0523224556',
		'+',
		'+',
		'+', 
		'администрирование БД',
		'-',
		'+-',
		'+',
		'+-',
		'нет',
		'4',
		'3',
		'C# - 5; JS - 3;',		
		'5',
		'2',
		'3',
		'4',
		'2',
		'2',
		'2',
		'4',
		'сайт для интернет магазина',
		'1',
		'2',
		'1',
		'В интернете',
		'Пунктуален, энергичен, очень красив и обаятелен',
		'Ходил в универ на все пары',
		0,
		2,
		0
);

INSERT INTO HR_mark values
(1, 2, 1, 60, 55,'+1');
INSERT INTO HR_mark values
(2, 3, 2, 5, 65,'хорошо проявил себя');
INSERT INTO HR_mark values
(3, 2, 3, 90 ,100,'странный');
INSERT INTO HR_mark values
(4, 3, 4, 75, 75,'+100500');
INSERT INTO HR_mark values
(5, 2, 5, 70, 20,'хорош');

INSERT INTO Tech_mark values
(1, 4, 1, 80, 90, 75, 60, 90, 80, 25, 'Есть небольшой опыт и потенциал, нужно брать его в учебный центр');
INSERT INTO Tech_mark values
(2, 6, 2, 100, 80, 50, 50, 80, 20, 90, 'Есть потенциал, но нет инте в учебном центре');
INSERT INTO Tech_mark values
(3, 5, 3, 90, 90, 90, 90, 60, 10, 50, 'Опыта нет, теоретические знания есть, возьмем её в учебный центр');
INSERT INTO Tech_mark values
(4, 7, 4, 40, 30, 80, 75, 20, 80, 70, 'Теория слабая, но есть опыт в веб-программировании');
INSERT INTO Tech_mark values
(5, 4, 5, 10, 10, 10, 10, 10, 10, 0, 'aaa');



COMMIT;