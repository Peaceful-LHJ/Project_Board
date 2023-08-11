package com.project.repository.board.boardDEL;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.boardDEL.AnswerDelVO;
import com.project.domain.board.boardDEL.AnswerFromDelVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class AnswerDelRepositoryTest extends AppTest { // 답글 삭제 repository 테스트
	
	@Autowired
	AnswerDelRepository answerDelRepository;
	
	@Ignore
	@Test
	public void answerDelInsertTest() { // 답글 삭제 테이블 이동 테스트
		answerDelRepository.answerDelInsert(2L);
	}
	
	@Ignore
	@Test
	public void NonAnswerDelInsertTest() { // 삭제된 질문글을 참조하는 답글 가삭제 테이블로 이동
		answerDelRepository.NonAnswerDelInsert(3L);
	}
	
	@Ignore
	@Test
	public void answerDelReadTest() {
		AnswerDelVO answerDelRead = answerDelRepository.answerDelRead(1L);
		log.info(answerDelRead);
	}
	
	@Ignore
	@Test
	public void NonAnswerDelReadTest() {
		AnswerFromDelVO nonAnswerDelRead = answerDelRepository.NonAnswerDelRead(1L);
		log.info(nonAnswerDelRead);
	}
	
	@Ignore
	@Test
	public void answerDelDeleteTest() {
		answerDelRepository.answerDelDelete(3L);
	}
	
	@Ignore
	@Test
	public void NonAnswerDelDeleteTest() {
		answerDelRepository.NonAnswerDelDelete(3L);
	}
	
}
