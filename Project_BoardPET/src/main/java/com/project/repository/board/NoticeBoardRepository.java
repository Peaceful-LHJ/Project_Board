package com.project.repository.board;

import com.project.domain.board.NoticeBoardVO;

public interface NoticeBoardRepository {
	
	void noticeBoardInsert(NoticeBoardVO vo);
	
	NoticeBoardVO noticeBoardRead(Long NOTIbno);
	
	Long noticeBoardDelete(Long NOTIbno);
	
	Long noticeBoardUpdate(NoticeBoardVO vo);
	
}
