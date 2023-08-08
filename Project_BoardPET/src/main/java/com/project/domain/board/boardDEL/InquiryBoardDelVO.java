package com.project.domain.board.boardDEL;

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
public class InquiryBoardDelVO { // 삭제된 문의글 정보
	
	private Long delINQbno; // Delete Inquiry Board Number : 삭제된 문의글 번호
	private Long INQbno; // Inquiry Board Number
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate; // Register Date : 작성일
	private LocalDateTime updateDate; // 수정일
	
}
