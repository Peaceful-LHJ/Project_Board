package com.project.repository.report;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.report.CommentReportVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class CommentReportRepositoryTest extends AppTest {
	
	@Autowired
	CommentReportRepository commentReportRepository;
	
	@Ignore
	@Test
	public void commentReportInsertTest() {
		CommentReportVO commentReportVO = CommentReportVO.builder()
				.commentNum(1L)
				.title("댓글신고 테스트입니다")
				.content("댓글신고 테스트 내용")
				.writer("작성자")
				.build();
		commentReportRepository.commentReportInsert(commentReportVO);
	}
	
	@Ignore
	@Test
	public void commentReportReadTest() {
		CommentReportVO commentReportRead = commentReportRepository.commentReportRead(1L);
		log.info(commentReportRead);
	}
	
	@Ignore
	@Test
	public void commentReportDeleteTest() {
		commentReportRepository.commentReportDelete(1L);
	}

}
