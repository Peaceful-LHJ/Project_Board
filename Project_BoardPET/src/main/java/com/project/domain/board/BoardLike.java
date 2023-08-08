package com.project.domain.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor	
@NoArgsConstructor
@ToString
public class BoardLike { // 자유게시글 추천 정보
	
	private Long bno; // Board Number
	private Long memberId;
	
}
