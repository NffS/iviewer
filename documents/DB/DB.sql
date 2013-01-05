DROP TABLE Users     	CASCADE CONSTRAINTS;
DROP TABLE Users_type   CASCADE CONSTRAINTS;
DROP TABLE HR_mark;
DROP TABLE Tech_mark;
DROP TABLE Interview;

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

CREATE TABLE HR_mark
	(
		hr_mark_id 		NUMBER(6) NOT NULL PRIMARY KEY,
		hr_id			NUMBER(6) NOT NULL REFERENCES Users (user_id),
		form_id			NUMBER(6) NOT NULL REFERENCES Form (form_id),
		motivation 		NUMBER(3) NOT NULL,
		english			NUMBER(3) NOT NULL
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
		exp				NUMBER(3) NOT NULL,
		other			NUMBER(3) NOT NULL
	);

CREATE TABLE Interview
	(
		interview_id	NUMBER(6) NOT NULL PRIMARY KEY,
		start_date		DATE NOT NULL,
		end_date		DATE NOT NULL,
		seats	 		NUMBER(3) NOT NULL
	);
	
COMMIT;
