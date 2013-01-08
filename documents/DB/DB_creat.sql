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
		university			VARCHAR2(200),
		faculty 			VARCHAR2(200),
		course	 			NUMBER(1),
		end_year			VARCHAR2(5),
		email2				VARCHAR2(20),
		phone				VARCHAR2(20),
		another_contact		VARCHAR2(200),
		interest_tc: 		VARCHAR2(2) NOT NULL,
		interest_nc: 		VARCHAR2(2) NOT NULL,
		interest_area_po: 	VARCHAR2(2)	NOT NULL,
		interest_area_other: VARCHAR2(200) NOT NULL,
		job_ar_deep_spec: 	VARCHAR2(2) NOT NULL,
		job_ar_varied: 		VARCHAR2(2) NOT NULL,
		job_ar_manage: 		VARCHAR2(2) NOT NULL,
		job_ar_sales:		VARCHAR2(2) NOT NULL,
		job_ar_other: 		VARCHAR2(200) NOT NULL,
		prog_lang_c: 		NUMBER(1) NOT NULL,
		prog_lang_java:		NUMBER(1) NOT NULL,
		prog_lang_other: 	VARCHAR2(200) NOT NULL,
		cs_network_tech: 	NUMBER(1) NOT NULL,
		cs_algorithms: 		NUMBER(1) NOT NULL,
		cs_oop: 			NUMBER(1) NOT NULL,
		cs_gui: 			NUMBER(1) NOT NULL,
		cs_db: 				NUMBER(1) NOT NULL,
		cs_web: 			NUMBER(1) NOT NULL,
		cs_network_prog: 	NUMBER(1) NOT NULL,
		cs_desing: 			NUMBER(1) NOT NULL,
		experience			VARCHAR2(200),
		english_read: 		NUMBER(1) NOT NULL,
		english_write:		NUMBER(1) NOT NULL,
		english_spoken: 	NUMBER(1) NOT NULL,
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
		experience		NUMBER(3) NOT NULL,
		other			NUMBER(3) NOT NULL
	);

	
COMMIT;
