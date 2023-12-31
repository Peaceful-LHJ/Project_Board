package com.project.repository.comment;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.comment.commentDEL.CommentDelVO;
import com.project.domain.comment.commentDEL.CommentFromDelVO;
import com.project.repository.comment.commentDEL.CommentDelRepository;

import lombok.extern.log4j.Log4j;

@Log4j
public class CommentDelRepositoryTest extends AppTest {
	
	@Autowired
	CommentDelRepository commentDelRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Ignore
	@Test
	public void boardCommentDelInsertTest() { // 자유게시글 댓글 삭제테이블 이동 테스트
		commentDelRepository.boardCommentDelInsert(2L);
	}
	
	@Ignore
	@Test
	public void questionBoardCommentDelInsertTest() { // 질문게시글 댓글 삭제테이블 이동 테스트
		commentDelRepository.questionBoardCommentDelInsert(10L);
	}
	
	@Ignore
	@Test
	public void NonBoardCommentDelInsertTest() { // 삭제된 자유게시글을 참조하는 댓글 가삭제 테이블 이동 테스트
		commentDelRepository.NonBoardCommentDelInsert(1L);
	}
	
	@Ignore
	@Test
	public void NonQuestionBoardCommentDelInsertTest() { // 삭제된 질문게시글을 참조하는 댓글 가삭제 테이블 이동 테스트
		commentDelRepository.NonQuestionBoardCommentDelInsert(1L);
	}
	
	@Ignore
	@Test
	public void commentDelReadTest() { // 삭제된 댓글 조회
		CommentDelVO commentDelRead = commentDelRepository.commentDelRead(1L);
		log.info(commentDelRead);
	}
	
	@Ignore
	@Test
	public void NoncommentDelReadTest() { // 가삭제된 댓글 조회
		CommentFromDelVO noncommentDelRead = commentDelRepository.NoncommentDelRead(2L);
		log.info(noncommentDelRead);
	}
	
	@Ignore
	@Test
	public void allCommentDelInsertListByNameTest() { // 해당 회원의 이름으로 작성된 모든 댓글 삭제
		Long allCommentDeleteCount = commentDelRepository.allCommentDelInsertListByName("작성자");
		log.info("삭제된 댓글 수 : " + allCommentDeleteCount);
	}
	
}
