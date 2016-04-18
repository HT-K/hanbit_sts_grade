SELECT * FROM Grade;

DROP TABLE Grade CASCADE ;

SELECT * FROM Grade;

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


INSERT INTO Grade(score_seq,id,subj_seq,score)
VALUES (score_seq,'hong',1,80);
INSERT INTO Grade(score_seq,id,subj_seq,score)
VALUES (score_seq,'hong',2,90);
INSERT INTO Grade(score_seq,id,subj_seq,score)
VALUES (score_seq,'hong',3,100);
INSERT INTO Grade(score_seq,id,subj_seq,score)
VALUES (score_seq,'hong',4,50);

UPDATE Grade SET exam_date='2016-03-31';

SELECT * FROM Grade
WHERE id = 'song';