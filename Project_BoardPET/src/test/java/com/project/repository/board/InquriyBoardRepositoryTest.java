package com.project.repository.board;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.InquiryBoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class InquriyBoardRepositoryTest extends AppTest { // 문의게시글 repository 테스트
	
	@Autowired
	InquiryBoardRepository inquiryBoardRepository;
	
	@Ignore
	@Test
	public void inquiryBoardInsertTest() { // 문의게시글 작성 테스트
		InquiryBoardVO inquiryBoardVO = InquiryBoardVO.builder()
				.title("문의 테스트 제목")
				.content("문의 테스트 내용")
				.writer("작성자")
				.build();
		inquiryBoardRepository.inquiryBoardInsert(inquiryBoardVO);
	}
	
	@Ignore
	@Test
	public void inquiryBoardReadTest() { // 문의게시글 조회 테스트
		InquiryBoardVO inquiryBoardRead = inquiryBoardRepository.inquiryBoardRead(1L);
		log.info(inquiryBoardRead);
	}
	
	@Ignore
	@Test
	public void inquiryBoardDeleteTest() { // 문의게시글 삭제 테스트
		inquiryBoardRepository.inquiryBoardDelete(1L);
	}

}
