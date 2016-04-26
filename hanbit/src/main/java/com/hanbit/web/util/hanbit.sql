-- Host: localhost  (Version 5.7.11-log)
-- Date: 2016-04-26 14:10:08
-- Generator: MySQL-Front 5.3  (Build 5.31)
--
-- Structure for table "member"
--

CREATE TABLE `member` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `birth` decimal(10,0) DEFAULT NULL,
  `cate` decimal(10,0) DEFAULT NULL,
  `profile_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data for table "member"
--

INSERT INTO `member` VALUES ('hong','홍길동','1','춘천',800101,1,'Penguins.jpg'),('hye','송혜교','1','우르크',851201,1,'default_profile.PNG'),('kim','김유신','1','경기',900203,1,'default_profile.PNG'),('kim2','김유신','1','LA',850501,1,'default_profile.PNG'),('kim3','김삼','1','서울',900101,1,'default_profile.png'),('kim5','김오','1','서울',900101,1,'default_profile.png'),('kim6','김육','1','서울',900101,1,'default_profile.png'),('lee','이순신','1','부산',909,1,'default_profile.PNG'),('seo','seo','1','서울',900101,1,'default_profile.png'),('song','송준기','1','대전',41001,1,'Koala.jpg'),('tea','선생','1','서울',80101,2,'default_profile.PNG'),('test10','test10','1','서울',20000101,1,'default_profile.png'),('test11','test11','1','서울',20000101,1,'default_profile.png'),('test12','test12','1','서울',20000101,1,'default_profile.png'),('test13','test13','1','서울',20000101,1,'default_profile.png'),('test15','test15','1','서울',20000101,1,'default_profile.png'),('test16','test16','1','서울',20000101,1,'default_profile.png'),('test17','test17','1','서울',20000101,1,'default_profile.png'),('test18','test','1','서울',20000101,1,'default_profile.png'),('test19','test','1','서울',20000101,1,'default_profile.png'),('test21','test','1','서울',20000101,1,'default_profile.png'),('yoon','윤손하','1','인천',60201,1,'default_profile.PNG'),('you','유아인','1','강릉',920505,1,'default_profile.PNG');

-- Host: localhost  (Version 5.7.11-log)
-- Date: 2016-04-26 14:09:13
-- Generator: MySQL-Front 5.3  (Build 5.31)

--
-- Structure for table "admin"
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `birth` int(11) DEFAULT NULL,
  `role` varchar(30) DEFAULT 'admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data for table "admin"
--

INSERT INTO `admin` VALUES ('admin','관리자','1','서울',800101,'admin'),('prof_kim','김교수','1','인천',750101,'prof'),('prof_lee','이교수','1','수원',851201,'prof'),('prof_park','박교수','1','의정부',830801,'prof');

-- Host: localhost  (Version 5.7.11-log)
-- Date: 2016-04-26 14:10:37
-- Generator: MySQL-Front 5.3  (Build 5.31)

--
-- Structure for table "subject"
--

CREATE TABLE `subject` (
  `subj_seq` int(4) NOT NULL AUTO_INCREMENT,
  `subj_name` varchar(30) DEFAULT NULL,
  `prof_id` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`subj_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Data for table "subject"
--

INSERT INTO `subject` VALUES (1,'java','prof_kim'),(2,'jsp','prof_kim'),(3,'spring','prof_lee'),(4,'sql','prof_lee'),(5,'nodejs','prof_park'),(6,'python','prof_park'),(7,'android','prof_park');


-- Host: localhost  (Version 5.7.11-log)
-- Date: 2016-04-26 14:09:47
-- Generator: MySQL-Front 5.3  (Build 5.31)

--
-- Structure for table "grade"
--

CREATE TABLE `grade` (
  `score_seq` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(30) DEFAULT NULL,
  `subj_seq` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `exam_date` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`score_seq`),
  KEY `grade_member_fk` (`id`),
  KEY `grade_subject_fk` (`subj_seq`),
  CONSTRAINT `grade_member_fk` FOREIGN KEY (`id`) REFERENCES `member` (`id`),
  CONSTRAINT `grade_subject_fk` FOREIGN KEY (`subj_seq`) REFERENCES `subject` (`subj_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Data for table "grade"
--

INSERT INTO `grade` VALUES (1,'hong',1,80,'2016-03-31'),(2,'hong',2,90,'2016-03-31'),(3,'hong',3,100,'2016-03-31'),(4,'hong',4,50,'2016-03-31'),(5,'kim',1,60,'2016-03-31'),(6,'kim',2,50,'2016-03-31'),(7,'kim',3,50,'2016-03-31'),(8,'kim',4,50,'2016-03-31'),(9,'lee',1,90,'2016-03-31'),(10,'lee',2,90,'2016-03-31'),(11,'lee',3,90,'2016-03-31'),(12,'lee',4,90,'2016-03-31'),(14,'hye',2,80,'2016-04-30'),(15,'hye',3,80,'2016-04-30'),(16,'hye',4,80,'2016-04-30'),(17,'hye',1,80,'2016-04-30');

-- Host: localhost  (Version 5.7.11-log)
-- Date: 2016-04-26 14:10:18
-- Generator: MySQL-Front 5.3  (Build 5.31)

--
-- Structure for table "record"
--

CREATE VIEW `record` AS 
  select `g`.`score_seq` AS `seq`,`g`.`id` AS `id`,`m`.`name` AS `name`,`s`.`subj_name` AS `subject`,`g`.`score` AS `score`,`g`.`exam_date` AS `exam_date`,`s`.`prof_id` AS `prof_id`,`a`.`name` AS `prof_name` from (((`member` `m` join `grade` `g`) join `subject` `s`) join `admin` `a`) where ((`m`.`id` = `g`.`id`) and (`s`.`subj_seq` = `g`.`subj_seq`) and (`s`.`prof_id` = `a`.`id`));

-- Host: localhost  (Version 5.7.11-log)
-- Date: 2016-04-26 14:09:28
-- Generator: MySQL-Front 5.3  (Build 5.31)

--
-- Structure for table "article"
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `sequence_no` char(16) NOT NULL,
  `posting_date` datetime NOT NULL,
  `read_count` int(11) NOT NULL,
  `writer_name` varchar(20) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`article_id`),
  KEY `sequence_no` (`sequence_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Data for table "article"
--

INSERT INTO `article` VALUES (1,1,'abcd','2016-04-14 16:50:03',0,'김길동','1','테스트','기본형4:50'),(2,1,'abcd','2016-04-12 15:20:06',0,'테스터1','1','테스트1','테스트 글입니다'),(4,1,'abcd','2016-04-14 17:17:01',0,'홍길동','1','삭제할 글','삭제할 글입니다'),(5,1,'abcd','2016-04-22 12:06:25',0,'이길동','1','테스트','테스트'),(6,1,'abcd','2016-04-22 12:06:26',0,'일길동','1','테스트','테스트'),(7,1,'abcd','2016-04-22 12:06:27',0,'삼길동','1','테스트','테스트'),(8,1,'abcd','2016-04-22 12:13:23',0,'사길동','1','테스트','테스트');

-- Host: localhost  (Version 5.7.11-log)
-- Date: 2016-04-26 14:10:27
-- Generator: MySQL-Front 5.3  (Build 5.31)

--
-- Structure for table "reply"
--

CREATE TABLE `reply` (
  `reply_seq` int(11) NOT NULL AUTO_INCREMENT,
  `reply` varchar(1000) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `writer_name` varchar(30) DEFAULT NULL,
  `reg_time` date DEFAULT NULL,
  PRIMARY KEY (`reply_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Data for table "reply"
--

INSERT INTO `reply` VALUES (1,'댓글테스트1',8,'댓글남','2016-04-25'),(2,'댓글테스트2',8,'댓글남','2016-04-25'),(3,'댓글테스트3',8,'댓글남','2016-04-25');


-- Host: localhost  (Version 5.7.11-log)
-- Date: 2016-04-26 14:10:51
-- Generator: MySQL-Front 5.3  (Build 5.31)

--
-- Structure for table "test"
--

CREATE TABLE `test` (
  `sample` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Data for table "test"
--

INSERT INTO `test` VALUES ('홍길동');


-- AWS : RDS 에 들어간 테이블 명 바꾸기

ALTER TABLE member RENAME TO Member;
ALTER TABLE admin RENAME TO Admin;
ALTER TABLE subject RENAME TO Subject;
ALTER TABLE grade RENAME TO Grade;
ALTER TABLE article RENAME TO Article;
ALTER TABLE reply RENAME TO Reply;
ALTER TABLE test RENAME TO Test;

SHOW TABLES;
DROP VIEW 'record';

DROP TABLE Test;
DROP TABLE Reply;
DROP TABLE Article;
DROP TABLE Grade;
DROP VIEW Record;
DROP TABLE Subject CASCADE;
DROP TABLE Admin;
DROP TABLE Member CASCADE;




