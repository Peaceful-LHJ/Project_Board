package com.project.domain.report;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberReportVO { // 회원 신고 정보
	
	private Long memberRPTnum; // Member Report Number : 회원 신고 번호
	private String memberName; // 신고 대상 회원
	private String title;
	private String content;
	private String writer; // 신고글 작성자
	private LocalDateTime regDate; // Register Date : 작성일
	
}
