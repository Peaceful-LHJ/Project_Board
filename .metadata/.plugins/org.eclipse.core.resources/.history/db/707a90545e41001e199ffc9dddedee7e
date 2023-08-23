package com.project.repository.board.boardDEL;

import java.util.List;

import com.project.domain.board.boardDEL.BoardDelVO;

public interface BoardDelRepository { // 삭제된 자유게시판
	
	Long boardDelInsert(Long bno); // 삭제된 자유게시물 추가
	
	void boardDelInsertListByName(String memberName); // 해당 회원의 이름으로 작성된 모든 자유게시글 삭제테이블로 이동
	
	BoardDelVO boardDelRead(Long bno); // 삭제된 자유게시물 열람
	
	void boardDelDelete(Long DELbno); // 삭제된 자유게시물 영구 삭제
	
}
