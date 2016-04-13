SELECT * FROM Id_sequence;
SELECT * FROM Article;
DROP TABLE Id_seqence;
DROP TABLE Article;

SHOW TABLES;

CREATE TABLE Article(
	article_id INT NOT NULL AUTO_INCREMENT,
	group_id INT NOT NULL,
	sequence_no CHAR(16) NOT NULL,
	posting_date DATETIME NOT NULL,
	read_count INT NOT NULL,
	writer_name VARCHAR(20) NOT NULL,
	password VARCHAR(10),
	title VARCHAR(100),
	content TEXT,
	PRIMARY KEY (article_id),
	INDEX(sequence_no)
);
SELECT COUNT(*) AS count
		FROM Article
SELECT article_id AS articleId,
			group_id AS groupId,
			sequence_no AS sequenceNo,
			posting_date AS postingDate,
			read_count AS readCount,
			writer_name AS writerName,
			password,
			title
		FROM Article 
			ORDER BY sequence_no 
			DESC LIMIT 1, 9
			
			
INSERT INTO Article
		(group_id,sequence_no,posting_date,read_count,
		writer_name,password,title,content)
		VALUES
		(1,'abcd',SYSDATE(),
		0,'김길동','1','테스트','테스트');			