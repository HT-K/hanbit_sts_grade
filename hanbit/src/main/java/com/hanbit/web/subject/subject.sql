DROP TABLE Subject;

CREATE TABLE Subject(
	subj_seq INT(4) PRIMARY KEY AUTO_INCREMENT,
	subj_name VARCHAR(30)
);
INSERT INTO Subject(subj_name) VALUES('java');
INSERT INTO Subject(subj_name) VALUES('jsp');
INSERT INTO Subject(subj_name) VALUES('spring');
INSERT INTO Subject(subj_name) VALUES('sql');


SELECT * FROM Subject;

SELECT * FROM Subject;

DROP TABLE Subject CASCADE ;

