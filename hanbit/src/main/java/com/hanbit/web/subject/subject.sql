DROP TABLE Subject;

CREATE TABLE Subject(
	subj_seq INT(4) PRIMARY KEY AUTO_INCREMENT,
	subj_name VARCHAR(30),
	prof_id VARCHAR(30)
	CONSTRAINT subj_admin_fk FOREIGN KEY prof_id
	REFERENCES Admin(id)
);
INSERT INTO Subject(subj_name,prof_id) VALUES('java','prof_kim');
INSERT INTO Subject(subj_name,prof_id) VALUES('jsp','prof_kim');
INSERT INTO Subject(subj_name,prof_id) VALUES('spring','prof_lee');
INSERT INTO Subject(subj_name,prof_id) VALUES('sql','prof_lee');
INSERT INTO Subject(subj_name,prof_id) VALUES('nodejs','prof_park');
INSERT INTO Subject(subj_name,prof_id) VALUES('python','prof_park');
INSERT INTO Subject(subj_name,prof_id) VALUES('android','prof_park');

UPDATE Subject SET prof_id = 'prof_kim'
WHERE subj_name = 'java' OR subj_name = 'jsp';
UPDATE Subject SET prof_id = 'prof_lee'
WHERE subj_name = 'spring' OR subj_name = 'sql';
UPDATE Subject SET prof_id = 'prof_park'
WHERE subj_name = 'nodejs' OR subj_name = 'python' OR subj_name = 'android';

SELECT 
	s.subj_seq AS subjSeq,
	s.subj_name AS subjName,
	s.prof_id AS profId,
	a.name AS profName
FROM Subject s, Admin a
WHERE s.prof_id = a.id;



SELECT * FROM Subject;


DROP TABLE Subject CASCADE ;

ALTER TABLE Subject ADD COLUMN prof_id VARCHAR(30);

ALTER TABLE Subject
ADD FOREIGN KEY (prof_id)
REFERENCES Admin(id);
