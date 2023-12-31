package com.project.repository.report;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.report.BoardReportVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardReportRepositoryTest extends AppTest { // 자유게시글 신고 기능 테스트
	
	@Autowired
	BoardReportRepository boardReportRepository;
	
	@Ignore
	@Test
	public void boardReportInsertTest() { // 자유게시글 신고 작성 테스트
		BoardReportVO boardReportVO = BoardReportVO.builder()
				.bno(1L)
				.title("자유게시글 신고 테스트입니다")
				.content("자유게시글 신고 테스트 내용")
				.writer("작성자")
				.build();
		boardReportRepository.boardReportInsert(boardReportVO);
	}
	
	@Ignore
	@Test
	public void boardReportReadTest() { // 자유게시글 신고 조회 테스트
		BoardReportVO boardReportRead = boardReportRepository.boardReportRead(1L);
		log.info(boardReportRead);
	}
	
	@Ignore
	@Test
	public void boardReportDeleteTest() { // 자유게시글 신고 삭제 테스트
		boardReportRepository.boardReportDelete(1L);
	}
	
}
