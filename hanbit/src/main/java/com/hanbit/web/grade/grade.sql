SELECT * FROM Grade;

DROP TABLE Grade CASCADE ;

SELECT * FROM Grade;

SELECT * FROM Grade
WHERE score IS NOT NULL;

CREATE TABLE Grade(
	score_seq  int PRIMARY KEY AUTO_INCREMENT,
	id  VARCHAR(30),
	subj_seq int,
	score int,
	exam_date VARCHAR(15),
	CONSTRAINT grade_member_fk FOREIGN KEY(id) 
	REFERENCES Member(id) ON DELETE CASCADE,
	CONSTRAINT grade_subject_fk FOREIGN KEY(subj_seq) 
	REFERENCES Subject(subj_seq) ON DELETE CASCADE
);

ALTER TABLE Grade ADD COLUMN exam_date VARCHAR(15);

DELETE FROM Grade
WHERE score_seq = 13;

-- 홍길동 3월시험
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'hong',1,80,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'hong',2,90,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'hong',3,100,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'hong',4,50,'2016-03-31');
-- 김유신 3월시험 
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'kim',1,50,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'kim',2,50,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'kim',3,50,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'kim',4,50,'2016-03-31');

-- 이순신 3월시험 
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'lee',1,90,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'lee',2,90,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'lee',3,90,'2016-03-31');
INSERT INTO Grade(score_seq,id,subj_seq,score,exam_date)
VALUES (score_seq,'lee',4,90,'2016-03-31');

UPDATE Grade SET exam_date='2016-03-31';

SELECT * FROM Grade
WHERE id = 'song';