DROP TABLE Users     	CASCADE CONSTRAINTS;
DROP TABLE Users_type   CASCADE CONSTRAINTS;

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


COMMIT;
