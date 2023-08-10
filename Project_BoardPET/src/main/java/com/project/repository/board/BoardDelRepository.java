package com.project.repository.board;

import com.project.domain.board.boardDEL.BoardDelVO;

public interface BoardDelRepository {
	
	Long boardDelInsert(Long bno); // 삭제된 자유게시물 추가
	
	BoardDelVO boardDelRead(Long bno); // 삭제된 자유게시물 열람
	
	Long boardDelRestoration(Long bno); // 삭제된 자유게시글 복구
	
}
