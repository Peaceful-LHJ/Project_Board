package com.project.repository.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.domain.board.QuestionBoardVO;

public interface QuestionBoardRepository {
	
	void questionBoardInsert(QuestionBoardVO vo);
	
	QuestionBoardVO questionBoardRead(Long QUESbno);
	
	List<QuestionBoardVO> questionBoardReadByName(String memberName); // 회원 이름으로 해당 회원이 작성한 모든 질문글 조회
	
	Long questionBoardDelete(Long QUESbno);
	
	Long questionBoardUpdate(QuestionBoardVO vo);
	
	void questionBoardUpdateCommentCnt(@Param("QUESbno") Long QUESbno, @Param("amount") int amount);
	
	void questionBoardUpdateAnswerCnt(@Param("QUESbno") Long QUESbno, @Param("amount") int amount);
	
}
