package com.project.repository.board;

import org.apache.ibatis.annotations.Param;

import com.project.domain.board.QuestionBoardVO;

public interface QuestionBoardRepository {
	
	void questionBoardInsert(QuestionBoardVO vo);
	
	Integer questionBoardInsertSelectKey(QuestionBoardVO vo);
	
	QuestionBoardVO questionBoardRead(Long QUESbno);
	
	Long questionBoardDelete(Long QUESbno);
	
	Long questionBoardUpdate(QuestionBoardVO vo);
	
	void questionBoardUpdateCommentCnt(@Param("QUESbno") Long QUESbno, @Param("amount") int amount);
	
	void questionBoardUpdateAnswerCnt(@Param("QUESbno") Long QUESbno, @Param("amount") int amount);
	
}
