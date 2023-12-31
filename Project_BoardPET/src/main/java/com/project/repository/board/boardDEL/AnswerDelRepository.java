package com.project.repository.board.boardDEL;

import java.util.List;

import com.project.domain.board.boardDEL.AnswerDelVO;
import com.project.domain.board.boardDEL.AnswerFromDelVO;

public interface AnswerDelRepository {
	
	void answerDelInsert(Long answerNum); // 답글 삭제테이블 이동
	Long answerDelInsertByName(String memberName); // 해당 회원의 이름으로 작성된 모든 답글 삭제테이블 이동
	
	void NonAnswerDelInsert(Long QUESbno); // 삭제된 질문글을 참조하는 답글 가삭제 테이블로 이동
	
	AnswerDelVO answerDelRead(Long DELanswerNum); // 삭제된 답글 조회
	
	AnswerFromDelVO NonAnswerDelRead(Long fromDELanswerNum); // 가삭제된 답글 단독 조회
	
	List<AnswerFromDelVO> NonAnswerListDelRead(Long QUESbno); // 해당 질문글 답글 모두 조회
	
	Long answerDelDelete(Long DELanswerNum); // 답글 삭제테이블 해당 데이터 영구삭제
	
	Long NonAnswerDelDelete(Long fromDELanswerNum); // 답글 가삭제테이블 해당 데이터 영구삭제
	
}
