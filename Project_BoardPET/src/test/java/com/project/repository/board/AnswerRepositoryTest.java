
package com.project.repository.board;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.AnswerVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class AnswerRepositoryTest extends AppTest { // 답글 repository 테스트
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Ignore
	@Test
	public void answerInsertTest() { // 답글 작성 테스트
		AnswerVO answerVO = AnswerVO.builder()
				.QUESbno(1L)
				.content("답글 테스트 내용입니다3")
				.writer("작성자")
				.build();
		answerRepository.answerInsert(answerVO);
	}
	
	@Ignore
	@Test
	public void answerReadTest() { // 답글 단독 조회 테스트
		AnswerVO answerRead = answerRepository.answerRead(1L);
		log.info(answerRead);
	}
	
	@Ignore
	@Test
	public void answerListReadTest() { // 해당 질문글의 모든 답글 조회 테스트
		List<AnswerVO> answerListRead = answerRepository.answerListRead(1L);
		log.info(answerListRead);
	}
	
	@Ignore
	@Test
	public void answerUpdateTest() { // 답글 수정 테스트
		AnswerVO answerVO = AnswerVO.builder()
				.answerNum(1L)
				.content("답글 수정 테스트 내용입니다")
				.build();
		answerRepository.answerUpdate(answerVO);
		AnswerVO answerRead = answerRepository.answerRead(1L);
		log.info(answerRead);
	}
	
	@Ignore
	@Test
	public void getAnswerCountTest() { // 해당 질문글의 총 답글 수 카운트 테스트
		Long QUESbno = 1L;
		Long answerCount = answerRepository.getAnswerCount(QUESbno);
		log.info(QUESbno + "번 질문게시글의 답글 수 : " + answerCount);
	}
	
	@Ignore
	@Test
	public void answerDeleteTest() { // 답글 단독 영구삭제 테스트
		answerRepository.answerDelete(1L);
	}
	
	@Ignore
	@Test
	public void answerListDeleteTest() { // 해당 질문글의 모든 답글 영구삭제 테스트
		answerRepository.answerListDelete(1L);
	}
	
	@Ignore
	@Test
	public void answerReadByNameTest() { // 해당 회원의 이름으로 작성된 모든 답글 조회
		List<AnswerVO> answerReadByName = answerRepository.answerReadByName("작성자");
		log.info(answerReadByName);
	}
	
	@Ignore
	@Test
	public void answerListDeleteByNameTest() { // 해당 회원의 이름으로 작성된 모든 답글 영구 삭제
		Long answerListDeleteByName = answerRepository.answerListDeleteByName("작성자");
		log.info("해당 회원의 영구삭제된 답글 수 : " + answerListDeleteByName);
	}

}
