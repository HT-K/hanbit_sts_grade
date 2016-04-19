SELECT * FROM Admin;
CREATE TABLE Admin(
	id VARCHAR(30) PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	password VARCHAR(30) NOT NULL,
	addr VARCHAR(100),
	birth INT,
	role VARCHAR(30) DEFAULT 'admin'
);

INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES ('admin','관리자','1','서울',800101,'admin');
INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES ('prof_kim','김교수','1','인천',750101,'prof');
INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES ('prof_lee','이교수','1','수원',851201,'prof');
INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES ('prof_park','박교수','1','의정부',830801,'prof');

SELECT * FROM Admin WHERE id = 'admin' and password = '1';
SELECT * FROM Admin 
  	where id = 'admin' and password = '1'