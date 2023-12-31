package com.project.repository.board;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.NoticeBoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class NoticeBoardRepositoryTest extends AppTest { // 공지사항 repository 테스트
	
	@Autowired
	NoticeBoardRepository noticeBoardRepository;
	
	@Ignore
	@Test
	public void noticeBoardInsertTest() { // 공지사항 작성 테스트
		NoticeBoardVO noticeBoardVO = NoticeBoardVO.builder()
				.title("공지사항 테스트 제목")
				.content("공지사항 테스트 내용입니다...")
				.writer("관리자")
				.build();
		noticeBoardRepository.noticeBoardInsert(noticeBoardVO);
	}
	
	@Ignore
	@Test
	public void noticeBoardReadTest() { // 공지사항 조회 테스트
		Long NOTIbno = 1L; // 조회 할 공지사항 글 번호
		NoticeBoardVO noticeBoardRead = noticeBoardRepository.noticeBoardRead(NOTIbno);
		log.info(noticeBoardRead);
	}
	
	@Ignore
	@Test
	public void noticeBoardUpdateTest() { // 공지사항 수정 테스트
		Long NOTIbno = 1L; // 수정할 공지사항 글 번호
		NoticeBoardVO noticeBoardVO = NoticeBoardVO.builder()
				.NOTIbno(NOTIbno)
				.title("공지사항 제목 수정입니다")
				.content("공지사항 수정 내용입니다...!")
				.build();
		noticeBoardRepository.noticeBoardUpdate(noticeBoardVO);
		NoticeBoardVO noticeBoardRead = noticeBoardRepository.noticeBoardRead(NOTIbno);
		log.info(noticeBoardRead);
	}
	
	@Ignore
	@Test
	public void noticeBoardDeleteTest() { // 공지사항 글 영구삭제 테스트
		noticeBoardRepository.noticeBoardDelete(1L);
	}
	
}
