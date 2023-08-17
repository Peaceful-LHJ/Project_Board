package com.project.repository.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.domain.board.QuestionBoardVO;

public interface QuestionBoardRepository {
	
	void questionBoardInsert(QuestionBoardVO vo);
	
	QuestionBoardVO questionBoardRead(Long QUESbno);
	List<Long> selectQuestionBoardBnoByName(String memberName); // 해당 회원의 이름으로 작성된 모든 질문글의 번호 추출
	
	List<QuestionBoardVO> questionBoardReadByName(String memberName); // 해당 회원의 이름으로 작성된 모든 질문글 조회
	
	Long questionBoardDelete(Long QUESbno);
	Long questionBoardDeleteListByName(String memberName); // 해당 회원의 이름으로 작성된 모든 질문글 영구 삭제
	
	Long questionBoardUpdate(QuestionBoardVO vo);
	
	void questionBoardUpdateCommentCnt(@Param("QUESbno") Long QUESbno, @Param("amount") int amount);
	
	void questionBoardUpdateAnswerCnt(@Param("QUESbno") Long QUESbno, @Param("amount") int amount);
	
}
