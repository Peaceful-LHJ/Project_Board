package com.project.repository.board;

import org.apache.ibatis.annotations.Param;

import com.project.domain.board.BoardVO;

public interface BoardRepository {
	
	void boardInsert(BoardVO vo);
	
	Integer boardInsertSelectKey(BoardVO vo);
	
	BoardVO boardRead(Long bno);
	
	Long boardDelete(Long bno);
	
	Long boardUpdate(BoardVO vo);
	
	void boardUpdateCommentCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	void boardUpdateLikeCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
}
