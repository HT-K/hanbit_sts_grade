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

SELECT * FROM Admin WHERE id = 'admin' and password = '1';
