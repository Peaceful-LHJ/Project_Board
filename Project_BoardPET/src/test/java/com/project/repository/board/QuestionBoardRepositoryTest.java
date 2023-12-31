package com.project.repository.board;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.QuestionBoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionBoardRepositoryTest extends AppTest { // 질문게시글 Repository 테스트
	
	@Autowired
	QuestionBoardRepository questionBoardRepository;
	
	@Ignore
	@Test
	public void questionBoardInsertTest() { // 질문게시글 작성 테스트
		QuestionBoardVO questionBoardVO = QuestionBoardVO.builder()
				.title("질문게시글 테스트 제목")
				.content("질문 내용입니다")
				.writer("작성자")
				.build();
		questionBoardRepository.questionBoardInsert(questionBoardVO);
		log.info(questionBoardVO);
	}
	
	@Ignore
	@Test
	public void questionBoardReadTest() { // 질문게시글 조회 테스트
		QuestionBoardVO questionBoardRead = questionBoardRepository.questionBoardRead(1L);
		log.info(questionBoardRead);
	}
	
	@Ignore
	@Test
	public void questionBoardDeleteTest() { // 질문게시글 영구삭제 테스트
		Long QUESbno = 1L; // 삭제할 질문게시글 번호
		Long questionBoardDelete = questionBoardRepository.questionBoardDelete(QUESbno);
		log.info(QUESbno + "번 질문 게시글 삭제 완료 : " + questionBoardDelete);
	}
	
	@Ignore
	@Test
	public void questionBoardUpdateTest() { // 질문게시글 수정 테스트
		Long QUESbno = 1L; // 수정할 질문게시글 번호
		QuestionBoardVO questionBoardVO = QuestionBoardVO.builder()
				.QUESbno(QUESbno)
				.title("질문게시글 수정 제목")
				.content("질문게시글 수정하였습니다")
				.build();
		questionBoardRepository.questionBoardUpdate(questionBoardVO);
		QuestionBoardVO questionBoardRead = questionBoardRepository.questionBoardRead(QUESbno); // 수정한 질문게시글 조회
		log.info(questionBoardRead);
	}
	
	@Ignore
	@Test
	public void questionBaordReadByNameTest() { // 회원 이름으로 해당 회원이 작성한 모든 질문글 조회
		List<QuestionBoardVO> questionBoardReadByName = questionBoardRepository.questionBoardReadByName("작성자");
		log.info(questionBoardReadByName);
	}
	
	@Ignore
	@Test
	public void questionBoardDeleteListByNameTest() { // 해당 회원의 이름으로 작성된 모든 질문글 영구삭제
		Long questionBoardDeleteListByName = questionBoardRepository.questionBoardDeleteListByName("작성자");
		log.info("해당 회원의 영구삭제된 질문글 수 : " + questionBoardDeleteListByName);
	}
	
	@Ignore
	@Test
	public void selectQuestionBoardBnoByNameTest() {
		List<Long> selectQuestionBoardBnoByName = questionBoardRepository.selectQuestionBoardBnoByName("작성자");
		log.info(selectQuestionBoardBnoByName);
	}
	
}
