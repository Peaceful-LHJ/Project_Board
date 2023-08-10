package com.project.repository.comment;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.comment.commentDEL.CommentDelVO;
import com.project.domain.comment.commentDEL.CommentFromDelVO;

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
	public void commentDelReadTest() {
		CommentDelVO commentDelRead = commentDelRepository.commentDelRead(1L);
		log.info(commentDelRead);
	}
	
	@Ignore
	@Test
	public void NoncommentDelRead() {
		CommentFromDelVO noncommentDelRead = commentDelRepository.NoncommentDelRead(2L);
		log.info(noncommentDelRead);
	}
	
}