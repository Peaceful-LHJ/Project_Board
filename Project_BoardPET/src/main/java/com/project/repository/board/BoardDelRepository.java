package com.project.repository.board;

import com.project.domain.board.BoardVO;

public interface BoardDelRepository {
	
	void boardDelInsert(Long bno); // 삭제된 자유게시물 추가
	
	BoardVO boardDelRead(Long bno); // 삭제된 자유게시물 열람
	
	Long boardDelDelete(Long bno); // 자유게시글 영구삭제
	
}
