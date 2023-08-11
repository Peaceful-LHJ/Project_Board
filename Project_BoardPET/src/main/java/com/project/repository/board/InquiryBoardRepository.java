package com.project.repository.board;

import com.project.domain.board.InquiryBoardVO;

public interface InquiryBoardRepository {
	
	void inquiryBoardInsert(InquiryBoardVO vo);
	
	InquiryBoardVO inquiryBoardRead(Long INQbno);
	
	Long inquiryBoardDelete(Long INQbno);
	
}
