package com.project.repository.board.boardDEL;

import com.project.domain.board.boardDEL.NoticeBoardDelVO;

public interface NoticeBoardDelRepository {
	
	Long noticeBoardDelInsert(Long NOTIbno);
	
	NoticeBoardDelVO noticeBoardDelRead(Long NOTIbno);
	
	void noticeBoardDelDelete(Long delNOTIbno);
	
}
