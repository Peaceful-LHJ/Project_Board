package com.project.repository.report;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.report.MemberReportVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberReportRepositoryTest extends AppTest {
	
	@Autowired
	MemberReportRepository memberReportRepository;
	
	@Ignore
	@Test
	public void memberReportInsertTest() {
		MemberReportVO memberReportVO = MemberReportVO.builder()
				.memberName("admin")
				.title("회원신고 테스트")
				.content("회원신고 테스트 내용")
				.writer("작성자")
				.build();
		memberReportRepository.memberReportInsert(memberReportVO);
	}
	
	@Ignore
	@Test
	public void memberReportReadTest() {
		MemberReportVO memberReportRead = memberReportRepository.memberReportRead(1L);
		log.info(memberReportRead);
	}
	
	@Ignore
	@Test
	public void memberReportDeleteTest() {
		memberReportRepository.memberReportDelete(1L);
	}
	
}
