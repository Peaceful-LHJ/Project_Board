package com.project.repository.report;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.report.QuestionBoardReportVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionBoardReportRepositoryTest extends AppTest { // 질문게시글 신고 기능 테스트
	
	@Autowired
	QuestionBoardReportRepository questionBoardReportRepository;
	
	@Ignore
	@Test
	public void questionBoardReportInsertTest() { // 질문게시글 신고글 작성 테스트
		QuestionBoardReportVO questionBoardReportVO = QuestionBoardReportVO.builder()
				.QUESbno(1L)
				.title("질문글 신고 테스트 입니다")
				.content("질문글 신고 내용")
				.writer("작성자")
				.build();
		questionBoardReportRepository.questionBoardReportInsert(questionBoardReportVO);
	}
	
	@Ignore
	@Test
	public void questionBoardReportReadTest() { // 질문게시글 신고글 조회 테스트
		QuestionBoardReportVO questionBoardReportRead = questionBoardReportRepository.questionBoardReportRead(1L);
		log.info(questionBoardReportRead);
	}
	
	@Ignore
	@Test
	public void questionBoardReportDeleteTest() { // 질문게시글 신고글 삭제 테스트
		questionBoardReportRepository.questionBoardReportDelete(1L);
	}

}
