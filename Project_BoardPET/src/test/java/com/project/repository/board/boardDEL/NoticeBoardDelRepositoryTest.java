package com.project.repository.board.boardDEL;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.boardDEL.NoticeBoardDelVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class NoticeBoardDelRepositoryTest extends AppTest { // 삭제된 공지사항 repository 테스트
	
	@Autowired
	NoticeBoardDelRepository noticeBoardDelRepository;
	
	@Ignore
	@Test
	public void noticeBoardDelInsertTest() { // 공지사항 삭제테이블로 이동 테스트
		noticeBoardDelRepository.noticeBoardDelInsert(1L);
	}
	
	@Ignore
	@Test
	public void noticeBoardDelReadTest() { // 삭제된 공지사항 조회 테스트
		NoticeBoardDelVO noticeBoardDelRead = noticeBoardDelRepository.noticeBoardDelRead(1L);
		log.info(noticeBoardDelRead);
	}
	
	@Ignore
	@Test
	public void noticeBoardDelDeleteTest() { // 삭제된 공지사항 영구삭제
		noticeBoardDelRepository.noticeBoardDelDelete(1L);
	}

}
