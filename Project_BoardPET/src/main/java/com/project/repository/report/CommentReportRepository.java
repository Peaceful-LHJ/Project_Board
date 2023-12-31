package com.project.repository.report;

import com.project.domain.report.CommentReportVO;

public interface CommentReportRepository { // 댓글 신고 기능

	void commentReportInsert(CommentReportVO vo); // 댓글 신고글 작성
	
	CommentReportVO commentReportRead(Long commentRPTnum); // 댓글 신고글 조회
	
	Long commentReportDelete(Long commentRPTnum); // 댓글 신고글 삭제
	
}
