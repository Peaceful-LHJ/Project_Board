package com.project.domain.board;

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
public class BoardVO { // 자유게시글 정보
	
	private Long bno; // Baord Number
	private String title;
	private String content;
	private String writer;
	private String commentCnt; // Comment Count : 댓글개수
	private LocalDateTime regDate; // Register Date : 작성일
	private LocalDateTime updatetime; // 수정일
	
}
