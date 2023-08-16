package com.project.repository.board.boardDEL;

import com.project.domain.board.boardDEL.BoardDelVO;

public interface BoardDelRepository { // 삭제된 자유게시판
	
	Long boardDelInsert(Long bno); // 삭제된 자유게시물 추가
	
	BoardDelVO boardDelRead(Long bno); // 삭제된 자유게시물 열람
	
	void boardDelDelete(Long DELbno); // 삭제된 자유게시물 영구 삭제
	
}
