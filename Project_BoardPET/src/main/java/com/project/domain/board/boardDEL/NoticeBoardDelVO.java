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
public class NoticeBoardDelVO { // 삭제된 공지사항 정보
	
	private Long delNOTIbno; // Delete Notice Baord Number : 삭제된 공지사항 번호
	private Long NOTIbno; // Notice Board Number
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate; // Register Date : 작성일
	private LocalDateTime updateDate; // 수정일
	
}
