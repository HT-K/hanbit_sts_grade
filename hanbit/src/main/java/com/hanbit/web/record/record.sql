DROP VIEW Record CASCADE;

SELECT * FROM Record;

SELECT * FROM Record
WHERE id = 'kim' AND exam_date = '2016-03-31'


CREATE OR REPLACE VIEW Record
AS
SELECT 
	g.score_seq AS seq, -- int
	g.id  AS id, -- varchar
	m.name AS name, -- varchar
	s.subj_name AS subject, -- varchar
	g.score AS score, -- int
	g.exam_date AS exam_date -- varchar
FROM Member m, Grade g, Subject s
WHERE m.id = g.id AND s.subj_seq = g.subj_seq 



-- GROUP BY & HAVING 예제

SELECT 
	g.score_seq AS seq, -- int
	g.id  AS id, -- varchar
	m.name AS name, -- varchar
	s.subj_name AS subject, -- varchar
	g.score AS score, -- int
	g.exam_date AS exam_date -- varchar
FROM Member m, Grade g, Subject s
WHERE m.id = g.id AND m.id = 'kim' AND s.subj_seq = g.subj_seq 
AND g.exam_date='2016-03-31'
GROUP BY s.subj_name 
HAVING score IS NOT NULL


-- ANSI JOIN(Natural JOIN)

SELECT 
	g.score_seq AS seq,
	g.id  AS id,
	m.name AS name,
	g.score AS score
FROM Member m NATURAL JOIN Grade g NATURAL JOIN Subject s;

-- ANSI JOIN(USING)
SELECT 
	g.score_seq AS seq,
	g.id  AS id,
	m.name AS name,
	g.score AS score
FROM Member m JOIN Grade g 
USING (id)

----------------------

SELECT * FROM GradeMember;

SELECT * FROM GradeMember
WHERE id = 'hong';


SELECT * FROM GradeMember WHERE hak = '20160001'


SELECT COUNT(*) AS count
FROM GradeMember;

SELECT COUNT(*) FROM  GradeMember;

DELETE FROM GradeMember 
WHERE score_seq = 20160001;




