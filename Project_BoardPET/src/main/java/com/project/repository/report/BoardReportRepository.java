package com.project.repository.report;

import com.project.domain.report.BoardReportVO;

public interface BoardReportRepository { // 자유게시글 신고 기능
	
	void boardReportInsert(BoardReportVO vo); // 자유게시글 신고글 작성
	
	BoardReportVO boardReportRead(Long boardRPTnum); // 자유게시글 신고글 조회
	
	Long boardReportDelete(Long boardRPTnum); // 자유게시글 신고글 삭제
	
}
