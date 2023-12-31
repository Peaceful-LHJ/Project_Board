package com.project.repository.board.boardDEL;

import com.project.domain.board.boardDEL.QuestionBoardDelVO;

public interface QuestionBoardDelRepository { // 삭제된 질문 게시판
	
	Long questionBoardDelInsert(Long QUESbno); // 삭제된 질문게시물 추가
	Long questionBoardDelInsertByName(String memberName); // 해당 회원의 이름으로 작성된 모든 질문글 삭제된 테이블로 이동
	
	QuestionBoardDelVO questionBoardDelRead(Long QUESbno); // 삭제된 질문게시판 열람
	
}
