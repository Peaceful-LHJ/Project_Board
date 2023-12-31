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
public class BoardDelVO { // 삭제된 자유게시글 정보
	
	private Long DELbno; // Delete Board Number : 삭제된 자유게시글 번호
	private Long bno; // Baord Number
	private String title;
	private String content;
	private String writer;
	private String commentCnt; // Comment Count : 댓글개수
	private Long boardLikeCnt; // Board Like Count : 추천 개수
	private LocalDateTime regDate; // Register Date : 작성일
	private LocalDateTime updateDate; // 수정일
	
}
