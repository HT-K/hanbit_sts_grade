DROP VIEW Record CASCADE;

SELECT * FROM Record;

CREATE OR REPLACE VIEW Record
AS
SELECT 
	g.score_seq AS seq, -- int
	g.id  AS id, -- varchar
	m.name AS name, -- varchar
	s.subj_name AS subject, -- varchar
	g.score AS score, -- int
	g.exam_date AS examDate -- varchar
FROM Member m, Grade g, Subject s
WHERE m.id = g.id AND g.subj_seq = s.subj_seq; 

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




