package com.project.repository.report;

import com.project.domain.report.QuestionBoardReportVO;

public interface QuestionBoardReportRepository { // 질문게시글 신고 기능
	
	void questionBoardReportInsert(QuestionBoardReportVO vo); // 질문게시글 신고글 작성
	
	QuestionBoardReportVO questionBoardReportRead(Long QUESboardRPTnum); // 질문게시글 신고글 조회
	
	Long questionBoardReportDelete(Long QUESboardRPTnum); // 질문게시글 신고글 삭제
	
}
