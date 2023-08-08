-- ������Ʈ �ʱ�ȭ SQL

-- �����Խ��� ��õ ���̺� ����
DROP TABLE boardLike;

-- < ÷������ ���̺� ���� >
-- �����Խ��� ÷������ ���̺� ����
DROP TABLE board_ATC;

-- �����Խ��� ÷������ ���̺� ����
DROP TABLE QUESboard_ATC;

-- �������� ÷������ ���̺� ����
DROP TABLE NOTIboard_ATC;

-- �����Խ��� �Ű� ÷������ ���̺� ����
DROP TABLE boardRPT_ATC;

-- �����Խ��� �Ű� ÷������ ���̺� ����
DROP TABLE QUESboardRPT_ATC;

-- ��� �Ű� ÷������ ���̺� ����
DROP TABLE commentRPT_ATC;

-- ȸ�� �Ű� ÷������ ���̺� ����
DROP TABLE memberRPT_ATC;



-- < �Ű� ���̺� ���� >
-- ȸ�� �Ű� ������ �� ���̺� ����
DROP SEQUENCE seq_memberRPT;
DROP TABLE memberRPT;

-- ��� �Ű� ������ �� ���̺� ����
DROP SEQUENCE seq_commentRPT;
DROP TABLE commentRPT;

-- �����Խ��� �Ű� ������ �� ���̺� ����
DROP SEQUENCE seq_QUESboardRPT;
DROP TABLE QUESboardRPT;

-- �����Խ��� �Ű� ������ �� ���̺� ����
DROP SEQUENCE seq_boardRPT;
DROP TABLE boardRPT;



-- ������ ���� ������ �� ���̺� ����
DROP SEQUENCE seq_INQboard_DEL;
DROP TABLE INQboard_DEL;

-- ���� ���̺� ������ �� ����
DROP SEQUENCE seq_INQboard;
DROP TABLE INQboard;



-- ������ ��� ������ �� ���̺� ����
DROP SEQUENCE seq_comment_DEL;
DROP TABLE comment_DEL;

-- ��� ���̺� ������ �� ����
DROP SEQUENCE seq_comment;
DROP TABLE tbl_comment;



-- ������ �������� ������ �� ���̺� ����
DROP SEQUENCE seq_NOTIboard_DEL;
DROP TABLE NOTIboard_DEL;

-- �������� ������ �� ���̺� ����
DROP SEQUENCE seq_NOTIboard;
DROP TABLE NOTIboard;



-- ������ �����Խ��� ��� ������ �� ���̺� ����
DROP SEQUENCE seq_answer_DEL;
DROP TABLE answer_DEL;

-- �����Խ��� ��� ������ �� ���̺� ����
DROP SEQUENCE seq_answer;
DROP TABLE answer;



-- ������ ���� �Խ��� ������ �� ���̺� ����
DROP SEQUENCE seq_QUESboard_DEL;
DROP TABLE QUESboard_DEL;

-- �����Խ��� ������ �� ���̺� ����
DROP SEQUENCE seq_QUESboard;
DROP TABLE QUESboard;



-- ������ �����Խ��� ������ �� ���̺� ����
DROP SEQUENCE seq_board_DEL;
DROP TABLE board_DEL;

-- �����Խ��� ������ �� ���̺� ����
DROP SEQUENCE seq_board;
DROP TABLE board;



-- ȸ�� ���� ���̺� ����
DROP TABLE memberAuth;



-- ������ ȸ�� ������ �� ���̺� ����
DROP SEQUENCE seq_DELmember;
DROP TABLE DELmember;

-- ȸ�� ���̺� ����
DROP TABLE member;




-- ȸ�� ���̺� ����
CREATE TABLE member(
    memberId VARCHAR2(50) PRIMARY KEY,
    memberPwd VARCHAR2(50) NOT NULL,
    memberName VARCHAR2(12) NOT NULL UNIQUE,
    email VARCHAR2(200) NOT NULL UNIQUE,
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE,
    enabled CHAR(1) DEFAULT '1'
);


-- ȸ�� ���� ���̺� ����
CREATE TABLE memberAuth(
    memberId VARCHAR2(20) NOT NULL,
    auth VARCHAR2(100) NOT NULL,
    CONSTRAINT fk_memberAuth_member FOREIGN KEY(memberId) REFERENCES member(memberId)
);

-- ������ ���� INSERT
INSERT INTO member(memberId, memberPwd, memberName, email)
VALUES('admin','1234','������','admin@test');
INSERT INTO memberAuth VALUES('admin','ROLE_ADMIN');
INSERT INTO memberAuth VALUES('admin','ROLE_MEMBER');
-- �Ϲ� ����� ���� INSERT
INSERT INTO member(memberId, memberPwd, memberName, email)
VALUES('writer','1234','�ۼ���','writer@test');
INSERT INTO memberAuth VALUES('writer','ROLE_MEMBER');


-- Ż���� ȸ�� ���̺� ����
CREATE TABLE DELmember(
    DELmemberNum NUMBER(10,0) PRIMARY KEY,
    memberId VARCHAR2(50) NOT NULL UNIQUE,
    memberPwd VARCHAR2(50) NOT NULL,
    memberName VARCHAR2(12) NOT NULL UNIQUE,
    email VARCHAR2(200) NOT NULL UNIQUE,
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE,
    enabled CHAR(1) DEFAULT '0'
);
-- Ż���� ȸ�� ������ ����
CREATE SEQUENCE seq_DELmember;


-- �����Խ��� ���̺� ����
CREATE TABLE board (
  bno NUMBER(10,0) PRIMARY KEY,
  title VARCHAR2(200) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
  commentCnt NUMBER(10,0),
  regDate DATE DEFAULT SYSDATE,
  updateDate DATE DEFAULT SYSDATE
);
-- �����Խ��� �ܷ�Ű ����
ALTER TABLE board ADD CONSTRAINT fk_Board_Member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- �����Խ��� ������ ����
CREATE SEQUENCE seq_board;
-- �����Խ��� ���� ������ ����
INSERT INTO board(bno, title, content, writer)
VALUES(seq_board.nextval, '�׽�Ʈ ����01', '�׽�Ʈ ����01','�ۼ���');

INSERT INTO board(bno, title, content, writer)
VALUES(seq_board.nextval, '�׽�Ʈ ����02', '�׽�Ʈ ����02','�ۼ���');

INSERT INTO board(bno, title, content, writer)
VALUES(seq_board.nextval, '�׽�Ʈ ����03', '�׽�Ʈ ����03','�ۼ���');

INSERT INTO board(bno, title, content, writer)
VALUES(seq_board.nextval, '�׽�Ʈ ����04', '�׽�Ʈ ����04','�ۼ���');


-- ������ �����Խ��� ���̺� ����
CREATE TABLE board_DEL (
    DELbno NUMBER(10,0) PRIMARY KEY,
    bno NUMBER(10,0) NOT NULL UNIQUE, -- ���� �Խ��� ���̺� ����
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
    commentCnt NUMBER(10,0),
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- ������ �����Խ��� �ܷ�Ű ����
ALTER TABLE board_DEL ADD CONSTRAINT fk_board_DEL_board
FOREIGN KEY(bno) REFERENCES board(bno);
ALTER TABLE board_DEL ADD CONSTRAINT fk_board_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ������ �����Խ��� ������ ����
CREATE SEQUENCE seq_board_DEL;


-- �����Խ��� ���̺� ����
CREATE TABLE QUESboard (
  QUESbno NUMBER(10,0) PRIMARY KEY,
  title VARCHAR2(200) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
  answerCnt NUMBER(10,0),
  commentCnt NUMBER(10,0),
  regDate DATE DEFAULT SYSDATE,
  updateDate DATE DEFAULT SYSDATE
);
-- �����Խ��� �ܷ�Ű ����
ALTER TABLE QUESboard ADD CONSTRAINT fk_QUESboard_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- �����Խ��� ������ ����
CREATE SEQUENCE seq_QUESboard;
-- �����Խ��� ���� ������ ����
INSERT INTO QUESboard(QUESbno, title, content, writer)
VALUES(seq_QUESboard.nextval, '�����Խ��� �׽�Ʈ ����01', '�׽�Ʈ ����01','�ۼ���');

INSERT INTO QUESboard(QUESbno, title, content, writer)
VALUES(seq_QUESboard.nextval, '�����Խ��� �׽�Ʈ ����02', '�׽�Ʈ ����02','�ۼ���');

INSERT INTO QUESboard(QUESbno, title, content, writer)
VALUES(seq_QUESboard.nextval, '�����Խ��� �׽�Ʈ ����03', '�׽�Ʈ ����03','�ۼ���');


-- ������ �����Խ��� ���̺� ����
CREATE TABLE QUESboard_DEL (
    delQUESbno NUMBER(10,0) PRIMARY KEY,
    QUESbno NUMBER(10,0) NOT NULL UNIQUE,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
    answerCnt NUMBER(10,0),
    commentCnt NUMBER(10,0),
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- ������ �����Խ��� �ܷ�Ű ����
ALTER TABLE QUESboard_DEL ADD CONSTRAINT fk_QUESboard_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ������ �����Խ��� ������ �ʱ�ȭ
CREATE SEQUENCE seq_QUESboard_DEL;


-- �����Խ��� ��� ���̺� ����
CREATE TABLE answer (
  answerNum NUMBER(10,0) PRIMARY KEY,
  QUESbno NUMBER(10,0) NOT NULL UNIQUE, -- �����Խ��� ���̺� ����
  title VARCHAR2(200) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
  regDate DATE DEFAULT SYSDATE,
  updateDate DATE DEFAULT SYSDATE
);
-- �����Խ��� ��� �ܷ�Ű ����
ALTER TABLE answer ADD CONSTRAINT fk_answer_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);
ALTER TABLE answer ADD CONSTRAINT fk_answer_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- �����Խ��� ��� ������ ����
CREATE SEQUENCE seq_answer;


-- ������ �����Խ��� ��� ���̺� ����
CREATE TABLE answer_DEL (
    DELanswerNum NUMBER(10,0) PRIMARY KEY,
    answerNum NUMBER(10,0) NOT NULL UNIQUE,
    QUESbno NUMBER(10,0) NOT NULL UNIQUE, -- �����Խ��� ���̺� ����
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- ������ �����Խ��� ��� �ܷ�Ű ����
ALTER TABLE answer_DEL ADD CONSTRAINT fk_answer_DEL_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);

ALTER TABLE answer_DEL ADD CONSTRAINT fk_answer_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ������ �����Խ��� ��� ������ ����
CREATE SEQUENCE seq_answer_DEL;


-- ��� ���̺� ����
CREATE TABLE tbl_comment(
    commentNum NUMBER(10,0) PRIMARY KEY,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
    bno NUMBER(10,0), -- �����Խ��� ���̺� ����
    QUESbno NUMBER(10,0), -- �����Խ��� ���̺� ����
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- ��� �ܷ�Ű ����
ALTER TABLE tbl_comment ADD CONSTRAINT fk_comment_board
FOREIGN KEY(bno) REFERENCES board(bno);

ALTER TABLE tbl_comment ADD CONSTRAINT fk_comment_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);

ALTER TABLE tbl_comment ADD CONSTRAINT fk_comment_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ��� ������ ����
CREATE SEQUENCE seq_comment;

-- �����Խ��� ��� ���� ������ 1
INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'���� ��� 01','�ۼ���');

INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'���� ��� 02','�ۼ���');

INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'���� ��� 03','�ۼ���');

INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'���� ��� 04','�ۼ���');

-- �����Խ��� ��� ���� ������ 2
INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 2,'���� ��� 01','�ۼ���');

INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 2,'���� ��� 02','�ۼ���');

-- �����Խ��� ��� ���� ������ 1
INSERT INTO tbl_comment (commentNum, QUESbno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'���� ��� 01','�ۼ���');

INSERT INTO tbl_comment (commentNum, QUESbno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'���� ��� 02','�ۼ���');

INSERT INTO tbl_comment (commentNum, QUESbno, Content, writer)
VALUES (seq_comment.NEXTVAL, 1,'���� ��� 03','�ۼ���');

-- �����Խ��� ��� ���� ������ 2
INSERT INTO tbl_comment (commentNum, QUESbno, content, writer)
VALUES (seq_comment.NEXTVAL, 2,'���� ��� 01','�ۼ���');

INSERT INTO tbl_comment (commentNum, QUESbno, content, writer)
VALUES (seq_comment.NEXTVAL, 2,'���� ��� 02','�ۼ���');


-- �����Խ��� ��� �� ������Ʈ
UPDATE board B
SET commentCnt = (SELECT COUNT(commentNum) 
    FROM tbl_comment C WHERE C.bno = B.bno);
    
-- �����Խ��� ��� �� ������Ʈ
UPDATE QUESboard Q
SET commentCnt = (SELECT COUNT(commentNum) 
    FROM tbl_comment C WHERE C.QUESbno = Q.QUESbno);


-- ������ ��� ���̺� ����
CREATE TABLE comment_DEL(
    DELcommentNum NUMBER(10,0) PRIMARY KEY,
    commentNum NUMBER(10,0) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
    bno NUMBER(10,0), -- �����Խ��� ���̺� ����
    QUESbno NUMBER(10,0), -- �����Խ��� ���̺� ����
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- ������ ��� �ܷ�Ű ����
ALTER TABLE comment_DEL ADD CONSTRAINT fk_comment_DEL_board
FOREIGN KEY(bno) REFERENCES board(bno);

ALTER TABLE comment_DEL ADD CONSTRAINT fk_comment_DEL_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);

ALTER TABLE comment_DEL ADD CONSTRAINT fk_comment_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ������ ��� ������ ����
CREATE SEQUENCE seq_comment_DEL;


-- �������� ���̺� ����
CREATE TABLE NOTIboard (
    NOTIbno NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
    REGdate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- �������� �ܷ�Ű ����
ALTER TABLE NOTIboard ADD CONSTRAINT fk_NOTIboard_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- �������� ������ ����
CREATE SEQUENCE seq_NOTIboard;


-- ������ �������� ���̺� ����
CREATE TABLE NOTIboard_DEL (
    delNOTIbno NUMBER(10,0) PRIMARY KEY,
    NOTIbno NUMBER(10,0) NOT NULL UNIQUE,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
    REGdate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- ������ �������� �ܷ�Ű ����
ALTER TABLE NOTIboard_DEL ADD CONSTRAINT fk_NOTIboard_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ������ �������� ������ ����
CREATE SEQUENCE seq_NOTIboard_DEL;


-- ���� ���̺� ����
CREATE TABLE INQboard (
    INQbno NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- ���� �ܷ�Ű ����
ALTER TABLE INQboard ADD CONSTRAINT fk_INQboard_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ���� ���̺� ������ ����
CREATE SEQUENCE seq_INQboard;


-- ������ ���� ���̺� ����
CREATE TABLE INQboard_DEL (
    delINQbno NUMBER(10,0) PRIMARY KEY,
    INQbno NUMBER(10,0) NOT NULL UNIQUE,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- ȸ�� ���̺� ����
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- ������ ���� �ܷ�Ű ����
ALTER TABLE INQboard_DEL ADD CONSTRAINT fk_INQboard_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ������ ���� ���̺� ������ ����
CREATE SEQUENCE seq_INQboard_DEL;


-- �����Խù� �Ű� ���̺� ����
CREATE TABLE boardRPT (
    boardRPTnum NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    bno NUMBER(10,0) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL,
    RPTdate DATE DEFAULT SYSDATE
);
-- �����Խ��� �Ű� �ܷ�Ű ����
ALTER TABLE boardRPT ADD CONSTRAINT fk_boardRPT_board
FOREIGN KEY(bno) REFERENCES board(bno);
ALTER TABLE boardRPT ADD CONSTRAINT fk_boardRPT_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- �����Խ��� �Ű� ���̺� ������ ����
CREATE SEQUENCE seq_boardRPT;


-- �����Խ��� �Ű� ���̺� ����
CREATE TABLE QUESboardRPT (
    QUESboardRPTnum NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    QUESbno NUMBER(10,0) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL,
    RPTdate DATE DEFAULT SYSDATE
);
-- �����Խ��� �Ű� �ܷ�Ű ����
ALTER TABLE QUESboardRPT ADD CONSTRAINT fk_QUESboardRPT_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);
ALTER TABLE QUESboardRPT ADD CONSTRAINT fk_QUESboardRPT_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- �����Խ��� �Ű� ���̺� ������ ����
CREATE SEQUENCE seq_QUESboardRPT;


-- ��� �Ű� ���̺� ����
CREATE TABLE commentRPT (
    commentRPTnum NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    commentNum NUMBER(10,0) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL,
    RPTdate DATE DEFAULT SYSDATE
);
-- ��� �Ű� �ܷ�Ű ����
ALTER TABLE commentRPT ADD CONSTRAINT fk_commentRPT_comment
FOREIGN KEY(commentNum) REFERENCES tbl_comment(commentNum);
ALTER TABLE commentRPT ADD CONSTRAINT fk_commentRPT_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ��� �Ű� ���̺� ������ ����
CREATE SEQUENCE seq_commentRPT;


-- ȸ�� �Ű� ���̺� ����
CREATE TABLE memberRPT (
    memberRPTnum NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    RPTmemberName VARCHAR2(12) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL,
    RPTdate DATE DEFAULT SYSDATE
);
-- ȸ�� �Ű� �ܷ�Ű ����
ALTER TABLE memberRPT ADD CONSTRAINT fk_RPTmemberName_member
FOREIGN KEY(RPTmemberName) REFERENCES member(memberName);
ALTER TABLE memberRPT ADD CONSTRAINT fk_memberRPT_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- ȸ�� �Ű� ���̺� ������ ����
CREATE SEQUENCE seq_memberRPT;


-- �����Խ��� ÷������ ���̺� ����
CREATE TABLE board_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    bno NUMBER(10,0) NOT NULL
);
-- �����Խ��� ÷������ �ܷ�Ű ����
ALTER TABLE board_ATC ADD CONSTRAINT fk_board_ATC_board
FOREIGN KEY(bno) REFERENCES board(bno);


-- �����Խ��� ÷������ ���̺� ����
CREATE TABLE QUESboard_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    QUESbno NUMBER(10,0) NOT NULL
);
-- �����Խ��� ÷������ �ܷ�Ű ����
ALTER TABLE QUESboard_ATC ADD CONSTRAINT fk_QUESboard_ATC_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);


-- �������� ÷������ ���̺� ����
CREATE TABLE NOTIboard_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    NOTIbno NUMBER(10,0) NOT NULL
);
-- �������� ÷������ �ܷ�Ű ����
ALTER TABLE NOTIboard_ATC ADD CONSTRAINT fk_NOTIboard_ATC_NOTIboard
FOREIGN KEY(NOTIbno) REFERENCES NOTIboard(NOTIbno);


-- �����Խ��� �Ű� ÷������ ���̺� ����
CREATE TABLE boardRPT_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    boardRPTnum NUMBER(10,0) NOT NULL
);
-- �����Խ��� �Ű� ÷������ �ܷ�Ű ����
ALTER TABLE boardRPT_ATC ADD CONSTRAINT fk_boardRPT_ATC_boardRPT
FOREIGN KEY(boardRPTnum) REFERENCES boardRPT(boardRPTnum);


-- �����Խ��� �Ű� ÷������ ���̺� ����
CREATE TABLE QUESboardRPT_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    QUESboardRPTnum NUMBER(10,0) NOT NULL
);
-- �����Խ��� �Ű� ÷������ �ܷ�Ű ����
ALTER TABLE QUESboardRPT_ATC ADD CONSTRAINT fk_QUESrpt_ATC_QUESboardRPT
FOREIGN KEY(QUESboardRPTnum) REFERENCES QUESboardRPT(QUESboardRPTnum);


-- ��� �Ű� ÷������ ���̺� ����
CREATE TABLE commentRPT_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    commentRPTnum NUMBER(10,0) NOT NULL
);
-- ��� �Ű� ÷������ �ܷ�Ű ����
ALTER TABLE commentRPT_ATC ADD CONSTRAINT fk_commentRPT_ATC_commentRPT
FOREIGN KEY(commentRPTnum) REFERENCES commentRPT(commentRPTnum);


-- ȸ�� �Ű� ÷������ ���̺� ����
CREATE TABLE memberRPT_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    memberRPTnum NUMBER(10,0) NOT NULL
);
-- ��� �Ű� ÷������ �ܷ�Ű ����
ALTER TABLE memberRPT_ATC ADD CONSTRAINT fk_memberRPT_ATC_memberRPT
FOREIGN KEY(memberRPTnum) REFERENCES memberRPT(memberRPTnum);


-- �����Խ��� ��õ ���̺� ���� �� �ܷ�Ű ����
CREATE TABLE boardLike(
    bno NUMBER(10,0) NOT NULL,
    memberId VARCHAR2(50) NOT NULL,
    FOREIGN KEY (memberId) REFERENCES member(memberId) ON DELETE CASCADE,
    FOREIGN KEY (bno) REFERENCES board(bno) ON DELETE CASCADE
);