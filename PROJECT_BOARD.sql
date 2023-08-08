-- 프로젝트 초기화 SQL

-- 자유게시판 추천 테이블 삭제
DROP TABLE boardLike;

-- < 첨부파일 테이블 삭제 >
-- 자유게시판 첨부파일 테이블 삭제
DROP TABLE board_ATC;

-- 질문게시판 첨부파일 테이블 삭제
DROP TABLE QUESboard_ATC;

-- 공지사항 첨부파일 테이블 삭제
DROP TABLE NOTIboard_ATC;

-- 자유게시판 신고 첨부파일 테이블 삭제
DROP TABLE boardRPT_ATC;

-- 질문게시판 신고 첨부파일 테이블 삭제
DROP TABLE QUESboardRPT_ATC;

-- 댓글 신고 첨부파일 테이블 삭제
DROP TABLE commentRPT_ATC;

-- 회원 신고 첨부파일 테이블 삭제
DROP TABLE memberRPT_ATC;



-- < 신고 테이블 삭제 >
-- 회원 신고 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_memberRPT;
DROP TABLE memberRPT;

-- 댓글 신고 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_commentRPT;
DROP TABLE commentRPT;

-- 질문게시판 신고 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_QUESboardRPT;
DROP TABLE QUESboardRPT;

-- 자유게시판 신고 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_boardRPT;
DROP TABLE boardRPT;



-- 삭제된 문의 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_INQboard_DEL;
DROP TABLE INQboard_DEL;

-- 문의 테이블 시퀀스 및 삭제
DROP SEQUENCE seq_INQboard;
DROP TABLE INQboard;



-- 삭제된 댓글 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_comment_DEL;
DROP TABLE comment_DEL;

-- 댓글 테이블 시퀀스 및 삭제
DROP SEQUENCE seq_comment;
DROP TABLE tbl_comment;



-- 삭제된 공지사항 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_NOTIboard_DEL;
DROP TABLE NOTIboard_DEL;

-- 공지사항 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_NOTIboard;
DROP TABLE NOTIboard;



-- 삭제된 질문게시판 답글 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_answer_DEL;
DROP TABLE answer_DEL;

-- 질문게시판 답글 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_answer;
DROP TABLE answer;



-- 삭제된 질문 게시판 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_QUESboard_DEL;
DROP TABLE QUESboard_DEL;

-- 질문게시판 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_QUESboard;
DROP TABLE QUESboard;



-- 삭제된 자유게시판 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_board_DEL;
DROP TABLE board_DEL;

-- 자유게시판 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_board;
DROP TABLE board;



-- 회원 권한 테이블 삭제
DROP TABLE memberAuth;



-- 삭제된 회원 시퀀스 및 테이블 삭제
DROP SEQUENCE seq_DELmember;
DROP TABLE DELmember;

-- 회원 테이블 삭제
DROP TABLE member;




-- 회원 테이블 생성
CREATE TABLE member(
    memberId VARCHAR2(50) PRIMARY KEY,
    memberPwd VARCHAR2(50) NOT NULL,
    memberName VARCHAR2(12) NOT NULL UNIQUE,
    email VARCHAR2(200) NOT NULL UNIQUE,
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE,
    enabled CHAR(1) DEFAULT '1'
);


-- 회원 인증 테이블 생성
CREATE TABLE memberAuth(
    memberId VARCHAR2(20) NOT NULL,
    auth VARCHAR2(100) NOT NULL,
    CONSTRAINT fk_memberAuth_member FOREIGN KEY(memberId) REFERENCES member(memberId)
);

-- 관리자 계정 INSERT
INSERT INTO member(memberId, memberPwd, memberName, email)
VALUES('admin','1234','관리자','admin@test');
INSERT INTO memberAuth VALUES('admin','ROLE_ADMIN');
INSERT INTO memberAuth VALUES('admin','ROLE_MEMBER');
-- 일반 사용자 계정 INSERT
INSERT INTO member(memberId, memberPwd, memberName, email)
VALUES('writer','1234','작성자','writer@test');
INSERT INTO memberAuth VALUES('writer','ROLE_MEMBER');


-- 탈퇴한 회원 테이블 생성
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
-- 탈퇴한 회원 시퀀스 생성
CREATE SEQUENCE seq_DELmember;


-- 자유게시판 테이블 생성
CREATE TABLE board (
  bno NUMBER(10,0) PRIMARY KEY,
  title VARCHAR2(200) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
  commentCnt NUMBER(10,0),
  regDate DATE DEFAULT SYSDATE,
  updateDate DATE DEFAULT SYSDATE
);
-- 자유게시판 외래키 지정
ALTER TABLE board ADD CONSTRAINT fk_Board_Member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 자유게시판 시퀀스 생성
CREATE SEQUENCE seq_board;
-- 자유게시판 더미 데이터 생성
INSERT INTO board(bno, title, content, writer)
VALUES(seq_board.nextval, '테스트 제목01', '테스트 내용01','작성자');

INSERT INTO board(bno, title, content, writer)
VALUES(seq_board.nextval, '테스트 제목02', '테스트 내용02','작성자');

INSERT INTO board(bno, title, content, writer)
VALUES(seq_board.nextval, '테스트 제목03', '테스트 내용03','작성자');

INSERT INTO board(bno, title, content, writer)
VALUES(seq_board.nextval, '테스트 제목04', '테스트 내용04','작성자');


-- 삭제된 자유게시판 테이블 생성
CREATE TABLE board_DEL (
    DELbno NUMBER(10,0) PRIMARY KEY,
    bno NUMBER(10,0) NOT NULL UNIQUE, -- 자유 게시판 테이블 참조
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
    commentCnt NUMBER(10,0),
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- 삭제된 자유게시판 외래키 지정
ALTER TABLE board_DEL ADD CONSTRAINT fk_board_DEL_board
FOREIGN KEY(bno) REFERENCES board(bno);
ALTER TABLE board_DEL ADD CONSTRAINT fk_board_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 삭제된 자유게시판 시퀀스 생성
CREATE SEQUENCE seq_board_DEL;


-- 질문게시판 테이블 생성
CREATE TABLE QUESboard (
  QUESbno NUMBER(10,0) PRIMARY KEY,
  title VARCHAR2(200) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
  answerCnt NUMBER(10,0),
  commentCnt NUMBER(10,0),
  regDate DATE DEFAULT SYSDATE,
  updateDate DATE DEFAULT SYSDATE
);
-- 질문게시판 외래키 지정
ALTER TABLE QUESboard ADD CONSTRAINT fk_QUESboard_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 질문게시판 시퀀스 생성
CREATE SEQUENCE seq_QUESboard;
-- 질문게시판 더미 데이터 생성
INSERT INTO QUESboard(QUESbno, title, content, writer)
VALUES(seq_QUESboard.nextval, '질문게시판 테스트 제목01', '테스트 내용01','작성자');

INSERT INTO QUESboard(QUESbno, title, content, writer)
VALUES(seq_QUESboard.nextval, '질문게시판 테스트 제목02', '테스트 내용02','작성자');

INSERT INTO QUESboard(QUESbno, title, content, writer)
VALUES(seq_QUESboard.nextval, '질문게시판 테스트 제목03', '테스트 내용03','작성자');


-- 삭제된 질문게시판 테이블 생성
CREATE TABLE QUESboard_DEL (
    delQUESbno NUMBER(10,0) PRIMARY KEY,
    QUESbno NUMBER(10,0) NOT NULL UNIQUE,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
    answerCnt NUMBER(10,0),
    commentCnt NUMBER(10,0),
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- 삭제된 질문게시판 외래키 지정
ALTER TABLE QUESboard_DEL ADD CONSTRAINT fk_QUESboard_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 삭제된 질문게시판 시퀀스 초기화
CREATE SEQUENCE seq_QUESboard_DEL;


-- 질문게시판 답글 테이블 생성
CREATE TABLE answer (
  answerNum NUMBER(10,0) PRIMARY KEY,
  QUESbno NUMBER(10,0) NOT NULL UNIQUE, -- 질문게시판 테이블 참조
  title VARCHAR2(200) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
  regDate DATE DEFAULT SYSDATE,
  updateDate DATE DEFAULT SYSDATE
);
-- 질문게시판 답글 외래키 지정
ALTER TABLE answer ADD CONSTRAINT fk_answer_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);
ALTER TABLE answer ADD CONSTRAINT fk_answer_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 질문게시판 답글 시퀀스 생성
CREATE SEQUENCE seq_answer;


-- 삭제한 질문게시판 답글 테이블 생성
CREATE TABLE answer_DEL (
    DELanswerNum NUMBER(10,0) PRIMARY KEY,
    answerNum NUMBER(10,0) NOT NULL UNIQUE,
    QUESbno NUMBER(10,0) NOT NULL UNIQUE, -- 질문게시판 테이블 참조
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- 삭제한 질문게시판 답글 외래키 지정
ALTER TABLE answer_DEL ADD CONSTRAINT fk_answer_DEL_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);

ALTER TABLE answer_DEL ADD CONSTRAINT fk_answer_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 삭제한 질문게시판 답글 시퀀스 생성
CREATE SEQUENCE seq_answer_DEL;


-- 댓글 테이블 생성
CREATE TABLE tbl_comment(
    commentNum NUMBER(10,0) PRIMARY KEY,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
    bno NUMBER(10,0), -- 자유게시판 테이블 참조
    QUESbno NUMBER(10,0), -- 질문게시판 테이블 참조
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- 댓글 외래키 지정
ALTER TABLE tbl_comment ADD CONSTRAINT fk_comment_board
FOREIGN KEY(bno) REFERENCES board(bno);

ALTER TABLE tbl_comment ADD CONSTRAINT fk_comment_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);

ALTER TABLE tbl_comment ADD CONSTRAINT fk_comment_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 댓글 시퀀스 생성
CREATE SEQUENCE seq_comment;

-- 자유게시판 댓글 더미 데이터 1
INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'더미 댓글 01','작성자');

INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'더미 댓글 02','작성자');

INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'더미 댓글 03','작성자');

INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'더미 댓글 04','작성자');

-- 자유게시판 댓글 더미 데이터 2
INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 2,'더미 댓글 01','작성자');

INSERT INTO tbl_comment (commentNum, bno, content, writer)
VALUES (seq_comment.NEXTVAL, 2,'더미 댓글 02','작성자');

-- 질문게시판 댓글 더미 데이터 1
INSERT INTO tbl_comment (commentNum, QUESbno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'더미 댓글 01','작성자');

INSERT INTO tbl_comment (commentNum, QUESbno, content, writer)
VALUES (seq_comment.NEXTVAL, 1,'더미 댓글 02','작성자');

INSERT INTO tbl_comment (commentNum, QUESbno, Content, writer)
VALUES (seq_comment.NEXTVAL, 1,'더미 댓글 03','작성자');

-- 질문게시판 댓글 더미 데이터 2
INSERT INTO tbl_comment (commentNum, QUESbno, content, writer)
VALUES (seq_comment.NEXTVAL, 2,'더미 댓글 01','작성자');

INSERT INTO tbl_comment (commentNum, QUESbno, content, writer)
VALUES (seq_comment.NEXTVAL, 2,'더미 댓글 02','작성자');


-- 자유게시판 댓글 수 업데이트
UPDATE board B
SET commentCnt = (SELECT COUNT(commentNum) 
    FROM tbl_comment C WHERE C.bno = B.bno);
    
-- 질문게시판 댓글 수 업데이트
UPDATE QUESboard Q
SET commentCnt = (SELECT COUNT(commentNum) 
    FROM tbl_comment C WHERE C.QUESbno = Q.QUESbno);


-- 삭제된 댓글 테이블 생성
CREATE TABLE comment_DEL(
    DELcommentNum NUMBER(10,0) PRIMARY KEY,
    commentNum NUMBER(10,0) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
    bno NUMBER(10,0), -- 자유게시판 테이블 참조
    QUESbno NUMBER(10,0), -- 질문게시판 테이블 참조
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- 삭제된 댓글 외래키 지정
ALTER TABLE comment_DEL ADD CONSTRAINT fk_comment_DEL_board
FOREIGN KEY(bno) REFERENCES board(bno);

ALTER TABLE comment_DEL ADD CONSTRAINT fk_comment_DEL_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);

ALTER TABLE comment_DEL ADD CONSTRAINT fk_comment_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 삭제된 댓글 시퀀스 생성
CREATE SEQUENCE seq_comment_DEL;


-- 공지사항 테이블 생성
CREATE TABLE NOTIboard (
    NOTIbno NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
    REGdate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- 공지사항 외래키 지정
ALTER TABLE NOTIboard ADD CONSTRAINT fk_NOTIboard_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 공지사항 시퀀스 생성
CREATE SEQUENCE seq_NOTIboard;


-- 삭제된 공지사항 테이블 생성
CREATE TABLE NOTIboard_DEL (
    delNOTIbno NUMBER(10,0) PRIMARY KEY,
    NOTIbno NUMBER(10,0) NOT NULL UNIQUE,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
    REGdate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- 삭제된 공지사항 외래키 지정
ALTER TABLE NOTIboard_DEL ADD CONSTRAINT fk_NOTIboard_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 삭제된 공지사항 시퀀스 생성
CREATE SEQUENCE seq_NOTIboard_DEL;


-- 문의 테이블 생성
CREATE TABLE INQboard (
    INQbno NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- 문의 외래키 지정
ALTER TABLE INQboard ADD CONSTRAINT fk_INQboard_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 문의 테이블 시퀀스 생성
CREATE SEQUENCE seq_INQboard;


-- 삭제된 문의 테이블 생성
CREATE TABLE INQboard_DEL (
    delINQbno NUMBER(10,0) PRIMARY KEY,
    INQbno NUMBER(10,0) NOT NULL UNIQUE,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL, -- 회원 테이블 참조
    regDate DATE DEFAULT SYSDATE,
    updateDate DATE DEFAULT SYSDATE
);
-- 삭제된 문의 외래키 지정
ALTER TABLE INQboard_DEL ADD CONSTRAINT fk_INQboard_DEL_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 삭제된 문의 테이블 시퀀스 생성
CREATE SEQUENCE seq_INQboard_DEL;


-- 자유게시물 신고 테이블 생성
CREATE TABLE boardRPT (
    boardRPTnum NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    bno NUMBER(10,0) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL,
    RPTdate DATE DEFAULT SYSDATE
);
-- 자유게시판 신고 외래키 지정
ALTER TABLE boardRPT ADD CONSTRAINT fk_boardRPT_board
FOREIGN KEY(bno) REFERENCES board(bno);
ALTER TABLE boardRPT ADD CONSTRAINT fk_boardRPT_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 자유게시판 신고 테이블 시퀀스 생성
CREATE SEQUENCE seq_boardRPT;


-- 질문게시판 신고 테이블 생성
CREATE TABLE QUESboardRPT (
    QUESboardRPTnum NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    QUESbno NUMBER(10,0) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL,
    RPTdate DATE DEFAULT SYSDATE
);
-- 자유게시판 신고 외래키 지정
ALTER TABLE QUESboardRPT ADD CONSTRAINT fk_QUESboardRPT_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);
ALTER TABLE QUESboardRPT ADD CONSTRAINT fk_QUESboardRPT_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 자유게시판 신고 테이블 시퀀스 생성
CREATE SEQUENCE seq_QUESboardRPT;


-- 댓글 신고 테이블 생성
CREATE TABLE commentRPT (
    commentRPTnum NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    commentNum NUMBER(10,0) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL,
    RPTdate DATE DEFAULT SYSDATE
);
-- 댓글 신고 외래키 지정
ALTER TABLE commentRPT ADD CONSTRAINT fk_commentRPT_comment
FOREIGN KEY(commentNum) REFERENCES tbl_comment(commentNum);
ALTER TABLE commentRPT ADD CONSTRAINT fk_commentRPT_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 댓글 신고 테이블 시퀀스 생성
CREATE SEQUENCE seq_commentRPT;


-- 회원 신고 테이블 생성
CREATE TABLE memberRPT (
    memberRPTnum NUMBER(10,0) PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    RPTmemberName VARCHAR2(12) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(12) NOT NULL,
    RPTdate DATE DEFAULT SYSDATE
);
-- 회원 신고 외래키 지정
ALTER TABLE memberRPT ADD CONSTRAINT fk_RPTmemberName_member
FOREIGN KEY(RPTmemberName) REFERENCES member(memberName);
ALTER TABLE memberRPT ADD CONSTRAINT fk_memberRPT_member
FOREIGN KEY(writer) REFERENCES member(memberName);
-- 회원 신고 테이블 시퀀스 생성
CREATE SEQUENCE seq_memberRPT;


-- 자유게시판 첨부파일 테이블 생성
CREATE TABLE board_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    bno NUMBER(10,0) NOT NULL
);
-- 자유게시판 첨부파일 외래키 지정
ALTER TABLE board_ATC ADD CONSTRAINT fk_board_ATC_board
FOREIGN KEY(bno) REFERENCES board(bno);


-- 질문게시판 첨부파일 테이블 생성
CREATE TABLE QUESboard_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    QUESbno NUMBER(10,0) NOT NULL
);
-- 질문게시판 첨부파일 외래키 지정
ALTER TABLE QUESboard_ATC ADD CONSTRAINT fk_QUESboard_ATC_QUESboard
FOREIGN KEY(QUESbno) REFERENCES QUESboard(QUESbno);


-- 공지사항 첨부파일 테이블 생성
CREATE TABLE NOTIboard_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    NOTIbno NUMBER(10,0) NOT NULL
);
-- 공지사항 첨부파일 외래키 지정
ALTER TABLE NOTIboard_ATC ADD CONSTRAINT fk_NOTIboard_ATC_NOTIboard
FOREIGN KEY(NOTIbno) REFERENCES NOTIboard(NOTIbno);


-- 자유게시판 신고 첨부파일 테이블 생성
CREATE TABLE boardRPT_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    boardRPTnum NUMBER(10,0) NOT NULL
);
-- 자유게시판 신고 첨부파일 외래키 지정
ALTER TABLE boardRPT_ATC ADD CONSTRAINT fk_boardRPT_ATC_boardRPT
FOREIGN KEY(boardRPTnum) REFERENCES boardRPT(boardRPTnum);


-- 질문게시판 신고 첨부파일 테이블 생성
CREATE TABLE QUESboardRPT_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    QUESboardRPTnum NUMBER(10,0) NOT NULL
);
-- 질문게시판 신고 첨부파일 외래키 지정
ALTER TABLE QUESboardRPT_ATC ADD CONSTRAINT fk_QUESrpt_ATC_QUESboardRPT
FOREIGN KEY(QUESboardRPTnum) REFERENCES QUESboardRPT(QUESboardRPTnum);


-- 댓글 신고 첨부파일 테이블 생성
CREATE TABLE commentRPT_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    commentRPTnum NUMBER(10,0) NOT NULL
);
-- 댓글 신고 첨부파일 외래키 지정
ALTER TABLE commentRPT_ATC ADD CONSTRAINT fk_commentRPT_ATC_commentRPT
FOREIGN KEY(commentRPTnum) REFERENCES commentRPT(commentRPTnum);


-- 회원 신고 첨부파일 테이블 생성
CREATE TABLE memberRPT_ATC (
    uuid VARCHAR2(100) PRIMARY KEY,
    uploadPath VARCHAR2(200) NOT NULL,
    fileName VARCHAR2(100) NOT NULL,
    fileType CHAR(1) DEFAULT 'I' NOT NULL,
    memberRPTnum NUMBER(10,0) NOT NULL
);
-- 댓글 신고 첨부파일 외래키 지정
ALTER TABLE memberRPT_ATC ADD CONSTRAINT fk_memberRPT_ATC_memberRPT
FOREIGN KEY(memberRPTnum) REFERENCES memberRPT(memberRPTnum);


-- 자유게시판 추천 테이블 생성 및 외래키 지정
CREATE TABLE boardLike(
    bno NUMBER(10,0) NOT NULL,
    memberId VARCHAR2(50) NOT NULL,
    FOREIGN KEY (memberId) REFERENCES member(memberId) ON DELETE CASCADE,
    FOREIGN KEY (bno) REFERENCES board(bno) ON DELETE CASCADE
);