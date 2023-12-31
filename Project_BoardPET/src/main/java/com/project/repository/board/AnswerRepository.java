package com.project.repository.board;

import java.util.List;

import com.project.domain.board.AnswerVO;

public interface AnswerRepository {
	
	void answerInsert(AnswerVO vo);
	
	AnswerVO answerRead(Long answerNum);
	
	List<AnswerVO> answerReadByName(String memberName); // 해당 회원이름의 사용자가 작성한 모든 답변글 조회
	
	List<AnswerVO> answerListRead(Long QUESbno); // 해당 질문글의 모든 답글 모기
	
	Long answerUpdate(AnswerVO vo); // 답글 수정
	
	Long answerDelete(Long answerNum); // 답글 단독 영구삭제
	Long answerListDelete(Long QUESbno); // 해당 질문글의 모든 답글 영구삭제
	Long answerListDeleteByName(String memberName); // 해당 회윈의 이름으로 작성된 모든 답글 영구 삭제
	
	Long getAnswerCount(Long QUESbno); // 답글 수 조회
	
}
