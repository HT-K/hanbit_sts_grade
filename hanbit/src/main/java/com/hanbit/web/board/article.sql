SELECT * FROM Id_sequence;
SELECT * FROM Article;
DROP TABLE Id_seqence;
CREATE TABLE Id_sequence(
	sequence_name VARCHAR(10) NOT NULL,
	next_value INT NOT NULL,
	PRIMARY KEY (sequence_name)
);
INSERT INTO Id_sequence VALUES ('article',0);

CREATE TABLE Article(
	article_id INT NOT NULL AUTO_INCREMENT,
	group_id INT NOT NULL,
	sequence_no CHAR(16) NOT NULL,
	posting_date DATETIME NOT NULL,
	read_count INT NOT NULL,
	write_name VARCHAR(20) NOT NULL,
	password VARCHAR(10),
	title VARCHAR(100),
	content TEXT,
	PRIMARY KEY (article_id),
	INDEX(sequence_no)
);

