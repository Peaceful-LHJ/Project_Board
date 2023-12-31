package com.project.domain.comment.commentDEL;

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
public class CommentDelVO { // 삭제된 댓글 정보
	
	private Long DELcommentNum; // Delete Comment Number : 삭제된 댓글 번호
	private Long commentNum;
	private String content;
	private String writer;
	private Long bno; // Board Number : 자유게시글 번호
	private Long QUESbno; // Question Board Number : 질문게시글 번호
	private LocalDateTime regDate; // Register Date : 작성일
	private LocalDateTime updateDate; // 수정일
	
}
