package com.project.repository.board;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardRepositoryTest extends AppTest {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Ignore
	@Test
	public void boardInsertTest() {
		BoardVO vo = BoardVO.builder()
				.title("작성 테스트 제목")
				.content("작성 테스트 내용...")
				.writer("작성자")
				.build();
		boardRepository.boardInsert(vo);
		log.info(vo);
	}
	
	@Ignore
	@Test
	public void boardReadTest() {
		BoardVO vo = boardRepository.boardRead(1L);
		log.info(vo);
	}
	
	@Ignore
	@Test
	public void boardDeleteTest() {
		Long vo = boardRepository.boardDelete(6L);
		log.info("삭제된 게시물 : " + vo);
	}
	
	@Ignore
	@Test
	public void boardUpdateTest() {
		BoardVO vo = BoardVO.builder()
				.bno(1L)
				.title("수정 테스트 제목")
				.content("수정 작성글 내용")
				.build();
		Long count = boardRepository.boardUpdate(vo);
		log.info("수정된 게시물 : " + count);
	}
	
	@Ignore
	@Test
	public void boardReadByNameTest() {
		List<BoardVO> boardReadByName = boardRepository.boardReadByName("작성자");
		log.info(boardReadByName);
	}
	
	@Ignore
	@Test
	public void boardDeleteListByNameTest() {
		Long boardDeleteListByName = boardRepository.boardDeleteListByName("작성자");
		log.info("해당 회원의 영구삭제된 자유게시글 수 : " + boardDeleteListByName);
	}
	
	@Ignore
	@Test
	public void selectBoardBnoByNameTest() { // 해당 자유게시글의 번호 추출 테스트
		List<Long> selectBoardBnoByName = boardRepository.selectBoardBnoByName("작성자");
		log.info(selectBoardBnoByName);
	}
	
}
