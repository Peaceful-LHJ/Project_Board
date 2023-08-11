package com.project.repository.board;

import java.util.List;

import com.project.domain.board.AnswerVO;

public interface AnswerRepository {
	
	void answerInsert(AnswerVO vo);
	
	AnswerVO answerRead(Long answerNum);
	
	List<AnswerVO> answerListRead(Long QUESbno); // 해당 질문글의 모든 답글 모기
	
	Long answerUpdate(AnswerVO vo);
	
	Long answerDelete(Long answerNum); // 답글 단독 영구삭제
	
	Long answerListDelete(Long QUESbno); // 해당 질문글의 모든 답글 영구삭제
	
	Long getAnswerCount(Long QUESbno);
	
}
