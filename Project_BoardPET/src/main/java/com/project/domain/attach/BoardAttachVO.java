package com.project.domain.attach;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardAttachVO { // 자유게시글 첨부파일 정보
	
	private String uuid; // Universally Unique IDentifier
	private Long bno; // Board Number : 자유게시글 번호
	private String uploadPath; // 업로드 파일 경로
	private String fileName;
	private boolean fileType;
	
}
