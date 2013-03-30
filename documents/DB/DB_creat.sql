DROP TABLE Users     	CASCADE CONSTRAINTS;
DROP TABLE Users_type   CASCADE CONSTRAINTS;
DROP TABLE HR_mark		CASCADE CONSTRAINTS;
DROP TABLE Tech_mark	CASCADE CONSTRAINTS;
DROP TABLE Interview	CASCADE CONSTRAINTS;
DROP TABLE Form			CASCADE CONSTRAINTS;
DROP TABLE News			CASCADE CONSTRAINTS;
DROP TABLE Universities	CASCADE CONSTRAINTS;
DROP TABLE Faculties	CASCADE CONSTRAINTS;
DROP TABLE Sources		CASCADE CONSTRAINTS;

CREATE TABLE Users_type
    ( 
		user_type_id    NUMBER(3) NOT NULL PRIMARY KEY,
		type_name    	VARCHAR2(2000) NOT NULL
    );

CREATE TABLE Sources
    ( 
		source_id   	NUMBER(3) NOT NULL PRIMARY KEY,
		source_name  	VARCHAR2(2000) NOT NULL 
    );
	
CREATE TABLE Universities
    ( 
		university_id   	NUMBER(3) NOT NULL PRIMARY KEY,
		university_name  	VARCHAR2(2000) NOT NULL
    );

CREATE TABLE Faculties
    ( 
		faculty_id   	NUMBER(3) NOT NULL PRIMARY KEY,
		faculty_name  	VARCHAR2(2000) NOT NULL,
		university_id	NUMBER(3) REFERENCES Universities (university_id) ON DELETE  SET NULL
    );	
	
CREATE TABLE Users
    ( 
		user_id    		NUMBER(6) NOT NULL PRIMARY KEY,
		email   		VARCHAR2(30) NOT NULL CONSTRAINT email 
		CHECK (REGEXP_LIKE(email,'^([a-zA-Z0-9_\.\-]{1,20})@([a-zA-Z0-9\.\-]{1,20})\.([a-z]{2,4})$')),
		password 		VARCHAR2(20) NOT NULL,
		first_name  	VARCHAR2(100) NOT NULL CONSTRAINT first_name
		CHECK (first_name = INITCAP(first_name) AND REGEXP_LIKE(first_name,'[a-zA-Zа-яА-Я]{1,40}$')),
		surname			VARCHAR2(100) NOT NULL CONSTRAINT surname
		CHECK (surname = INITCAP(surname) AND REGEXP_LIKE(surname,'[a-zA-Zа-яА-Я]{1,40}$')),
		last_name		VARCHAR2(100) NOT NULL CONSTRAINT last_name
		CHECK (last_name = INITCAP(last_name) AND REGEXP_LIKE(last_name,'[a-zA-Zа-яА-Я]{1,40}$')),
		foto			VARCHAR2(80),
		user_type_id	NUMBER(6) REFERENCES Users_type (user_type_id) ON DELETE CASCADE,
		reg_date		DATE
    );
		
CREATE TABLE Interview
	(
		interview_id	NUMBER(6) NOT NULL PRIMARY KEY,
		start_date		DATE NOT NULL,
		end_date		DATE NOT NULL,
		extra_time		NUMBER(3) NOT NULL,
		seats	 		NUMBER(3) NOT NULL
	);
	
CREATE TABLE Form
	(
		form_id		 		NUMBER(6) NOT NULL PRIMARY KEY,
		user_id				NUMBER(6) NOT NULL REFERENCES Users (user_id) ON DELETE CASCADE,
		university_id		NUMBER(3) REFERENCES Universities (university_id) ON DELETE  SET NULL,
		faculty_id 			NUMBER(3) REFERENCES Faculties (faculty_id) ON DELETE  SET NULL,
		course	 			NUMBER(1),
		end_year			VARCHAR2(5),
		email2				VARCHAR2(30) CONSTRAINT email2 
		CHECK (REGEXP_LIKE(email2,'^([a-zA-Z0-9_\.\-]{1,20})@([a-zA-Z0-9\.\-]{1,20})\.([a-z]{2,4})$')),
		phone				VARCHAR2(13) CONSTRAINT phone
		CHECK (REGEXP_LIKE(phone,'[\+0-9]{7,13}')),
		another_contact		VARCHAR2(400),
		interest_tc 		VARCHAR2(2) NOT NULL CONSTRAINT interest_tc
		CHECK (interest_tc in('+','+-','-','?')),
		interest_nc 		VARCHAR2(2) NOT NULL CONSTRAINT interest_nc
		CHECK (interest_nc in('+','+-','-','?')),
		interest_area_po 	VARCHAR2(2)	NOT NULL CONSTRAINT interest_area_po
		CHECK (interest_area_po in('+','+-','-','?')),
		interest_area_other VARCHAR2(800),
		job_ar_deep_spec 	VARCHAR2(2) NOT NULL CONSTRAINT job_ar_deep_spec
		CHECK (job_ar_deep_spec in('+','+-','-','?')),
		job_ar_varied 		VARCHAR2(2) NOT NULL CONSTRAINT job_ar_varied
		CHECK (job_ar_varied in('+','+-','-','?')),
		job_ar_manage 		VARCHAR2(2) NOT NULL  CONSTRAINT job_ar_manage
		CHECK (job_ar_manage in('+','+-','-','?')),
		job_ar_sales		VARCHAR2(2) NOT NULL  CONSTRAINT job_ar_sales
		CHECK (job_ar_sales in('+','+-','-','?')),
		job_ar_other 		VARCHAR2(800),
		prog_lang_c 		NUMBER(1) NOT NULL CONSTRAINT prog_lang_c
		CHECK (prog_lang_c between 0 and 5),
		prog_lang_java		NUMBER(1) NOT NULL CONSTRAINT prog_lang_java
		CHECK (prog_lang_java between 0 and 5),
		prog_lang_other 	VARCHAR2(800),
		prog_lang_other_mark NUMBER(1) NOT NULL CONSTRAINT prog_lang_other_mark
		CHECK (prog_lang_other_mark between 0 and 5),
		cs_network_tech 	NUMBER(1) NOT NULL CONSTRAINT cs_network_tech
		CHECK (cs_network_tech between 0 and 5),
		cs_algorithms 		NUMBER(1) NOT NULL CONSTRAINT cs_algorithms
		CHECK (cs_algorithms between 0 and 5),
		cs_oop	 			NUMBER(1) NOT NULL CONSTRAINT cs_oop
		CHECK (cs_oop between 0 and 5),
		cs_gui 				NUMBER(1) NOT NULL CONSTRAINT cs_gui
		CHECK (cs_gui between 0 and 5),
		cs_db 				NUMBER(1) NOT NULL CONSTRAINT cs_db
		CHECK (cs_db between 0 and 5),
		cs_web 				NUMBER(1) NOT NULL CONSTRAINT cs_web
		CHECK (cs_web between 0 and 5),
		cs_network_prog 	NUMBER(1) NOT NULL CONSTRAINT cs_network_prog
		CHECK (cs_network_prog between 0 and 5),
		cs_design 			NUMBER(1) NOT NULL CONSTRAINT cs_design
		CHECK (cs_design between 0 and 5),
		cs_other 	VARCHAR2(800),
		cs_other_mark 		NUMBER(1) NOT NULL CONSTRAINT cs_other_mark
		CHECK (cs_other_mark between 0 and 5),
		experience			VARCHAR2(4000),
		english_read 		NUMBER(1) NOT NULL CONSTRAINT english_read
		CHECK (english_read between 0 and 5),
		english_write		NUMBER(1) NOT NULL CONSTRAINT english_write
		CHECK (english_write between 0 and 5),
		english_spoken	 	NUMBER(1) NOT NULL CONSTRAINT english_spoken
		CHECK (english_spoken between 0 and 5),
		source_id			NUMBER(3) NOT NULL  REFERENCES Sources (source_id) ON DELETE  SET NULL,
		motivation_comment	VARCHAR2(2000) NOT NULL,
		comment2			VARCHAR2(2000) NOT NULL,
		status	 			NUMBER(1) NOT NULL,
		interview_id		NUMBER(6) REFERENCES Interview (interview_id) ON DELETE  SET NULL,
		visit_status		NUMBER(1)
	);
	
	
	
CREATE TABLE HR_mark
	(
		hr_mark_id 		NUMBER(6) NOT NULL PRIMARY KEY,
		user_id			NUMBER(6) NOT NULL REFERENCES Users (user_id) ON DELETE  SET NULL,
		form_id			NUMBER(6) NOT NULL REFERENCES Form (form_id),
		motivation 		NUMBER(3) NOT NULL,
		english			NUMBER(3) NOT NULL,
		general_mark    VARCHAR2(2000) NOT NULL
	);
	
CREATE TABLE Tech_mark
	(
		tech_mark_id 	NUMBER(6) NOT NULL PRIMARY KEY,
		user_id			NUMBER(6) NOT NULL REFERENCES Users (user_id) ON DELETE  SET NULL,
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
		
	ALTER TABLE Users 
	ADD CONSTRAINT password
	CHECK(REGEXP_LIKE(password,'[a-zA-Z0-9_\.]{4,16}$'));
	
CREATE TABLE News
	(
		news_id 		NUMBER(3) NOT NULL PRIMARY KEY,
		text		    CLOB NOT NULL
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


INSERT INTO Sources 
VALUES ( 1, 'Увидел рекламу' );

INSERT INTO Sources 
VALUES ( 2, 'Узнал от друга' );

INSERT INTO Sources 
VALUES ( 3, 'Нашел в интернете' );

INSERT INTO Sources 
VALUES ( 4, 'Другое' );


INSERT INTO Universities 
VALUES ( 1, 'ОНПУ' );

INSERT INTO Universities 
VALUES ( 2, 'ОНУ им. Мечникова' );

INSERT INTO Universities 
VALUES ( 3, 'Другое' );


INSERT INTO Faculties 
VALUES ( 1, 'ИКС', 1 );

INSERT INTO Faculties 
VALUES ( 2, 'Программная инженерия', 1 );

INSERT INTO Faculties 
VALUES ( 3, 'Другой', 1);

INSERT INTO Faculties 
VALUES ( 4, 'Прикладная математика', 2);

INSERT INTO Faculties 
VALUES ( 5, 'Другой', 2);


INSERT INTO Users 
VALUES 
( 
	1, 
	'adm@mail.ru',
	'1111',
	'Администратор',
	'Админов',
	'Админович',
	null,
	1,
	to_date('2013/04/03 16:00:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	2, 
	'hr1@mail.ru',
	'hr31',
	'Егор',
	'Тюленев',
	'Афанасьевич',
	null,
	2,
	to_date('2013/04/03 17:00:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	3, 
	'hr2@ukr.net',
	'hrd2',
	'Герасим',
	'Ламантинов',
	'Макарович',
	null,
	2,
	to_date('2013/04/03 17:30:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	4, 
	'inter1@nm.ru',
	'idf1',
	'Лилия',
	'Моржёва',
	'Радионовна',
	null,
	3,
	to_date('2013/04/04 17:30:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	5, 
	'inter2@pop3.ru',
	'isf2',
	'Диана',
	'Коровьева',
	'Алексеевна',
	null,
	3,
	to_date('2013/04/04 15:30:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	6, 
	'inter3@mail.ru',
	'ibg3',
	'Светлана',
	'Крыжовникова',
	'Ренатовна',
	null,
	3,
	to_date('2013/04/04 16:30:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	7, 
	'inter4@mail.ru',
	'ity4',
	'Радослав',
	'Бананов',
	'Маркович',
	null,
	3,
	to_date('2013/04/04 17:38:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	8, 
	'user1@prolife.net',
	'user1',
	'Еремей',
	'Гвоздёв',
	'Матвеевич',
	null,
	4,
	to_date('2013/04/05 17:38:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	9, 
	'user2@rambler.ru',
	'user2',
	'Марфа',
	'Кременчикова',
	'Станиславовна',
	null,
	4,
	to_date('2013/04/05 21:38:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	10, 
	'user3@remixer.com',
	'user3',
	'Афанасий',
	'Бредов',
	'Степанович',
	null,
	4,
	to_date('2013/04/06 11:23:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	11, 
	'user4@saintly.com',
	'user4',
	'Стелла',
	'Манкова',
	'Гавриловна',
	null,
	4,
	to_date('2013/04/06 12:38:00', 'yyyy/mm/dd hh24:mi:ss')
);

INSERT INTO Users 
VALUES 
( 
	12, 
	'user5@mail.ru',
	'user5',
	'Игнатий',
	'Мотросов',
	'Фомович',
	null,
	4,
	to_date('2013/04/06 14:14:00', 'yyyy/mm/dd hh24:mi:ss')
);


INSERT INTO Interview VALUES(
		1,
		to_date('2013/05/03 16:00:00', 'yyyy/mm/dd hh24:mi:ss'),
		to_date('2013/05/03 18:00:00', 'yyyy/mm/dd hh24:mi:ss'),
		30,
		4
);

INSERT INTO Interview VALUES(
		2,
		to_date('2013/05/03 18:30:00', 'yyyy/mm/dd hh24:mi:ss'),
		to_date('2013/05/03 20:30:00', 'yyyy/mm/dd hh24:mi:ss'),
		30,
		4
);

INSERT INTO Form values
(1, 8, 1, 1, 4, 2013, 'double@gmail.com', '+380996661633',
 '', '+', '+', '+', '', '+', '+-', '+', '-', '', 4, 2, 'Python', 3,
 4, 4, 4, 2, 2, 3, 4, 1, 'Криптография', 4, 'RFID project', 3, 1, 1, 1,
 'очень хочу получить опыт работы в компании NetCracker', 'без комментариев',
 0, 1, 0);
 INSERT INTO Form values
(2, 9, 2, 4, 4, 2015, 'float@gmail.com', 
 '+380994473463', '', '-', '-', '+', '', '+', '-', '-', '-', '', 0, 4, 
 'C#', 4, 2, 5, 4, 1, 1, 1, 2, 1, 'Физика', 5,'олимпиады', 3, 3, 3, 3,
 'просто люблю проходить собеседования', 'это комментарий', 0, 1, 0);
 INSERT INTO Form values
(3, 10, 1, 1, 4, 2013, 'int@gmail.com', '+380573573488',
 '', '+', '+', '+', '', '+', '+', '+', '+', '', 5, 2, 'PHP', 1,
 5, 5, 5, 5, 5, 5, 5, 5, 'Android', 2, 'Лабораторки в универе сама делала', 5, 5, 5, 2,
 'Сама не знаю', 'без комментариев', 0, 1, 0);

INSERT INTO Form VALUES
(
		4,
		11,
		1,
		2,
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
		4,
		3,
		'JS', 
		3,		
		3,
		2,
		3,
		4,
		2,
		4,
		2,
		4, 'iOS', 4,
		'ну была курсовая по предмету на тему и какой-то студенческий проект',
		3,
		3,
		1,
		2,
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
		1,
		2,
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
		4,
		3,
		'JS', 
		3,		
		5,
		2,
		3,
		4,
		2,
		2,
		2,
		4, 'Linux', 3,
		'сайт для интернет магазина',
		1,
		2,
		1,
		4,
		'Пунктуален, энергичен, очень красив и обаятелен',
		'Ходил в универ на все пары',
		0,
		2,
		0
);

INSERT INTO HR_mark values
(1, 2, 1, 60, 55,'+1');
INSERT INTO HR_mark values
(2, 3, 2, 5, 65,'Хорошо проявил Себя');
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

INSERT INTO News 
VALUES ( 1, '<h3>О компании</h3><p>Компания NetCracker является мировым лидером в области создания и внедрения решений по управлению телекоммуникационными операциями. Основу успешных трансформационных решений NetCracker составляет обширное продуктовое и сервисное портфолио, которое включает управление взаимоотношениями с клиентами, управление продуктами, доходами и устройствами, предоставление и обеспечение качества услуг, IT-платформы, управление ресурсами и сетями. NetCracker является дочерней компанией корпорации NEC.</p>' );

INSERT INTO News 
VALUES ( 2, '<h3>Контакты</h3><p>По всем вопросам, касающихся учебного центра, обращайтесь, пожалуйста, в HR отдел:</p><p>+38 048 740 69 96  ext. 6402</p><a href="mailto:hr.odessa@netcracker.com">hr.odessa@netcracker.com</a>' );

INSERT INTO News 
VALUES ( 3, 'Текст новости 3' );

INSERT INTO News 
VALUES ( 4, '<h3>Про учебный центр</h3>
<p>При сотрудничестве с Одесским Национальным Политехническим Университетом в марте 2011 года NetCracker открыла научно-учебный центр (НУЦ) в Одессе. Он стал третьим учебным центром компании в Украине.
Программа обучения направлена на подготовку высококвалифицированных инженеров в области разработки, внедрения и сопровождения систем OSS / BSS.</p>
<h3>Набор и условия обучения</h3>
<p>Приглашаем в учебный центр студентов технических специальностей всех ВУЗов Одессы.
Обучение бесплатное. Продолжительность - неполный учебный год: с октября по май, с перерывами на период сессии и каникул. Занятия проходят в вечернее время 3-4 раза в неделю, расписание согласовывается со слушателями.
Зачисление производится по результатам личного собеседования, которую проводят сотрудники компании.</p>
<h3>Программа</h3>
<p>Лекции и практические занятия проводятся по следующим направлениям:</p>
<li>объектно-ориентированное программирование на Java
<li>проектирования реляционных баз данных в Oracle
<li>разработка на JavaEE, технологии построения распределенных систем
<p>Кроме преподавателей, со студентами в течение года работают кураторы - сотрудники компании NetCracker. Во время сотрудничества с кураторами студенты реализуют реальный мини-проект: от этапа анализа к разработке и запуску. Результаты работ защищаются перед сотрудниками компании.</p>
<h3>Трудоустройство</h3>
<p>Успешные студенты по результатам обучения и защиты проектов приглашаются на работу в компанию NetCracker. Студенты получают возможность гармонично сочетать работу и учебу, работая парт-тайм от 20 часов в неделю.
Мы предлагаем официальное трудоустройство, белую зарплату, тренинги, курсы английского языка, профессиональный и карьерный рост.
Выпускники НУЦ успешно работают в компании разработчиками в проектных командах, осуществляющих внедрение OSS / BSS решений телекоммуникационным компаниям со всего мира.');
COMMIT;