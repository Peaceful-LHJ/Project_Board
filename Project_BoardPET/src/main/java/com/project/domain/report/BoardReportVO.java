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
public class BoardReportVO { // 자유게시글 신고 정보
	
	private Long boardRPTnum; // Board Report Number : 자유게시글 신고 번호
	private Long bno; // Board Number : 자유게시글 번호
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate; // Register Date : 작성일
	
}
