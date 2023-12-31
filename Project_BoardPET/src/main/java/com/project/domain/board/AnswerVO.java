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
public class AnswerVO { // 질문게시판 답글 정보
	
	private Long answerNum;
	private Long QUESbno; // Question Board Number
	private String content;
	private String writer;
	private LocalDateTime regDate; // Register Date : 작성일
	private LocalDateTime updateDate; // 수정일
	
}
