package com.project.repository.board;

import com.project.domain.board.boardDEL.QuestionBoardDelVO;

public interface QuestionBoardDelRepository { // 삭제된 질문 게시판
	
	Long questionBoardDelInsert(Long QUESbno); // 삭제된 질문게시물 추가
	
	QuestionBoardDelVO questionBoardDelRead(Long QUESbno); // 삭제된 질문게시판 열람
	
}