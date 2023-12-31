package com.project.repository.board;

import com.project.domain.board.BoardLikeDTO;

public interface BoardLikeRepository {
	
	void boardLikeInsert(BoardLikeDTO boardLikeDTO);
	
	void boardLikeDelete(BoardLikeDTO boardLikeDTO);
	
	BoardLikeDTO getBoardLike(BoardLikeDTO boardLikeDTO);
	
}
