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
public class QuestionBoardDelVO { // 삭제된 질문게시글 정보
	
	private Long delQUESbno; // Delete Question Board Number : 삭제된 질문게시글 번호
	private Long QUESbno; // Question Board Number
	private String title;
	private String content;
	private String writer;
	private Long answerCnt; // Answer Count : 답글 개수
	private Long commentCnt; // Comment Count : 댓글 개수
	private LocalDateTime regDate; // Register Date : 작성일
	private LocalDateTime updateDate; // 수정일
	
}
