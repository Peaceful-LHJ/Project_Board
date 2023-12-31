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
public class AnswerFromDelVO { // 삭제된 질문게시글을 참조하는 답글 정보
	
	private Long fromDELanswerNum; // From Delete Answer Number : 삭제된 질문게시글을 참조하는 답글 번호
	private Long answerNum;
	private Long QUESbno; // Question Board Number
	private String content;
	private String writer;
	private LocalDateTime regDate; // Register Date : 작성일
	private LocalDateTime updateDate; // 수정일
	
}
