package com.project.repository.board;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.boardDEL.BoardDelVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDelRepositoryTest extends AppTest {
	
	@Autowired
	BoardDelRepository boardDelRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Ignore
	@Test
	public void boardDelReadTest() {
		boardDelRepository.boardDelRead(1L);
	}
	
	@Ignore
	@Test
	public void boardDelInsertTest() { // 자유게시글 삭제 테이블로1 이동 및 해당 자유게시글 테이블 자료 삭제
		Long bno = boardDelRepository.boardDelInsert(3L); // 해당 데이터를 삭제 테이블로 이동
		BoardDelVO boardDelRead = boardDelRepository.boardDelRead(bno); // 정상적인 삽입 확인
		if(boardDelRead != null) {
			boardRepository.boardDelete(bno);
			log.info("삭제완료");
			return;
		}
		log.info("정상적인 삽입이 이뤄지지 않음");
	}
	
	@Test
	public void boardDeleteTest() {
		Long bno = 1L;
		BoardDelVO boardDelRead = boardDelRepository.boardDelRead(bno); // 정상적인 삽입 확인
		log.info("조회성공 : " + boardDelRead);
		if(boardDelRead != null) {
			boardRepository.boardDelete(bno);
			log.info("삭제완료");
		}
		log.info("정상적인 삽입이 이뤄지지 않음");
	}

}
