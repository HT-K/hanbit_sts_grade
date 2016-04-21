SELECT * FROM Member;

DROP TABLE Member CASCADE CONSTRAINT;
ALTER TABLE Member ADD COLUMN cate INT;
UPDATE Member SET cate = 1;
CREATE TABLE Member(
	id VARCHAR(30) PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	password VARCHAR(30) NOT NULL,
	addr VARCHAR(100),
	birth INT,
	cate INT,
	profile_img VARCHAR(100)
);
INSERT INTO Member(id,name,password,addr,birth,cate)
VALUES ('hong','홍길동','1','서울',800101,1);
INSERT INTO Member(id,name,password,addr,birth,cate)
VALUES ('kim','김유신','1','경기',900203,1);
INSERT INTO Member(id,name,password,addr,birth,cate)
VALUES ('lee','이순신','1','부산',000909,1);
INSERT INTO Member(id,name,password,addr,birth,cate)
VALUES ('song','송준기','1','대전',041001,1);
INSERT INTO Member(id,name,password,addr,birth,cate)
VALUES ('yoon','윤손하','1','인천',060201,1);
INSERT INTO Member(id,name,password,addr,birth,cate)
VALUES ('kim2','김유신','1','LA',850501,1);
INSERT INTO Member(id,name,password,addr,birth,cate)
VALUES ('you','유아인','1','강릉',920505,1);

UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'hong';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'kim';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'lee';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'song';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'yoon';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'kim2';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'security' WHERE id = 'jang2';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'security' WHERE id = 'jun';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'security' WHERE id = 'jang';

UPDATE Member SET profile_img = 'default_profile.PNG';
UPDATE Member SET profile_img = 'song.PNG'
WHERE id = 'song';
DELETE FROM Member WHERE id = 'choi';

SELECT * FROM Member;

SELECT * FROM Member
WHERE id = 'song';

SELECT * FROM Member
WHERE id = 'kim' and password = '1';

-- DDL 테이블 수정

-- 1. 컬럼 추가
ALTER TABLE Member ADD subject varchar(100); -- java/sql/spring
ALTER TABLE Member ADD major varchar(20); -- java/sql/spring
ALTER TABLE Member ADD profile_img varchar(100); -- 프로필 사진 

-- 2. 컬럼 수정(이름)
ALTER TABLE Member RENAME COLUMN password TO pass; 
-- 3. 컬럼 수정(타입)
ALTER TABLE Menber MODIFY birth DATE;















