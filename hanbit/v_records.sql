CREATE OR REPLACE VIEW Record
AS
SELECT 
	g.score_seq AS seq,
	g.id  		AS id,
	m.name 		AS name,
	s.subj_name	AS subject,
	g.score		AS score,
	g.exam_date	AS examDate
FROM
	Member m, Grade g, Subject s
WHERE
	m.id = g.id	AND g.subj_seq = s.subj_seq;

	
CREATE OR REPLACE VIEW `Record_Java`
AS 
SELECT
	seq,
	id,
	name,
	subject AS 'java',
	score,
	examDate
FROM
	Record
WHERE
	subject = 'java';
	
	
CREATE OR REPLACE VIEW `Record_JSP`
AS 
SELECT
	seq,
	id,
	name,
	subject AS 'jsp',
	score,
	examDate
FROM
	Record
WHERE
	subject = 'jsp';

CREATE OR REPLACE VIEW `Record_Spring`
AS 
SELECT
	seq,
	id,
	name,
	subject AS 'spring',
	score,
	examDate
FROM
	Record
WHERE
	subject = 'spring';

CREATE OR REPLACE VIEW `Record_SQL`
AS 
SELECT
	seq,
	id,
	name,
	subject AS 'sql',
	score,
	examDate
FROM
	Record
WHERE
	subject = 'sql';

	

	
	
	
	
CREATE OR REPLACE VIEW RECORD_SCORES
AS
SELECT 
	ja.seq,
	ja.id,
	ja.score AS 'java',
 	js.score AS 'jsp',
  sp.score AS 'spring',
  sq.score AS 'sql',
	ja.examDate
FROM
	Record_JAVA ja
  LEFT JOIN Record_JSP js
       ON ja.id = js.id
  LEFT JOIN Record_SPRING sp 
       ON js.id = sp.id
  LEFT JOIN Record_SQL sq 
       ON sp.id = sq.id
