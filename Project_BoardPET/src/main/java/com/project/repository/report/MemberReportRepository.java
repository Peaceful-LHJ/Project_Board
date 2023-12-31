package com.project.repository.report;

import com.project.domain.report.MemberReportVO;

public interface MemberReportRepository { // 회원 신고 기능
	
	void memberReportInsert(MemberReportVO vo); // 회원 신고글 작성
	
	MemberReportVO memberReportRead(Long MemberRPTnum); // 회원 신고글 조회
	
	Long memberReportDelete(Long MemberRPTnum); // 회원 신고글 삭제
	
}
